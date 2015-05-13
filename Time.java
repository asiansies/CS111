/* Aihoa Le (aihoale@bu.edu)
 * Problem Set 9 | Part 2
 * 
 * The Time class serves as a blueprint for objects that can be used to represent times
 * maintained by a clock program.
 */

public class Time {
    private int hour;
    private int minute;
    private boolean isPM;
    
    //A constructor for Time objects.
    public Time(int hour, int minute, boolean isPM) {
        if (hour < 1 || hour > 12) {
            throw new IllegalArgumentException("Invalid hour!");
        }
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Invalid minute!");
        }
        
        this.hour = hour;
        this.minute = minute;
        this.isPM = isPM;
        
    }
    
    //An accessor method that returns the hour component of a Time object.
    public int getHour() {
        return this.hour;
    }
    
    //An accessor method that returns the minute component of a Time object.
    public int getMinute() {
        return this.minute;
    }
    
    //isPM returns true if the Time is PM and false if it is AM.
    public boolean isPM() {
        return this.isPM;
    }
    
    //advanceHour advances the Time by 1 hour.
    public void advanceHour() {
        if (this.hour == 11){
            this.hour++;
            this.isPM = !isPM;
        } else if (this.hour == 12) {
            this.hour = 1;
        } else {
            this.hour++;
        }
    }
    
    //advanceMinute advances the Time by 1 minute. advanceMinute advances the time by 
    //1 hour if the current minute component is 59.
    public void advanceMinute() {
        if (this.minute == 59) {
            this.minute = 00;
            this.advanceHour();
        } else {
            this.minute++;
        }
    }
    
    //advanceMinute advances the Time by a specified number of minutes.
    public void advanceMinute(int numMin) {
        if (numMin < 0) {
            throw new IllegalArgumentException("Invalid number of minutes.");
        }
        for (int i = 0; i < (numMin / 60); i++) {
            advanceHour();
        }
        for (int i = 0; i < (numMin % 60); i++) {
            advanceMinute();
        }
    }
    
    //toString returns a String representation of the called Time object.
    public String toString() {
        if (this.minute < 10) {
            if (isPM) {
                return (this.hour + ":0" + this.minute + " PM");
            } else {
                return (this.hour + ":0" + this.minute + " AM");
            }
        } else {
            if (isPM) {
                return (this.hour + ":" + this.minute + " PM");
            } else { 
                return (this.hour + ":" + this.minute + " AM");
            }
        }
    }
    
    //equals determines if two Time objects are the same based on their hour, minute, 
    //and AM/PM components.
    public boolean equals(Time t) {
        return (this.hour == t.hour && this.minute == t.minute && this.isPM == t.isPM);
    }
}