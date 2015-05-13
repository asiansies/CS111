/*
 * TimeClient.java
 *
 * A sample client program for the Time class you will define in PS 9.
 *
 * Do not open until after completing tasks a-c.
 */
public class TimeClient {
    public static void main(String[] args) {
        Time t1 = new Time(11, 0, false);       // represents 11:00 AM
        int hour = t1.getHour();
        int min = t1.getMinute();
        System.out.print(hour + " " + min + " ");
        if (t1.isPM()) {
            System.out.println("PM");
        } else {
            System.out.println("AM");
        }
        System.out.println(t1);                 // uses toString()
        System.out.println();
        
        t1.advanceHour();
        t1.advanceMinute();
        System.out.print(t1.getHour() + " ");
        System.out.print(t1.getMinute() + " ");
        System.out.println(t1.isPM());
        System.out.println(t1);                 // uses toString
        System.out.println();
        
        t1 = new Time(11, 0, false);            // set back to 11:00 AM
        System.out.print(t1.getHour() + " "); 
        System.out.print(t1.getMinute() + " ");
        System.out.println(t1.isPM());
        
        t1.advanceMinute(80);
        System.out.print(t1.getHour() + " ");
        System.out.print(t1.getMinute() + " ");
        System.out.println(t1.isPM());
        System.out.println(t1);                 // uses toString
        System.out.println();
        
        t1 = new Time(3, 58, true);             // set to 3:58 PM
        System.out.print(t1.getHour() + " "); 
        System.out.print(t1.getMinute() + " ");
        System.out.println(t1.isPM());
        t1.advanceMinute();                     // advance by 2 minutes
        t1.advanceMinute();                     
        System.out.print(t1.getHour() + " ");
        System.out.print(t1.getMinute() + " ");
        System.out.println(t1.isPM());
        System.out.println(t1);                 // uses toString
        
        t1 = new Time(3, 58, true);             // set back to 3:58 PM
        System.out.print(t1.getHour() + " "); 
        System.out.print(t1.getMinute() + " ");
        System.out.println(t1.isPM());
        t1.advanceMinute(2);                    // advance by 2 minutes
        System.out.print(t1.getHour() + " ");
        System.out.print(t1.getMinute() + " ");
        System.out.println(t1.isPM());
        System.out.println();
        
        // Test equals method.
        t1 = new Time(5, 30, true);
        Time t2 = new Time(5, 30, true);
        Time t3 = new Time(6, 30, true);
        Time t4 = new Time(5, 45, true);
        Time t5 = new Time(5, 30, false);
        boolean sameTime = t1.equals(t2);
        System.out.print(sameTime + " ");
        System.out.print(t1.equals(t3) + " ");
        System.out.print(t1.equals(t4) + " ");
        System.out.print(t1.equals(t5) + " ");
        System.out.println();

        Time t = new Time(12, 0, true);
        // Try to create an invalid Time.
        try {
            t = new Time(30, 5, false);
        } catch(IllegalArgumentException e) {
            System.out.println("Caught an IllegalArgumentException...");
        }
        System.out.println(t);
    }
}