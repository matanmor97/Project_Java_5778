package com.example.user.project_java_5778.model.entities;

/**
 * Created by user on 12/11/2017.
 */

public class Client {
    /*
    we need to add toString!!
    constructor??
     */

    private String firstName;
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName () {
        return firstName;
    }

    private String lastName;
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName () {
        return lastName;
    }

    private long id;
    public void setId(long id) {
        this.id = id;
    }
    public long getId () {
        return id;
    }

    private String phoneNumber;
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber () {
        return phoneNumber;
    }

    private String emailAddress;
    public void setEmailAddress(String emailAdress) {
        this.emailAddress = emailAddress;
    }
    public String getEmailAddress () {
        return emailAddress;
    }

    private String creditCard;
    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
    public String getCreditCard () {
        return creditCard;
    }


    @Override
    public String toString() {
        return getFirstName() + " , " + getLastName()+ " , " +getId();
    }
}
