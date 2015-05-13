/*
 * ClockClient1.java
 *
 * A sample client program for the Clock class you will define in PS 9.
 * 
 * Do not open until after completing tasks a-g.
 */
public class ClockClient1 {
    public static void main(String[] args) {
        Clock c = new Clock(3, 15, true);
        Time current = c.getCurrentTime();
        System.out.println(current);
        int count = c.getAlarmCount();
        System.out.println(count + " alarms");
        System.out.println();
        
        c.addAlarm(new Time(9, 30, false));
        c.addAlarm(new Time(7, 0, true));
        c.addAlarm(new Time(12, 0, true));
        System.out.println(c.getAlarmCount() + " alarms");        
        Time alarm = c.getAlarm(0);
        System.out.println("first alarm: " + alarm);
        System.out.println("third alarm: " + c.getAlarm(2));
        System.out.println();
        
        c = new Clock();           // use second constructor
        System.out.println(c.getCurrentTime());
        c.advanceCurrentHour();
        c.advanceCurrentMinute();        
        System.out.println(c.getCurrentTime());
        System.out.println();
        
        // Try to add an invalid alarm.
        try {
            c.addAlarm(null);
        } catch(IllegalArgumentException e) {
            System.out.println("Caught an IllegalArgumentException...");
        }
        System.out.println(c.getAlarmCount() + " alarms");        
    }
}