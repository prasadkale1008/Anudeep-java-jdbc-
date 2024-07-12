package model;

import model.Date;
import model.Time;
import java.util.*;
import java.time.LocalTime;
import java.time.LocalDate;

public class Hair extends Service {
    private int length;
    private int style;

    public Hair() {}

    public Hair(Date date, Time time, Stylist stylist, int style) {
        super(date, time, stylist);
        this.style = style;
    }

    public Hair(Date date, Time time, Stylist stylist, int style, int length) {
        super(date, time, stylist);
        this.style = style;
        this.length = length;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        switch (style) {
            case 1:
                super.setPrice(250);
                break;
            case 2:
                super.setPrice(150);
                break;
            case 3:
                super.setPrice(400);
                break;
            default:
                System.out.println("Invalid input!!");
        }
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public void calculatePrice() {
        switch (length) {
            case 1:
                super.setPrice(getPrice() + 30);
                break;
            case 2:
                super.setPrice(getPrice() + 50);
                break;
            case 3:
                super.setPrice(getPrice() + 70);
                break;
            default:
                System.out.println("Invalid input!!");
        }
    }

    @Override
    public String toString() {
        String l;
        if (length == 1) l = "Short";
        else if (length == 2) l = "Mid-length";
        else l = "Long";

        String s;
        if (style == 1) s = "Special";
        else if (style == 2) s = "Normal";
        else s = "Haircut/Hairdye";

        return "Hair Service\nStyle: " + s + "\nLength: " + l + "\nPrice: " + getPrice();
    }
}
