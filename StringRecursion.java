/*
 * StringRecursion.java
 *
 * starter code by: Computer Science 111, Boston University
 * 
 * modified by: Aihoa Le
 * username: aihoale@bu.edu
 *
 * A class that contains recursive methods that operate on strings.
 */

public class StringRecursion {
    /* 
     * You may want to add test code for your methods to this
     * main method, although doing so is not required. 
     * See the section of the assignment entitled
     * "Testing your methods".
     * 
     * IMPORTANT: If your method does not return anything
     * (i.e., it is a void method), you should NOT try
     * to call it from within a println command. Instead,
     * you should call it on its own line -- for example:
     *     printSeries(3, 8);
     */
    public static void main(String[] args) {
        System.out.println("test 1 gives: " + numOccur('s', "Mississippi"));
        System.out.println("test 2 gives: " + numOccur('e', "Mississippi"));                   
        System.out.println("test 3 gives: " + removeVowels("Mississippi"));
        System.out.println("test 4 gives: " + removeVowels("apple"));                   
    }
    
    /*
     * numOccur - a recursive method that returns the number of times 
     * that the character ch occurs in the String str.
     * 
     * The main method includes two examples of using this method.
     *
     * You can also test this method by entering
     * StringRecursion.numOccur(ch, str) -- where ch is replaced 
     * by a char and str is replaced by a string -- in the 
     * Interactions Pane.
     */
    public static int numOccur(char ch, String str) {
        // base case
        if (str == null || str.equals("")) {
            return 0;
        }
    
        // recursive case
        int numOccurInRest = numOccur(ch, str.substring(1));
        if (ch == str.charAt(0)) {
            return 1 + numOccurInRest;
        } else {
            return numOccurInRest;
        }
    }

    /*
     * removeVowels - a recursive method that creates the String
     * that results from removing vowels from the String str.
     * 
     * The main method includes two examples of using this method.
     *
     * You can also test this method by entering
     * StringRecursion.removeVowels(str) -- where str is replaced
     * by a string -- in the Interactions Pane.
     * 
     * NOTE: There are examples of debugging printlns included below,
     * but they have been commented out.
     */
    public static String removeVowels(String str) {
        // System.out.println("starting removeVowels(" + str + ")");
        if (str == null || str.equals("")) {
            // System.out.println("removeVowels(" + str + ") returns " + str);
            return str;
        }
        
        String removedFromRest = removeVowels(str.substring(1));
        char first = str.charAt(0);
        
        // We assume that the string is all lowercase.
        if (first == 'a' || first == 'e' || first == 'i'
           || first == 'o' || first == 'u') {
            // System.out.println("removeVowels(" + str + ") returns " + removedFromRest);
            return removedFromRest;
        } else {
            // System.out.println("removeVowels(" + str + ") returns " + (first + removedFromRest));
            return first + removedFromRest;
        }
    }
    
    /*
     * ****** ADD YOUR METHODS BELOW **********
     *
     * Make sure to use the exact method headers
     * given in the assignment.
     */
    
    
    //printDoubled prints a new version of the string passed to it where 
    //each character of the string is doubled.
    public static void printDoubled(String str) {             
        if (str == null || str.equals("")) {
            System.out.println();
        } else {
            System.out.print(str.charAt(0) + "" + str.charAt(0));
            printDoubled(str.substring(1));
        }
    }    
    
    //printMirrored prints the string str followed by a string in which the
    //characters of str are reversed.
    public static void printMirrored(String str) {
        if (str == null || str.equals("")) {
            return;
        }
        System.out.print(str.charAt(0));                  
        printMirrored(str.substring(1));
        System.out.print(str.charAt(0));
    }
    
    //trim removes any leading or trailing spaces and returns the version of
    //the string without those spaces.
    public static String trim(String str) {
        if (str == null || str.equals("")) {
            return str;
        }
        if (str.charAt(0) == ' ' && str.charAt(0) == ' ') {
            return trim(str.substring(1, str.length()));
        } else if (str.charAt(0) == ' ') {
            return trim(str.substring(1));
        } else if (str.charAt(str.length() - 1) == ' ') {
            return trim(str.substring(0, str.length() - 1));
        }
        return str;    
    }

    //weave returns a new string formed by "weaving" the two strings passed
    //to it together.
    public static String weave(String str1, String str2) {
        if (str1 == null || str2 == null) {
            throw new IllegalArgumentException("the parameters cannot be null");
        }
        if (str1.equals("")) {
            return str2;
        } else if (str2.equals("")) {
            return str1;
        }
        char first = str1.charAt(0);
        char second = str2.charAt(0);
        String weavedString = weave(str1.substring(1), str2.substring(1));
        return first + "" + second + weavedString;
    }
    
    //lastIndexOf returns the index of the last occurence of a character in
    //a given string.
    public static int lastIndexOf(char ch, String str) {
        if (str == null || str.equals("")) {
            return -1;
        }
        if (str.charAt(str.length() - 1) == ch) {
            return str.length() - 1;
        } else {
            return lastIndexOf(ch, str.substring(0, str.length() - 1));
        }
    } 
    
}