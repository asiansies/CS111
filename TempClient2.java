public class TempClient2 {
    public static void main(String[] args) {
        Temperature t1 = new Temperature(0.0, 'C');        
        Temperature t2 = new Temperature(32.0, 'F');
        Temperature t3 = new Temperature(273.15, 'K');
        
        // *** Test the toString() method. ***
        // Note that we *don't* need to call it explicitly.
        // It gets called automatically as part of the concatenation.
        System.out.println("t1 = " + t1);
        System.out.println("t2 = " + t2);
        System.out.println("t3 = " + t3);
        System.out.println();
   
        // *** Test the valueIn and convertTo methods. ***
        System.out.println("The freezing point in Celcius is " + t1.getValue());
        double t1InF = t1.valueIn('F');
        System.out.println("The freezing point in Fahrenheit is " + t1InF);
        System.out.println("The freezing point in Kelvin is " + t1.valueIn('K'));

        System.out.println("t1 should be unchanged: " + t1);
        System.out.println();

        // Now convert it to Fahrenheit
        System.out.println("Converting t1 to Fahrenheit...");
        t1.convertTo('F');
        System.out.println("t1 = " + t1);
        System.out.println();

        // Now convert it to Kelvin
        t1 = new Temperature(0.0, 'C');
        System.out.println("Converting t1 to Kelvin...");
        t1.convertTo('K');
        System.out.println("t1 = " + t1);
        System.out.println();

        // Try to specify invalid parameters.
        System.out.println("Passing an invalid param to valueIn...");
        try {
            t1.valueIn('X');
            System.out.println("the required exception was NOT thrown.");
        } catch(IllegalArgumentException e) {
            System.out.println("The required exception was thrown.");
        }
        System.out.println("Passing an invalid param to convertTo...");
        try {
            t1.convertTo('X');
            System.out.println("the required exception was NOT thrown.");
        } catch(IllegalArgumentException e) {
            System.out.println("The required exception was thrown.");
        }
        System.out.println();
        
        t1 = new Temperature(0.0, 'C');
        Temperature t4 = new Temperature(32.0, 'C');                                             
        Temperature t5 = new Temperature(305.15, 'K');
        Temperature t6 = new Temperature(30.0, 'F');
        Temperature t7 = new Temperature(270.0, 'K');
        
        // *** Test the isBelowFreezing method. ***
        boolean isBelow = t1.isBelowFreezing();
        System.out.println("t1.isBelowFreezing() = " + isBelow);
        System.out.println("t4.isBelowFreezing() = " + t4.isBelowFreezing());
        System.out.println("t5.isBelowFreezing() = " + t5.isBelowFreezing());
        System.out.println("t6.isBelowFreezing() = " + t6.isBelowFreezing());
        System.out.println("t7.isBelowFreezing() = " + t7.isBelowFreezing());
        
        System.out.println("t1 should be unchanged: " + t1);
        System.out.println("t5 should be unchanged: " + t5);
        System.out.println();
        
        // *** Test the equals() method. ***
        boolean isEquiv = t1.equals(t1);
        System.out.println("t1.equals(t1) = " + isEquiv);
        System.out.println("t1.equals(t2) = " + t1.equals(t2));
        System.out.println("t2.equals(t3) = " + t2.equals(t3));
        System.out.println("t2.equals(t4) = " + t2.equals(t4));
        System.out.println("t4.equals(t5) = " + t4.equals(t5));
        System.out.println("t1.equals(t4) = " + t1.equals(t4));
        System.out.println("t1.equals(null) = " + t1.equals(null));
        
        System.out.println("t1 should be unchanged: " + t1);
        System.out.println("t5 should be unchanged: " + t5);
    }
}