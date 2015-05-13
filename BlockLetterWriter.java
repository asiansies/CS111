//Aihoa Le (username: aihoale)
//BlockLetterWriter.java prints the phrase "GOING, GOING, GONE" vertically down the page using a 
//sequence of println statements. 

public class BlockLetterWriter {
    public static void main (String[] args){
        writeGOING();
        writeGOING();
        writeG();
        writeO();
        writeN();
        writeE();
    }
    
    //Prints the word GOING and calls on spaces() to print a spaces between words.
    public static void writeGOING() {
        writeG();
        writeO();
        writeI();
        writeN();
        writeG();
        spaces();
    }
    
    //Prints the letter G to the console.
    public static void writeG() {
        System.out.println("+------");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|   --+");
        System.out.println("|     |");
        System.out.println("|     |");
        System.out.println("+-----+");
        System.out.println();
    }
    
    //Prints the letter O to the console.
    public static void writeO() {
        System.out.println("+-----+");
        System.out.println("|     |");
        System.out.println("|     |");
        System.out.println("|     |");
        System.out.println("|     |");
        System.out.println("|     |");
        System.out.println("+-----+");
        System.out.println();
    }
    
    //Prints the letter I to the console.
    public static void writeI() {
        System.out.println("---+---");
        System.out.println("   |");
        System.out.println("   |");
        System.out.println("   |");
        System.out.println("   |");
        System.out.println("   |");
        System.out.println("---+---");
        System.out.println();
    }
    
    //Prints the letter N to the console.
    public static void writeN() {
        System.out.println("|     |");
        System.out.println("|\\    |");
        System.out.println("| \\   |");
        System.out.println("|  \\  |");
        System.out.println("|   \\ |");
        System.out.println("|    \\|");
        System.out.println("|     |");
        System.out.println();
    }
    
    //Prints the letter E to the console.
    public static void writeE() {
        System.out.println("+------");
        System.out.println("|");
        System.out.println("|");
        System.out.println("+------");
        System.out.println("|");
        System.out.println("|");
        System.out.println("+------");
        System.out.println();
    }
    
    //Prints four blank lines to the console.
    public static void spaces() {
        for (int i=1; i < 4; i++)
            System.out.println();
    }
}