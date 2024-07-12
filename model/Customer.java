package model;

import java.util.*;
import java.time.LocalTime;
import java.time.LocalDate;
import model.Person;

public class Customer extends Person {
    private int Id;
    private String phoneNumber;
    private String CreditCardNo;

    public Customer() {
        super();
        
    }

    public Customer(String name, String phoneNumber, String CreditCardNo) {
        super(name, phoneNumber);
        
        this.phoneNumber = phoneNumber;
        
        if (CreditCardNo.length() == 16) {
            this.CreditCardNo = CreditCardNo;
        } else {
            System.err.println("Invalid Credit Card Number :(");
        }
    }

    public Customer(int id, String name, String phoneNumber, String CreditCardNo) {
        super(name, phoneNumber);
        
        this.Id = id;
        this.phoneNumber = phoneNumber;
        
        if (CreditCardNo.length() == 16) {
            this.CreditCardNo = CreditCardNo;
        } else {
            System.err.println("Invalid Credit Card Number :(");
        }
    }

    public String getCreditCardNo() {
        return this.CreditCardNo;
    }

    public String getPhoneNumber( ) {
        return this.phoneNumber;
    }

    public void setCreditCardNo(String CreditCardNo) {
        if (CreditCardNo.length() == 16) {
            this.CreditCardNo = CreditCardNo;
        } else {
            System.err.println("Invalid Credit Card Number :(");
        }
    }

    public int getId() { 
        return this.Id;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
