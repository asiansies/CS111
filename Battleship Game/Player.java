/*
 * Player.java - blueprint class for objects that represent a single
 * human player in the game of Battleship.
 * 
 */

import java.util.*;

public class Player {
    private String name;
    
    // PS 10: add one or more fields for the player's
    // collection of ships.
    private Ship[] ships;
    private int shipCount;
    
    /*
     * constructor for a Player with the specified name
     */
    public Player(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("name must have at least one character");
        }
        
        this.name = name;
        
        // PS 10: initialize the fields that you added above
        this.ships = new Ship[BattleshipGame.SHIPS_PER_PLAYER];
        this.shipCount = 0;
    }
    
    /*
     * getName - returns the name of the player
     */
    public String getName() {
        return this.name;
    }
    
    /*
     * addShip - add the specified ship to the player's collection of ships
     */
    public void addShip(Ship s) {
        if (s == null) {
            throw new IllegalArgumentException("parameter must be non-null");
        }
        
        // PS 10: add code to this method
        if (this.shipCount >= this.ships.length) {
            throw new IllegalStateException("maximum number of ships reached!");
        }
        
        this.ships[shipCount] = s;
        this.shipCount++;
        
        
    }
    
    /*
     * removeShip - removes the specified ship from the player's collection of ships
     */
    public void removeShip(Ship s) {
        if (s == null) {
            throw new IllegalArgumentException("parameter must be non-null");
        }
        
        // PS 10: add code to this method
        for (int i = 0; i < this.shipCount; i++) { 
            if (s.equals(ships[i])) {
                this.ships[i] = this.ships[this.shipCount - 1];
                this.ships[this.shipCount - 1] = null;
                this.shipCount--;
            } 
        }
        
    }
    
    /*
     * printShips - prints whatever ships remain in the player's collection
     */
    public void printShips() {
        // PS 10: implement this method
        for (int i = 0; i < this.shipCount; i++) {
            System.out.println(this.ships[i].toString());
        }
    }
    
    /*
     * hasLost - has this player lost the game?
     * Returns true if this is the case, and false otherwise.
     */
    public boolean hasLost() {
        // PS 10: implement this method
        return(this.shipCount == 0);
    }
    
    /*
     * nextGuess - returns a Guess object representing the player's
     * next guess for the location of a ship on the board specified
     * by the parameter otherBoard.
     */
    public Guess nextGuess(Scanner console, Board otherBoard) {
        int row;
        int col;
        
        // Keep randomly selecting coordinates until we get 
        // a position that has not already been tried.
        do {
            row = Board.RAND.nextInt(otherBoard.getDimension());
            col = Board.RAND.nextInt(otherBoard.getDimension());
        } while (otherBoard.hasBeenTried(row, col));
        
        Guess guess = new Guess(row, col);
        return guess;
    }
    
    /*
     * toString - returns a string representation of the player
     */
    public String toString() {
        return this.name;
    }
}