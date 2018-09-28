/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignments.modules.module008;

import java.util.Date;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class Fan {

    // Speed constants.
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    // Private data fields.
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    /**
     * No-args constructor setting the default values using explicit constructor
     * invocation.
     */
    public Fan() {
        // Using the this keyword in this particular context allows us to invoke another constructor by passing the correct parameter types.
        this(SLOW, false, 5, "blue");
    }

    /**
     * Constructor taking starting values for each of the data fields pertaining
     * to the Fan's state.
     *
     * @param speed is the initial speed of the fan.
     * @param on is whether or not fan is on initially.
     * @param radius is the initial radius of the fan.
     * @param color is the initial color of the fan.
     */
    public Fan(final int speed, final boolean on, final double radius, final String color) {
        // Using the this keyword in this context allows us to reference the instance variables of the object instead of the local variables in this constructor.
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    /**
     * Returns info about the particular fan instance.
     *
     * We use the @Override annotation to indicate that we are overriding the
     * superclass implementation of the "public String toString()" method. All
     * classes are subclasses of Object which is the class declaring the "public
     * String toString()" method initially.
     *
     * @return the String representation of the fan defined in the method.
     */
    @Override
    public String toString() {
        return this.on ? "Speed is " + this.speed + ", Color is " + this.color + ", Radius is " + this.radius + "." : "Color is " + this.color + ", Radius is " + this.radius + ". Fan is off.";
    }

    /**
     * Returns the above prefixed by the current date.
     *
     * We do not @Override this method as the below method signature is not a
     * declared method in the Object superclass.
     *
     * @param date is an arbritrary Date object used to prefix the toString()
     * method by whatever date is stored in it. Most likely the current date.
     * @return the toString() method prefixed by the string value of the Date
     * object.
     */
    public String toString(final Date date) {
        return date.toString() + ": " + this.toString();
    }

    // Below are all getters/accessors and setters/mutators for our data fields. 
    // Used to follow one of the four core principles of OOP; Encapsulation.
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(final int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(final boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(final double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(final String color) {
        this.color = color;
    }
}
