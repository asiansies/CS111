/**
 * ChildShoe.java
 * Computer Science 111, Boston University
 * 
 * base code provided by the course staff
 * 
 * algorithm implemented by: Aihoa Le (aihoale@bu.edu) 
 * 
 * This program computes the maximum length of a child's foot
 * that will fit in a shoe of a specified size.
 */

import java.util.*;

public class ChildShoe {
    public static void main(String[] args) {
        double shoeSize;    // size of the shoe
        double footLength;  // length of the child's foot in cm
        
        // Read the values from the user.
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the size of the shoe: ");
        shoeSize = console.nextDouble();
        System.out.print("Enter the length of the child's longer foot in cm: ");
        footLength = console.nextDouble();
          
        /*
         * The lines above read the shoe size and foot length
         * from the user and store them in variables.
         * Fill in the rest of the program below, using 
         * those variables to compute the values specified
         * in the assignment.
         */
        
        
        // Calculate maximum foot length in inches and converts original foot length input to 
        // inches.
        double maxLength;
        double footLengthInch;
        maxLength = (shoeSize/3) + 3.9;
        footLengthInch = footLength/2.54;
        
        // Print calculations
        System.out.println("Size " + shoeSize + " shoes work with feet up to " + footLengthInch + 
                           " inches (" + footLength + " cm) long.");
        if (footLengthInch < maxLength) {
            System.out.println("These shoes will fit!");
        } else {
            System.out.println("These shoes won't fit. Try a larger size.");
        }        
    }
}