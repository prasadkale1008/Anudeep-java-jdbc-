package Salon;

import java.util.*;
import java.time.LocalTime;
import java.time.LocalDate;

public class Date {
    /**
     * Attributes for representing the year, month, and day components of a date.
     * These attributes are used to store and retrieve the respective components of reservation and receipt dates.
     */
    private int year;
    private int month;
    private int day;

    /**
     * Default constructor for Date initializing attributes to zero.
     */
    public Date(){
        year=day=month=0;
    }

    /**
     * Constructor to set the reservation date, ensuring the input date is valid.
     * @param day   The day of the reservation (1-31).
     * @param month The month of the reservation (1-12).
     * @param year  The year of the reservation (2023 or later).
     */
    public Date(int day,int month,int year){
        if(year>=2023&&month<=12&&month>=1&&day<=31&&day>=1){
            this.day=day;
            this.month=month;
            this.year=year;}
        else{
            System.err.println("The date you entered is not correct! Please try again.");
        }
    }

    //setters & getters
    /**
     * Getter for the year.
     * @return The year of the date.
     */
    public int getYear() {
        return year;
    }

    /**
     * Setter for the year.
     * @param year The year to set.
     *             The year must be equal to or greater than 2023 to be considered valid.
     */
    public void setYear(int year) {
        if(year>=2023){
            this.year = year; }
    }

    /**
     * Getter for the month.
     * @return The month of the date.
     */
    public int getMonth() {
        return month;
    }

    /**
     * Setter for the month.
     * @param month The month to set.
     *              The month must be between 1 and 12 (inclusive) to be considered valid.
     */
    public void setMonth(int month) {
        if(month<=12&&month>=1){
            this.month = month;}
    }

    /**
     * Getter for the day.
     * @return The day of the date.
     */
    public int getDay() {
        return day;
    }

    /**
     * Setter for the day.
     * @param day The day to set.
     *            The day must be between 1 and 31 (inclusive) to be considered valid.
     */
    public void setDay(int day) {
        if(day<=31&&day>=1)
            this.day = day;
    }

    /**
     * Checks if the date falls within the specified valid range.
     * @return true if the date is within the valid range, otherwise false.
     */
    public boolean check(){
        if(year>=2023&&month<=12&&month>=1&&day<=31&&day>=1){
            return true;}
        else{
            return false;}
    }

    /**
     * Generates a string representation of the date.
     * @return The string representation of the date (DD/MM/YYYY).
     */
    @Override
    public String toString(){
        return day+"/"+month+"/"+year ;
    }

    /**
     * Overrides the equals method to compare Date objects.
     * @param obj The object to compare. Must be an instance of the Date class.
     * @return true if the objects are equal, otherwise false.
     */
    @Override
    public boolean equals(Object obj){
        Date d=(Date)obj;
        if (d.day==this.day && d.month==this.month && d.year==this.year)
            return true;
        else
            return false;
    }
}//Date class