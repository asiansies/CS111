public class TempClient1 {
    public static void processTemp(Temperature t) {
        double value = t.getValue();
        System.out.println("    getValue: " + value);
        char scale = t.getScale();
        System.out.println("    getScale: " + scale);
        String scaleName = t.getScaleName();
        System.out.println("getScaleName: " + scaleName);
        System.out.println();
    }
    
    public static void main(String[] args) {  
        System.out.println("temperature t1 (32.0 F):");
        Temperature t1 = new Temperature(32.0, 'F');     // first constructor
        processTemp(t1);
        
        System.out.println("temperature t2 (0.0 C):");
        Temperature t2 = new Temperature(0.0, 'C');      // first constructor
        processTemp(t2);
        
        System.out.println("temperature t3 (10.0 K):");
        Temperature t3 = new Temperature(10.0, 'K');     // first constructor
        processTemp(t3);
        
        System.out.println("temperature t4 (-20.0 C):");
        Temperature t4 = new Temperature(-20.0);         // second constructor
        processTemp(t4);
        
        System.out.println("changing t4 to 50.0 F...");
        t4.changeTo(50.0, 'F');
        processTemp(t4);
        
        // Try to create an invalid Temperature. 
        // We encourage you to add additional tests for invalid values.
        System.out.println("Trying to create a Temperature with a scale of X...");
        try {
            Temperature t5 = new Temperature(10.0, 'X');
            System.out.println("The required exception was NOT thrown.");
        } catch(IllegalArgumentException e) {
            System.out.println("The required exception was thrown.");
        }
        System.out.println();
        
        // Try to make an invalid change.
        System.out.println("Trying to change t4 to -10 K...");
        try {
            t4.changeTo(-10.0, 'K');
            System.out.println("the required exception was NOT thrown.");
        } catch(IllegalArgumentException e) {
            System.out.println("The required exception was thrown.");
            System.out.println("t4 should be unchanged:");
            processTemp(t4);
        }
    }
}