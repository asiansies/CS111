/* 
 * Aihoa Le (aihoale@bu.edu)
 * Problem Set 10 | Part 2
 * 
 * HumanPlayer.java - blueprint class for objects that represent a human player.
 */

import java.util.*;

public class HumanPlayer extends Player {
    
    //A constructor that creates a HumanPlyaer object.
    public HumanPlayer(String name) {
        super(name);
    }
    
    //nextGuess - allows the user to enter their next guess.
    public Guess nextGuess(Scanner console, Board otherBoard) {
        int row;
        int col;
        
        System.out.println("Enter your guess.");
        System.out.print("     row: ");
        row = console.nextInt();
        
        System.out.print("  column: ");
        col = console.nextInt();
        
        
        Guess guess = new Guess(row, col);
        return guess;
    }
    
}

