/* Aihoa Le (aihoale@bu.edu)
 * Problem Set 8 | Part 2
 * 
 * The Temperature class serves as a blueprint for objects that can be used to represent
 * temperature readings.
 */

public class Temperature {
    private double value;
    private char scale;
    
    //changeTo changes both the value and the scale of a Temperature object and checks that only
    //valid values are assigned.
    public void changeTo(double value, char scale) {
        if (scale != 'F' && scale != 'C' && scale != 'K') {
            throw new IllegalArgumentException("Scale must be an uppercase character!");
        }
        if ((scale == 'F' && value < -459.67) || (scale == 'C' && value < -273.15) || (scale == 'K' && value < 0.0)) {
            throw new IllegalArgumentException("Invalid temperature value!");
        }
        this.value = value;
        this.scale = scale;
    }
    
    //getValue is an accessor method that returns the Temperature object's value.
    public double getValue() {
        return this.value;
    }
    
    //getScale is an accessor method that returns the Temperature object's scale.
    public char getScale() {
        return this.scale;
    }
    
    //getScaleName returns the full name of the scale of the Temperature object.
    public String getScaleName() {
        if (this.scale == 'F') {
            return "Fahrenheit";
        } else if (this.scale == 'C') {
            return "Celsius";
        } else {
            return "Kelvin";
        }
    }
    
    //A constructor that takes in two parameters.
    public Temperature(double value, char scale) {
        this.changeTo(value, scale);
    }
    
    //A constructor that takes in one parameter and sets the Temperature object's scale to
    //Celsius.
    public Temperature(double value) {
        this.changeTo(value, 'C');
    }
    
    //valueIn returns the value of the Temperature object in the scale that is passed in
    //to it.
    public double valueIn(char scale) {
        if (scale != 'F' && scale != 'C' && scale != 'K') {
            throw new IllegalArgumentException("The scale you entered is not valid!");
        }
        if (scale == 'F') {
            if (this.scale == 'C') {
                return ((this.value * (9.0/5)) + 32);
            } else if (this.scale == 'K') {
                return (this.value * (9.0/5) - 459.67);
            }
        }
        if (scale == 'C') {
            if (this.scale == 'F') {
                return ((this.value - 32) * (5.0/9));
            } else if (this.scale == 'K') {
                return (this.value - 273.15);
            }
        }
        if (scale == 'K') {
            if (this.scale == 'F') {
                return ((this.value + 459.67) * (5/9));
            } else if (this.scale == 'C') {
                return (this.value + 273.15);
            }
        }
        return this.value;
    }
    
    //convertTo converts the temperature represented by a Temperature object into the scale
    //that is passed in to it.
    public void convertTo(char scale) {
        this.value = this.valueIn(scale);
        this.scale = scale;
    }
    
    //toString returns a String representation of a Temperature object in th form "value
    //°scale.
    public String toString() {
        if (this.scale == 'F' || this.scale == 'C') {
            return (this.value + " °" + this.scale);
        } else {
            return (this.value + " " + this.scale);
        }
    }
    
    //isBelowFreezing returns whether or not a Temperature objects value is below the 
    //freezing point.
    public boolean isBelowFreezing() {
        return (this.valueIn('C') < 0.0);
    } 
    
    //equals returns whether or not two Temperature objects represent the same temperature
    public boolean equals(Temperature t) {
        if (t == null) {
            return false;
        } else {
            return (Math.abs(this.value - t.valueIn(this.scale)) < 0.0000001);
        }
    }
}