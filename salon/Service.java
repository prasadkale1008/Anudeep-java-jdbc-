package Salon;

import Salon.BookingManagement;
import Salon.Customer;
import Salon.Date;
import Salon.Time;
import Salon.Stylist;

public abstract class Service implements BookingManagement {
    /**
     * Attributes used to describe details of the customer's service.
     * These attributes are used to store and retrieve the price, date, time and stylist assigned to the service.
     */
    private double price;
    private Date date;
    private Time time;
    private Stylist stylist=new Stylist();
    //Maisa added this one
    /**
     * The customer for whom the service is scheduled.
     * We added this attribute to make the service to the customer
     */
    private Customer customer;

    /**
     * Default constructor for the Service class.
     */
    public Service(){}

    /**
     * Constructor to set the date and time for the service.
     * @param date The date of the service.
     * @param time The time of the service.
     */
    public Service(Date date,Time time){
        this.date=date;
        this.time=time;
    }

    /**
     * Constructor to set the date, time, and stylist for the service.
     * @param date    The date of the service.
     * @param time    The time of the service.
     * @param stylist The stylist for the service.
     */
    public Service(Date date,Time time,Stylist stylist){
        this.date=date;
        this.time=time;
        this.stylist=stylist;
    }

    //Maisa added this one
    /**
     * Constructor to set the price, date, time, and customer for the service.
     * @param price    The price of the service.
     * @param date     The date of the service.
     * @param time     The time of the service.
     * @param customer The customer for the service.
     */
    public Service(double price, Date date, Time time, Customer customer) {
        this.price = price;
        this.date = date;
        this.time = time;
        this.customer = customer;
    }

    //setters & getters
    /**
     * Getter for the stylist assigned to the service.
     * @return The Stylist object associated with the service.
     */
    public Stylist getStylist() {
        return stylist;
    }

    /**
     * Setter for the stylist assigned to the service.
     * @param stylist The Stylist object to assign to the service.
     */
    public void setStylist(Stylist stylist) {
        this.stylist = stylist;
    }

    /**
     * Getter for the date of the service.
     * @return The Date object representing the date of the service.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Setter for the date of the service.
     * @param date The Date object to set for the service.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Getter for the time of the service.
     * @return The Time object representing the time of the service.
     */
    public Time getTime() {
        return time;
    }

    /**
     * Setter for the time of the service.
     * @param time The Time object to set for the service.
     */
    public void setTime(Time time) {
        this.time = time;
    }

    /**
     * Getter for the price of the service.
     * @return The price of the service.
     */
    public double getPrice(){
        return price;
    }

    /**
     * Setter for the price of the service.
     * @param price The price to set for the service.
     */
    public void setPrice(double price){
        this.price=price;
    }

    /**
     * Getter for the customer for whom the service is scheduled.
     * @return The Customer object associated with the service.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Setter for the customer for whom the service is scheduled.
     * @param customer The Customer object associated with the service.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Calculates the price for the service.
     * Implementing classes will provide specific implementations for this method.
     */
    @Override
    public abstract void calculatePrice();

    /**
     * Returns a string representation of the service attributes.
     * @return A string representation of the service.
     */
    @Override
    public String toString() {
        return "Service:\nStylist: " + stylist +"\nPrice: "+getPrice();
    }

    /**
     * Checks if the service is equal to another object.
     * @param obj The object to compare. Must be an instance of Service.
     * @return True if the service is equal to the object, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        Service s=(Service)obj;
        if (s.date.equals(this.date)&&s.time.equals(this.time)&&s.stylist.equals(this.stylist)){
            return true;
        } else {
            return false;
        }
    }
}//Service class