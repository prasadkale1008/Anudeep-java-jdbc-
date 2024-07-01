package Salon;

import java.util.*;
import java.time.LocalTime;
import java.time.LocalDate;

public class Time {
    /**
     * Attributes for representing the second, minute, and hour components of time.
     * These attributes are used to store and retrieve the respective components of reservation and receipt times.
     */
    private int second, minute, hours;

    /**
     * Default constructor for Time.
     */
    public Time() {}

    /**
     * Constructor to set the reservation time, ensuring it falls within working hours.
     * @param hours The hour of the reservation (10-22).
     * @param minute The minute of the reservation (0-59).
     */
    public Time(int hours, int minute) {
        if(hours>=10&&hours<=22&&minute<=60&&minute>=0){
            this.minute = minute;
            this.hours = hours;}
        else{
            System.err.println("Out of work time!");}
    }

    /**
     * Constructor to create an object for receipt time.
     * @param hours The hour of the receipt.
     * @param minute The minute of the receipt.
     * @param second The second of the receipt.
     */
    public Time(int hours, int minute, int second) {
        this.second = second;
        this.minute = minute;
        this.hours = hours;
    }

    //setters & getters
    /**
     * Getter for seconds.
     * @return The seconds of the time.
     */
    public int getSecond() {
        return second;
    }

    /**
     * Setter for seconds.
     * @param second The seconds to set.
     */
    public void setSecond(int second) {
        this.second = second;
    }

    /**
     * Getter for minutes.
     * @return The minutes of the time.
     */
    public int getMinute() {
        return minute;
    }

    /**
     * Setter for minutes.
     * Ensures that the input minute is within the range of 0 to 59 (inclusive).
     * @param minute The minute to set.
     */
    public void setMinute(int minute) {
        if(minute<=60&&minute>=0)
            this.minute = minute;
    }

    /**
     * Getter for hours.
     * @return The hours of the time.
     */
    public int getHours() {
        return hours;
    }

    /**
     * Setter for hours.
     * Ensures that the input hour is within the range of 10 to 22 (inclusive).
     * @param hours The hour to set.
     */
    public void setHours(int hours) {
        if(hours<=10&&hours>=22)
            this.hours = hours;
    }

    /**
     * Checks if the time falls within the specified work hours (10:00 - 22:00).
     * @return true if the time is within work hours, false otherwise.
     */
    public boolean check(){
        if(hours>=10&&hours<=22&&minute<=60&&minute>=0){
            return true;}
        else{
            return false;}
    }

    /**
     * Overrides the equals method to compare Time objects.
     * @param obj The object to compare. Must be an instance of the {@code Time} class.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj){
        Time t=(Time)obj;
        if (t.hours==this.hours && t.minute==this.minute)
            return true;
        else
            return false;
    }

    /**
     * Generates a string representation of the time.
     * @return The string representation of the time (HH:MM:SS).
     */
    @Override
    public String toString() {
        return "{" + hours + ":" + minute + ":" + second + '}';
    }
}//Time class