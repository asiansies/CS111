/*
 * ClockClient2.java
 *
 * A sample client program for the Clock class you will define in PS 9.
 * 
 * Do not open until after completing tasks a-h.
 */
public class ClockClient2 {
    public static void main(String[] args) {
        Clock c = new Clock(3, 15, true);
        Time current = c.getCurrentTime();
        System.out.println("Current time: " + current);
        
        // No alarms
        c.printAlarms();
        System.out.print("Alarm ");
        if (c.alarmShouldSound()) {
            System.out.println("should sound");
        } else {
            System.out.println("should not sound");
        }
        System.out.println(c);     // uses toString
        System.out.println();
        
        // 3 alarms -- none of which should sounding
        c.addAlarm(new Time(3, 10, true));
        c.addAlarm(new Time(9, 30, false));
        c.addAlarm(new Time(7, 0, true));
        int count = c.getAlarmCount();
        System.out.println(count + " alarms");
        c.printAlarms();        
        System.out.print("Alarm ");
        if (c.alarmShouldSound()) {
            System.out.println("should sound");
        } else {
            System.out.println("should not sound");
        }
        System.out.println(c);     // uses toString
        System.out.println();
        
        // Remove one alarm
        c.removeAlarm(0);
        System.out.println(c.getAlarmCount() + " alarms");
        c.printAlarms();        
        System.out.print("Alarm ");
        if (c.alarmShouldSound()) {
            System.out.println("should sound");
        } else {
            System.out.println("should not sound");
        }
        System.out.println(c);     // uses toString
        System.out.println();
        
        // Add an alarm that should sound.
        c.addAlarm(new Time(3, 15, true));
        System.out.println(count + " alarms");
        c.printAlarms();        
        System.out.print("Alarm ");
        if (c.alarmShouldSound()) {
            System.out.println("should sound");
        } else {
            System.out.println("should not sound");
        }
        System.out.println(c);     // uses toString
        System.out.println();
    }
}