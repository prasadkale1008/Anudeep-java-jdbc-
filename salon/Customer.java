package Salon;



import java.util.*;
import java.time.LocalTime;
import java.time.LocalDate;

public class Customer extends Person {

    /**
     * Attribute used to identify the Credit Card Number of the customer.
     */
    private String CreditCardNo;

    /**
     * Default constructor for Customer.
     */
    public Customer() {}

    /**
     * Constructor to set the name, phone number, and credit card number of the customer.
     * @param name         The name of the customer.
     * @param phoneNumber  The phone number of the customer.
     * @param CreditCardNo The credit card number of the customer. Must be a 16-digit number.
     */
    public Customer(String name, String phoneNumber, String CreditCardNo) {
        super(name,phoneNumber);

        // Validates and sets the credit card number.
        if(CreditCardNo.length()==16){
            this.CreditCardNo= CreditCardNo;
        }else{System.err.println("Invalid Credit Card Number :(");}
    }

    //setters and getters
    /**
     * Getter for the Credit Card Number, masking most of the digits for privacy and security.
     * @return String representation of masked Credit Card Number.
     */
    public String getCreditCardNo() {
        String creditCard="**** **** **** "+CreditCardNo.substring(12);
        return creditCard;
    }

    /**
     * Setter for the Credit Card Number.
     * @param CreditCardNo The credit card number to set. Must be a 16-digit number.
     */
    public void setCreditCardNo(String CreditCardNo) {
        if(CreditCardNo.length()==16){
            this.CreditCardNo= CreditCardNo;
        }else{System.err.println("Invalid Credit Card Number :(");}
    }

    /**
     * Overrides the toString method to display customer information.
     * @return String representation of customer's name and phone number.
     */
    @Override
    public String toString() {
        return super.toString();
    }
}//Customer class

/**
 * The Stylist class holds information specific to stylists.
 * It extends the Person class and includes attributes related to stylist details.
 */


