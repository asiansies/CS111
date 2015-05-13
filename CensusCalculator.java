/*
 * CensusCalculator.java
 * 
 * Computer Science 111, Boston University
 *
 * This program performs various computations on census data stored in a text file.
 * It uses arrays in several ways, including for storage of the results of
 * the computations.
 * 
 * modified by: Aihoa Le (aihoale@bu.edu)
 *        date: March 28, 2013
 */

import java.util.*;
import java.io.*;

public class CensusCalculator {
    /* the name of the data file */
    public static final String DATA_FILE_NAME = "census.txt";
    
    /* 
     * The number of population counts for each county.
     * Changing the value of this constant should be all that is needed
     * to allow your program to handle a data file with a different
     * number of counts.
     */
    public static final int NUM_POPULATION_COUNTS = 2;    
    
    /* 
     * A class-constant array of Strings containing the names of the states
     * in the data file.
     * 
     * The index of a given state name in the array is the
     * same as the numeric code of the state in the data file.
     * For example, Alaska has a state code of 1 in the data file, 
     * so its name is at position 1 in this array.
     */
    public static final String[] STATE_NAMES = {"Alabama", "Alaska",
        "Arizona", "Arkansas", "California", "Colorado", "Connecticut",
        "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois",
        "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine",
        "Maryland", "Massachusetts", "Michigan", "Minnesota",
        "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada",
        "New Hampshire", "New Jersey", "New Mexico", "New York",
        "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", 
        "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
        "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington",
        "West Virginia", "Wisconsin", "Wyoming", "District of Columbia"};
    
    /* 
     * A class-constant array of Strings containing the names of 
     * the nine divisions used by the Census Bureau.
     * 
     * The Census Bureau also numbers the divisions, and we have
     * used a division's number as its index in this array.
     * For example, New England is Division 1, so its name is at
     * position 1 in this array.
     * 
     * Note that there is no division 0, so we have put the name
     * "none" in position 0 of the array.
     */
    public static final String[] DIVISION_NAMES = {
        "none",
        "New England (CT,ME,MA,NH,RI,VT)            ", 
        "Mid-Atlantic (NJ,NY,PA)                    ", 
        "East North Central (IL,IN,MI,OH,WI)        ",
        "West North Central (IA,KS,MN,MO,NE,ND,SD)  ", 
        "South Atlantic (DE,FL,GA,MD,NC,SC,VA,WV,DC)", 
        "East South Central (AL,KY,MS,TN)           ",
        "West South Central (AR,LA,OK,TX)           ", 
        "Mountain (AZ,CO,ID,MT,NV,NM,UT,WY)         ", 
        "Pacific (AK,CA,HI,OR,WA)                   "};  
    
    /*
     * A class-constant array of integers that allows you to
     * determine the number of the division to which each
     * state belongs.
     * 
     * For example, Alaska has a state code of 1.
     * Element 1 of this array is the integer 9, which indicates
     * that Alaska is in division 9 (Pacific).
     */
    public static final int[] DIVISION_FOR_STATE = {6, 9,
        8, 7, 9, 8, 1, 5, 5, 5, 9, 8, 3, 3, 4, 4, 6, 7, 1, 5, 
        1, 3, 4, 6, 4, 8, 4, 8, 1, 2, 8, 2, 5, 4, 3, 7, 9, 2,
        1, 5, 4, 6, 7, 8, 1, 5, 9, 5, 3, 8, 5};
    
    /*
     * printOneDivision - prints the counts for a single division with the
     * specified name, old population (oldPop), and new population (newPop).
     * It computes the percent change for you. It displays the results so that
     * the full list of division results will be lined up in columns, and
     * it adds commas and rounds the percents to one place after the decimal.
     */
    public static void printOneDivision(String name, int oldPop, int newPop) {
        double percChange = (newPop - oldPop) * 100.0 / oldPop;
        System.out.printf("%43s\t  %,d\t  %,d\t  %4.1f%%\n", name, oldPop, newPop, percChange);
    }
    
