package model;

import model.Customer;
import model.Date;
import model.Time;
import model.Stylist;

public abstract class Service implements BookingManagement {
    private Service job;
    private double price;
    private Date date;
    private Time time;
    private Stylist stylist = new Stylist();
    private Customer customer;

    public Service() {}

    public Service(Date date, Time time) {
        this.date = date;
        this.time = time;
    }

    public Service(Date date, Time time, Stylist stylist) {
        this.date = date;
        this.time = time;
        this.stylist = stylist;
    }

    public Service(Service job) {
        this.job = job;
    }

    public Service(double price, Date date, Time time, Customer customer) {
        this.price = price;
        this.date = date;
        this.time = time;
        this.customer = customer;
    }

    public Service(double price, Date date, Time time, Customer customer, Service job) {
        this.price = price;
        this.date = date;
        this.time = time;
        this.customer = customer;
        this.job = job;
    }

    public Stylist getStylist() {
        return stylist;
    }

    public void setStylist(Stylist stylist) {
        this.stylist = stylist;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setJob(Service job) {
        this.job = job;
    }

    public Service getJob() {
        return this.job;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public abstract void calculatePrice();

    @Override
    public String toString() {
        return "Service:\nStylist: " + stylist + "\nPrice: " + getPrice();
    }

    @Override
    public boolean equals(Object obj) {
        Service s = (Service) obj;
        return s.date.equals(this.date) && s.time.equals(this.time) && s.stylist.equals(this.stylist);
    }
}
