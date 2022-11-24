package com.company.assignment;
import com.google.firebase.database.IgnoreExtraProperties;
@IgnoreExtraProperties
public class User {
    private String name;
    private String day;
    private String month;
    private String year;
    private String email;

    public User() {
    }

    public User(String name, String day, String month, String year, String email) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getEmail() {
        return email;
    }
}
