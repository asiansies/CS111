/* 
 * Aihoa Le (aihoale@bu.edu)
 * Problem Set 10 | Part 2
 * 
 * Ship.java - blueprint class for objects that represent a single ship.
 */


public class Ship {
    private String type;
    private int length;
    private int numHits;
    
    //A constructor that takes in parameters for the Ship's type and length.
    public Ship(String type, int length) {
        if (type == null || type == "") {
            throw new IllegalArgumentException();
        }
        if (length < 1) {
            throw new IllegalArgumentException();
        }
        
        this.type = type;
        this.length = length;
        this.numHits = 0;
    }
    
    //Returns the type of ship.
    public String getType() {
        return this.type;
    }
    
    //Returns the first character of the ship's type. Used when displaying 
    //a ship on a board.
    public char getSymbol() {
        return this.type.charAt(0);
    }
    
    //Returns the length of the ship.
    public int getLength() {
        return this.length;
    }
    
    //Returns the number of times a ship has been hit.
    public int getNumHits() {
        return this.numHits;
    }
    
    //Increments the ship's number of hits by 1.
    public void applyHit() {
        this.numHits++;
    }
    
    //Returns whether or not a ship has been sunk.
    public boolean isSunk() {
        return (this.numHits >= this.length);
        
    }
    
    //Returns a string representation of a ship object.
    public String toString() {
        return this.type + " of length " + this.length;
    }
}

