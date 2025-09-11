package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Phone phone = new Phone(2005);
        WirelessPhone wirelessPhone = new WirelessPhone(1995, "Mark");

        User user = new User(1234);
        User user2 = new User(4321);
        user.callAnotherUser(user2, wirelessPhone);
    }
}

class User {
    private int number;

    public User(int newNumber) {
        number = newNumber;
    }

    public void callAnotherUser(User user, Phone phone) {
        phone.call(user.number);
    }
}

class Phone {
     protected int year;

     public int getYear() {
         return year;
     }

     public void setYear(int newYear) {
         if (newYear < 0) {
             System.out.println("Invalid year");
             year = 0;
         }
         year = newYear;
     }

    public void call(int number) {
        createConnection();
        System.out.println("Phone with year " + year + " is ringing for number " + number);
    }

    private void createConnection() {

    }

    public Phone(int newYear) {
        year = newYear;
    }
}

class WirelessPhone extends Phone {

    protected String mark;

    public WirelessPhone(int newYear, String newMark) {
        super(newYear);
        mark = newMark;
    }

    @Override
    public void call(int number) {
        System.out.println("Wireless Phone with year " + year + " is ringing for number " + number);
    }
}