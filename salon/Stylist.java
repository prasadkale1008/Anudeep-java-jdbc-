package Salon;

import java.util.*;

import Salon.Service;
import Salon.Person;

import java.time.LocalTime;
import java.time.LocalDate;

public class Stylist extends Person{

    /**
     * Attribute used to identify the stylist.
     */
    private String id;

    /**
     * Attribute used to define the job of the stylist.
     */
    private Service job;

    /**
     * Default constructor for Stylist.
     */
    public Stylist() {}

    /**
     * Constructor to set the name, phone number, stylist ID, and job of the stylist.
     * @param name       The name of the stylist.
     * @param phoneNumber The phone number of the stylist.
     * @param id         The ID of the stylist.
     * @param job        The job (service) assigned to the stylist.
     */
    public Stylist(String name,String phoneNumber,String id,Service job){
        super(name,phoneNumber);
        this.id = id;
        this.job = job;
    }

    //setters & getters
    /**
     * Getter for the stylist's ID.
     * @return String representing the stylist's ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Setter for the stylist's ID.
     * @param id The ID to set for the stylist.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter for the job (service) assigned to the stylist.
     * @return Service representing the stylist's job.
     */
    public Service getJob() {
        return job;
    }

    /**
     * Setter for the job (service) assigned to the stylist.
     * @param job The job (service) to set for the stylist.
     */
    public void setJob(Service job) {
        this.job = job;
    }

    /**
     * Overrides the toString method to display stylist information.
     * @return String representation of stylist's name, phone number, and ID.
     */
    @Override
    public String toString() {
        return "Name: " + super.getName() + "\nPhone Number: " + super.getPhoneNumber()+"\nID: " + id ;
    }
}//Stylist class