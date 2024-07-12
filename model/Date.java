package model;

public class Date {
    private int year;
    private int month;
    private int day;

    public Date() {
        year = day = month = 0;
    }

    public Date(int day, int month, int year) {
        if(year >= 2023 && month <= 12 && month >= 1 && day <= 31 && day >= 1) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            System.err.println("The date you entered is not correct! Please try again.");
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year >= 2023) {
            this.year = year;
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if(month <= 12 && month >= 1) {
            this.month = month;
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if(day <= 31 && day >= 1) {
            this.day = day;
        }
    }

    public boolean check() {
        return year >= 2023 && month <= 12 && month >= 1 && day <= 31 && day >= 1;
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Date d = (Date) obj;
        return day == d.day && month == d.month && year == d.year;
    }

     // Convert to java.sql.Date
     public java.sql.Date toSqlDate() {
        return java.sql.Date.valueOf(this.year + "-" + String.format("%02d", this.month) + "-" + String.format("%02d", this.day));
    }

    // Convert from java.sql.Date to custom Date
    public static Date fromSqlDate(java.sql.Date sqlDate) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(sqlDate);
        return new Date(cal.get(java.util.Calendar.DAY_OF_MONTH), cal.get(java.util.Calendar.MONTH) + 1, cal.get(java.util.Calendar.YEAR));
    }
}
