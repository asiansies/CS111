/*
 * PartOne.java
 *
 * Computer Science 111, Boston University
 * 
 * A class that contains methods from Part I of PS 7.
 */

public class PartOne {
    public static void printPattern(int m, int n) {
        if (m == n) {
            return;
        }
        
        if (m < n) {
            System.out.print("(");
            printPattern(m + 1, n);
            System.out.print("\\");     /* prints a single backslash */
        } else {
            System.out.print("/");
            printPattern(m, n + 1);
            System.out.print(")");
        }
    }
    
    
    public static void printPattern2(int m, int n) {
        if (m == n) {
            return;
        }
        
        if (m < n) {
            System.out.print("\\");
            printPattern2(m + 1, n);
            System.out.print("(");     /* prints a single backslash */
        } else {
            System.out.print(")");
            printPattern2(m, n + 1);
            System.out.print("/");
        }
    }
    
    public static int mystery(int a, int b) {
        if (a * b == 0) {
            return a;
        } else {
            return b + mystery(a - 1, b - 2);
        }
    }
}