package model;

import java.util.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import model.Date;
import model.Booking;
import model.Stylist;
import model.Time;

public class Booking implements BookingManagement {
    private int id;
    private Customer customer;
    private Stylist stylist;
    public ArrayList<Service> allService;
    private Date date;
    private Time time; 
    private double price;

    public Booking() {
        allService = new ArrayList<>();
        customer = new Customer();
        stylist = new Stylist();

        long currentTimeMillis = System.currentTimeMillis();

        // Convert the current time in milliseconds to an Instant
        Instant instant = Instant.ofEpochMilli(currentTimeMillis);

        // Convert the Instant to a LocalDate in the system default time zone
        LocalDate currentDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();

        // Extract day, month, and year from the LocalDate
        int day = currentDate.getDayOfMonth();
        int month = currentDate.getMonthValue();
        int year = currentDate.getYear();

        date = new Date(day, month, year);
        time = new Time();
        this.price = 0.0;
    }

    public Booking(int id, Customer customer, Stylist stylist, Date date, Time time, double price) {
        this.id = id;
        this.customer = customer;
        this.stylist = stylist;
        this.date = date;
        this.time = time;
        this.price = price;
    }

    public Booking(Customer customer, Stylist stylist, Date date, Time time, double price) {
        this.customer = customer;
        this.stylist = stylist;
        this.date = date;
        this.time = time;
        this.price = price;
    }

    public void setId( int id ) {
        this.id = id; 
    }

    public int getId( ) {
        return this.id;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer c) {
        this.customer = c;
    }

    public Stylist getStylist() {
        return this.stylist;
    }

    public void setStylist(Stylist s) {
        this.stylist = s;
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


    public void addService(Service s) {
        allService.add(s);
    }

    public void deleteService(Service s) {
        allService.remove(s);
    }

    public void displayService() {
        for (int i = 0; i < allService.size(); i++) {
            System.out.println(allService.get(i));
            Stylist st = allService.get(i).getStylist();
            System.out.println(st);
            System.out.println("__________________");
        }
    }

    public void updateDate(Date d) {
        for (int i = 0; i < allService.size(); i++) {
            if (allService.get(i).getDate().equals(d)) {
                allService.get(i).setDate(d);
            }
        }
    }


    public void updateTime(Time t) {
        for (int i = 0; i < allService.size(); i++) {
            if (allService.get(i).getTime().equals(t)) {
                allService.get(i).setTime(t);
            }
        }
    }

    public boolean checkAvailability(Date d, Time t) {
        if (this.date.equals(d) && this.time.equals(t)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void calculatePrice() {
        double total = 0;
        for (int i = 0; i < allService.size(); i++) {
            Service ser = allService.get(i);
            total += ser.getPrice();
        }
        this.price = total;
    }

    @Override
    public String toString() {
        return "Booking:\nCustomer info:\n" + this.customer.getId() + "\nDate and time:\n" + date + "\t" + time;
    }
}
