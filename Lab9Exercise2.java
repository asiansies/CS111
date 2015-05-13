public class Lab9Exercise2 {
    public static void main(String [] args) {
        String s1 = "GTCAAAC";
        String s2 = "CTCGACG";

        System.out.println("The edit distance between " + s1 + " and "
                + s2 + " is " + editDistance(s1, s2));
    }

    public static int editDistance(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            throw new IllegalArgumentException("need two strings of the same length");
        }

        // Complete the method below.
        if (s1.charAt(0) != s2.charAt(0)) {
            return 1 + editDistance(s1.substring(1), s2.substring(1));
        } else {
            return editDistance(s1.substring(1), s2.substring(1));
        }
        

    }
}
