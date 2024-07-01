package Salon;

import java.util.*;
import java.time.LocalTime;
import java.time.LocalDate;

public class Person {
    /**
     * Attributes used to identify the name and phone number of the person (customer or stylist).
     */
    private String name;
    private String  phoneNumber="";

    /**
     * Default constructor for Person.
     */
    public Person() {}

    /**
     * Constructor to set the name and phone number of the person.
     * @param name        The name of the person.
     * @param phoneNumber The phone number of the person. Must be a 10-digit number.
     */
    public Person(String name, String phoneNumber) {
        this.name = name;

        // Validates and sets the phone number.
        if(phoneNumber.length()==10){
            this.phoneNumber = phoneNumber;
        }else{System.err.println("invalid phone Number :(");}
    }

    //setters & getters
    /**
     * Getter for the name.
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name.
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the phone number.
     * @return The phone number of the person.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setter for the phone number.
     * @param phoneNumber The phone number to set. Must be a 10-digit number.
     */
    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber.length()==10){
            this.phoneNumber = phoneNumber;
        }else{System.err.println("invalid phone Number :(");}
    }

    /**
     * Generates a string representation of the person's name and phone number.
     * @return String representation of the person.
     */
    @Override
    public String toString() {
        return "Name: " + name + "\nPhone Number:  " + phoneNumber;
    }

    /**
     * Overrides the equals method to compare Person objects by name and phone number.
     * @param obj The object to compare. Should be an instance of the Person class.
     * @return True if the objects are equal (matching name and phone number), otherwise false.
     */
    @Override
    public boolean equals(Object obj) {
        Person c =(Person)obj;
        if (c.getName().equalsIgnoreCase(this.name)&&c.getPhoneNumber().equals(this.phoneNumber)){
            return true;
        } else {
            return false;
        }
    }
}//Person class