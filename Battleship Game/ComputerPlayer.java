/* 
 * Aihoa Le (aihoale@bu.edu)
 * Problem Set 10 | Part 2
 * 
 * ComputerPlayer.java - blueprint class for objects that represent an intelligent 
 * computer player.
 */

import java.util.*;

public class ComputerPlayer extends Player {
    private Guess firstGuess; 
    private Guess adj;
    private Guess north;
    private Guess south;
    private Guess east;
    private Guess west;
    private int lastGuessRow;
    private int lastGuessCol;
    
    //A constructor that creates an intelligent ComputerPlayer object.
    public ComputerPlayer(String name) {
        super(name);
        firstGuess = null;
        adj = null;
        north = null;
        south = null;
        east = null;
        west = null;
    }
    
    //nextGuess - returns a Guess object representing the player's next guess for the 
    //location of a ship on the board specified by the parameter otherBoard.
    public Guess nextGuess(Scanner console, Board otherBoard) {
        if (firstGuess == null) {
            firstGuess = super.nextGuess(console, otherBoard);
            return firstGuess;
        }
        
        this.lastGuessRow = firstGuess.getRow();
        this.lastGuessCol = firstGuess.getColumn();
        
        //If the last Guess was a hit and the ship was not sunk, the computer's
        //next guess will be spots adjacent to the last hit.
        if (otherBoard.previousHit(lastGuessRow, lastGuessCol)
                && !otherBoard.sunkShipAt(lastGuessRow, lastGuessCol)) {
            
            if (adj == null) {
                north = new Guess(lastGuessRow + 1, lastGuessCol);
                south = new Guess(lastGuessRow - 1, lastGuessCol);
                east = new Guess(lastGuessRow, lastGuessCol + 1);
                west = new Guess(lastGuessRow, lastGuessCol - 1);
            } else {
                lastGuessRow = adj.getRow();
                lastGuessCol = adj.getColumn();
                if (otherBoard.previousHit(lastGuessRow, lastGuessCol)) {
                    if (!otherBoard.sunkShipAt(lastGuessRow, lastGuessCol)){
                        //Checks line in adj direction
                        adj = nextInLine(otherBoard); 
                        if (adj == null
                                || otherBoard.hasBeenTried(adj.getRow(), adj.getColumn())) {
                            adj = new Guess(lastGuessRow, lastGuessCol);
                            adj = oppositeInLine(otherBoard);
                            if (adj == null
                                    || otherBoard.hasBeenTried(adj.getRow(), adj.getColumn())) {
                                firstGuess = super.nextGuess(console, otherBoard);
                                return firstGuess;
                            } else {  
                                return adj;
                            }
                        }
                        return adj;               
                    }
                    //Returns random guess if ship has been sunk.
                    adj = null;
                    firstGuess = super.nextGuess(console, otherBoard);
                    return firstGuess;
                }
            }
            
            //Looks for next valid adjacent position. 
            if (north.getRow() < otherBoard.getDimension()
                    && !otherBoard.hasBeenTried(north.getRow(), north.getColumn())) {
                adj = north;
                return adj;
            } else if (south.getRow() >= 0
                           && !otherBoard.hasBeenTried(south.getRow(), south.getColumn())) {
                adj = south;
                return adj;
            } else if (east.getColumn() < otherBoard.getDimension()
                           && !otherBoard.hasBeenTried(east.getRow(), east.getColumn())) {
                adj = east;
                return adj;
            } else if (west.getColumn() >= 0
                           && !otherBoard.hasBeenTried(west.getRow(), west.getColumn())) {
                adj = west;
                return adj;
            }
            adj = null; 
        } 
        
        //Returns random guess.
        firstGuess = super.nextGuess(console, otherBoard);
        return firstGuess;
    }
    
    //Helper method that returns the next position in a line of hits
    private Guess nextInLine(Board board) {
        if (firstGuess.getRow() == adj.getRow()) {
            if (adj.getColumn() < firstGuess.getColumn()) {
                if (adj.getColumn() - 1 > 0) {
                    return new Guess(adj.getRow(), adj.getColumn() - 1);
                } else {
                    return null; //Returns null if next in line is out of bounds 
                }
            } else {
                if (adj.getColumn() + 1 < board.getDimension()) {
                    return new Guess(adj.getRow(), adj.getColumn() + 1);
                } else {
                    return null; //Returns null if next in line is out of bounds 
                }
            } 
        }
        
        if (firstGuess.getColumn() == adj.getColumn()) {
            if (adj.getRow() < firstGuess.getRow()) {
                if (adj.getRow() - 1 > 0) {
                    return new Guess(adj.getRow() - 1, adj.getColumn());
                } else {
                    return null; //Next in line is out of bounds 
                }
            } else {
                if (adj.getRow() + 1 < board.getDimension()) {
                    return new Guess(adj.getRow() + 1, adj.getColumn());
                } else {
                    return null; //Next in line is out of bounds 
                }
            } 
        }
        return null;
    }  
    
    //Helper method that returns the next position in a line of hits in the opposite direction
    private Guess oppositeInLine(Board board) {
        if (firstGuess.getRow() == adj.getRow()) {
            if (adj.getColumn() < firstGuess.getColumn()) {
                if (firstGuess.getColumn() + 1 < board.getDimension()) {
                    return new Guess(adj.getRow(), firstGuess.getColumn() + 1);
                } else {
                    return null; //Next in line is out of bounds 
                }
            } else {
                if (firstGuess.getColumn() - 1 > 0) {
                    return new Guess(adj.getRow(), firstGuess.getColumn() - 1);
                } else {
                    return null; //Next in line is out of bounds 
                }
            } 
        }
        
        if (firstGuess.getColumn() == adj.getColumn()) {
            if (adj.getRow() < firstGuess.getRow()) {
                if (firstGuess.getRow() + 1 < board.getDimension()) {
                    return new Guess(firstGuess.getRow() + 1, adj.getColumn());
                } else {
                    return null; //Next in line is out of bounds 
                }
            } else {
                if (firstGuess.getRow() - 1 > 0) {
                    return new Guess(firstGuess.getRow() - 1, adj.getColumn());
                } else {
                    return null; //Next in line is out of bounds 
                }
            } 
        }
        return null;
    }
}
