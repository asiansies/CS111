/**
 * MedicineDose.java
 * Computer Science 111, Boston University
 * 
 * base code provided by the course staff
 * 
 * algorithm implemented by: Aihoa Le (aihoale@bu.edu) 
 * 
 * This program converts the volume of a bottle of medicine
 * and computes the number of doses in the bottle.
 */

import java.util.*;

public class MedicineDose {
    public static void main(String[] args) {
        int volumeMilli;    // total volume in milliliters
        double dose;        // a single dose in teaspoons
        
        // Read the values from the user.
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the total volume to the nearest mL: ");
        volumeMilli = console.nextInt();
        System.out.print("Enter the dose amount in teaspoons: ");
        dose = console.nextDouble();
        
        /*
         * The lines above read the volume and dose amount 
         * from the user and store them in variables.
         * Fill in the rest of the program below, using those
         * variables to compute the values specified in
         * the assignment.
         */
        
        
        //Calculate number of teaspoons, tablespoons, and doses
        double totalTeaspoons = (volumeMilli/5);
        double totalTablespoons = (totalTeaspoons/3);
        int numTablespoons = (int)totalTablespoons;
        double numTeaspoons = totalTeaspoons % 3;
        double numDoses = totalTeaspoons/dose;
        int totalDoses = (int)numDoses;
        
        //Print total volume and number of doses
        System.out.println("The total volume is " + totalTeaspoons + " teaspoons (" 
                               + numTablespoons + " tablespoons and " + numTeaspoons 
                               + " teaspoons).");
        System.out.println("There is enough medicine for " + totalDoses + " full doses.");
    }
}