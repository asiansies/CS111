//Aihoa Le (aihoale@bu.edu)
//Problem Set 4 | Part 2


//StringManipulator contains four static methods that manipulate strings.
public class StringManipulator {
    
    //printEveryOther takes a string and prints every other character in the string.
    public static void printEveryOther(String s) {
        for (int i = 0; i < s.length(); i +=2) {
            System.out.print(s.charAt(i));
        }
        System.out.println();
    }
    
    //printDiagonal prints each character of a string on a separate line with enough spaces so that 
    //the string is printed "diagonally".
    public static void printDiagonal(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            System.out.println(s.charAt(i));
        }
    }
    
    //longerLength takes in two strings and returns the length of the longer of the two.
    public static int longerLength(String r, String s) {
        int max = Math.max(r.length(), s.length());
        return max;
    }
    
    //interleave takes in two strings and returns a new string created by alternating characters 
    //from the strings.
    public static String interleave(String r, String s) {
        String newString = "";
        
        if (r.length() >= s.length()) {
            int i;
            for (i = 0; i < s.length(); i++) {
                newString = newString + r.charAt(i) + s.charAt(i);
            }
            newString = newString + r.substring(i);
        } else {
            int i;
            for (i = 0; i < r.length(); i++) {
                newString = newString + r.charAt(i) + s.charAt(i);
            }
            newString = newString + s.substring(i);
        }
        return newString;
    }
}