/* Aihoa Le (aihoale@bu.edu)
 * Problem Set 9 | Part 2
 * 
 * The Clock class serves as a blueprint for objects that can be used to maintain
 * the states of a clock
 */

public class Clock {
    private Time t;
    private Time[] alarmTimes;
    private int alarmCount;
    
    //A constructor for Clock objects that takes in parameters for hour, minute, and 
    //AM/PM components of the time.
    public Clock(int hour, int minute, boolean isPM) {
        this.t = new Time(hour, minute, isPM);
        this.alarmTimes = new Time[10];
        this.alarmCount = 0;
    }
    
    //A constructor for Clock objects that creates a Clock with a current time of 12:00 PM.
    public Clock() {
        this(12, 0, true);
    }
    
    //addAlarm takes a specified Time object and adds it to the collection of alarms.
    public void addAlarm(Time t) {
        if (t == null || this.alarmCount == this.alarmTimes.length) {
            throw new IllegalArgumentException("Sorry, there's no more room!");
        }
        this.alarmTimes[this.alarmCount] = t;
        this.alarmCount++;
    }
    
    //Returns the current time.
    public Time getCurrentTime() {
        return this.t;
    }
    
    //Returns the number of alarms that are currently stored on the clock.
    public int getAlarmCount() {
        return this.alarmCount;
    }
    
    //Returns the Time object at a specified index.
    public Time getAlarm(int i){
        if (i < 0 || i >= this.alarmCount){
            throw new IllegalArgumentException("Invalid index!");
        }
        return this.alarmTimes[i];
    }
    
    //advanceCurrentHour advances the current time by 1 hour.
    public void advanceCurrentHour() {
        this.t.advanceHour();
    }
    
    //advanceCurrentMinute advances the current time by 1 minute.
    public void advanceCurrentMinute() {
        this.t.advanceMinute();
    }
    
    //printAlarms prints the clock's alarm times if it has any.
    public void printAlarms() {
        if (this.alarmCount > 0) {
            for (int i = 0; i < this.alarmCount; i++) {
                System.out.println(alarmTimes[i]);
            }
        } else {
            System.out.println("No alarms have been set.");
        }
        
    }
    
    //Returns whether or not an alarm shoud sound.
    public boolean alarmShouldSound() {
        for (int i = 0; i < this.alarmCount; i++) {
            if (this.t.equals(this.alarmTimes[i])) {
                return true;
            }    
        }
        return false;
    }
    
    //removeAlarm removes a specified alarm and rearranges the remaining alarms to 
    //occupy the leftmost positions of the array.
    public void removeAlarm(int i) {
        if (i < 0 || i >= this.alarmCount){
            throw new IllegalArgumentException("Invalid index!");
        }
        this.alarmTimes[i] = this.alarmTimes[this.alarmCount - 1];
        this.alarmCount--;
    }
    
    //toString returns a String representation of the called clock object.
    public String toString() {
        if (this.alarmShouldSound()) {
            return (this.t.toString() + " *** ALARM!! ***");
        } else {
            return (this.t.toString() + nextAlarm());
        }
    }
    
    //nextAlarm returns the next alarm time    
    private String nextAlarm() {
        if (alarmCount == 0) {
            return "";
        }
        Time possAlarm = new Time (this.t.getHour(), this.t.getMinute(), this.t.isPM());
        possAlarm.advanceMinute();
        
        while (!possAlarm.equals(this.getCurrentTime())){
            for (int i = 0; i < this.alarmCount; i++) {
                if (possAlarm.equals(this.alarmTimes[i])) {
                    return " (next alarm scheduled for " + possAlarm.toString() + ")";                
                }
            }
            possAlarm.advanceMinute();
        }
        return "";
    }
}