    /*
     * getStateCode - finds and returns the state code for
     * the specified state name, and -1 if the specified
     * state name is not found.
     */    
    public static int getStateCode(Scanner console) {
        System.out.print("state name: ");
        String stateName = console.nextLine();
        int stateCode = -1;
        for (int i = 0; i < STATE_NAMES.length; i++){
            if (STATE_NAMES[i].equals(stateName)) {
                stateCode = i;
            }
        }
            if (stateCode == -1) {
            System.out.println(stateName + " is not a valid state name.");
        }
      return stateCode;  
    }
    
    /* printMenu - prints the program's menu to the console*/
    public static void printMenu() {
        System.out.println("MENU:");
        System.out.println("  1. compute state totals");
        System.out.println("  2. compute division totals");
        System.out.println("  3. quit");
    }
    
    /* 
     * getInt - error checks the user's inputs to ensure
     * that the user has entered an integer that is within
     * the range of 1-3. It will keep prompting the user to
     * enter an integer within the desired ranged until
     * the user does so.
     */
    public static int getInt(Scanner console) {
        System.out.print("Enter the number of your choice: ");
        while (!console.hasNextInt()) {
            console.nextLine();
            System.out.print("Not an integer. Try again: ");
        }
        int choice = console.nextInt();
        if (choice < 1 || choice > 3) {
            console.nextLine();
            System.out.println("Not a valid choice.");
            choice = getInt(console);
            return choice;
        } else {
            console.nextLine();   
        }
        return choice;
    }
    
    /*
     * calcPopTotals - uses the number of population counts to create an
     * array and calculate and return an array of population totals.
     */
    public static int[] calcPopTotals(int targetStateCode) throws FileNotFoundException {
        Scanner input = new Scanner(new File(DATA_FILE_NAME));
        input.useDelimiter("\t|\r\n|\n|\r");
        int[] popTotal = new int[NUM_POPULATION_COUNTS];
        while (input.hasNext()) {
            input.next();
            int stateCode = input.nextInt();
            if (stateCode == targetStateCode){
                for (int i = 0; i < NUM_POPULATION_COUNTS; i++) {
                    popTotal[i] += input.nextInt();
                }
            }
        }
        return popTotal;
    }
    
    /*
     * printPopTotals - takes in an array of population totals and 
     * prints the population totals.
     */
    public static void printPopTotals(int[] popTotals) {
        System.out.println("population totals:");
        for (int i = 0; i < popTotals.length; i++) {
            System.out.printf("  %,d\t\n", popTotals[i]);
        }
    }
    
    /* calcDivisionTotals - calculates the total population for each 
     * division. This methods indexes into the array for state divisions
     * in order to find the corresponding division for each state
     * and uses a cumulative sum to return a two-dimensional array 
     * containing totals for each division.
     */
    public static int[][] calcDivisionTotals(int numDivisions) throws FileNotFoundException {
        Scanner input = new Scanner(new File(DATA_FILE_NAME));
        input.useDelimiter("\t|\r\n|\n|\r");
        int[][] divisionTotals = new int[numDivisions][2];
        while (input.hasNext()) {
            input.next();
            int stateCode = input.nextInt();
            int division = DIVISION_FOR_STATE[stateCode];
            while (input.hasNextInt()) {
                divisionTotals[division][0] += input.nextInt();
                divisionTotals[division][1] += input.nextInt();
                input.nextLine();
            }
        }
        return divisionTotals;
    } 
    
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        boolean done = false;
        
        while (!done) {
            printMenu();        
            int choice = getInt(console);
            if (choice == 3) {
                done = true;
            } else if (choice == 1) {
                int stateCode = getStateCode(console);
                if (stateCode != -1) {
                    int[] popTotals = calcPopTotals(stateCode);
                    printPopTotals(popTotals);
                }
                System.out.println();
            } else if (choice == 2) {
                int[][] divisionTotals = calcDivisionTotals(DIVISION_NAMES.length);
                for (int i = 1; i < DIVISION_NAMES.length; i++) {
                    printOneDivision(DIVISION_NAMES[i], divisionTotals[i][0], divisionTotals[i][1]);
                }
                System.out.println();
            } 
        }
    }
}

