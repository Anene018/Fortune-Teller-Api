package com.fortune.fortune.Model;

public class UserDate {
    int date;
    int month;

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public UserDate(int date, int month) {
        this.date = date;
        this.month = month;
    }

    public UserDate() {

    }

}
