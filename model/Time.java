package model;

public class Time {
    private int second, minute, hours;

    public Time() {}

    public Time(int hours, int minute) {
        if(hours>=10 && hours<=22 && minute<=60 && minute>=0) {
            this.minute = minute;
            this.hours = hours;
        } else {
            System.err.println("Out of work time!");
        }
    }

    public Time(int hours, int minute, int second) {
        this.second = second;
        this.minute = minute;
        this.hours = hours;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if(minute <= 60 && minute >= 0)
            this.minute = minute;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        if(hours <= 22 && hours >= 10)
            this.hours = hours;
    }

    public boolean check() {
        return hours >= 10 && hours <= 22 && minute <= 60 && minute >= 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Time t = (Time) obj;
        return hours == t.hours && minute == t.minute;
    }

    @Override
    public String toString() {
        return  hours + "h:" + minute + "m:" + second + 's';
    }

    // Convert to java.sql.Time
    public java.sql.Time toSqlTime() {
        return java.sql.Time.valueOf(String.format("%02d:%02d:%02d", this.hours, this.minute, this.second));
    }

    // Convert from java.sql.Time to custom Time
    public static Time fromSqlTime(java.sql.Time sqlTime) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(sqlTime);
        return new Time(cal.get(java.util.Calendar.HOUR_OF_DAY), cal.get(java.util.Calendar.MINUTE), cal.get(java.util.Calendar.SECOND));
    }
}
