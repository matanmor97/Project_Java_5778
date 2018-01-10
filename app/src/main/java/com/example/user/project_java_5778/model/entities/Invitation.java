package com.example.user.project_java_5778.model.entities;

import java.util.Date;

/**
 * Created by user on 14/11/2017.
 */

public class Invitation {

    private int clientNum;
    public void setClientNum (int clientNum) {
        this.clientNum = clientNum;
    }
    public int getClientNum () {
        return clientNum;
    }

    private boolean typeOfInvantaion;
    public void setTypeOfInvantaion (boolean typeOfInvantaion) {
        this.typeOfInvantaion = typeOfInvantaion;
    }
    public boolean getTypeOfInvantaion () {
        return typeOfInvantaion;
    }

    private int carNumber;
    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }
    public int getCarNumber () {
        return carNumber;
    }

    private Date orderStartTime;
    public void setOrderStartTime (Date orderStartTime) {
        this.orderStartTime = orderStartTime;
    }
    public Date getOrderStartTime () {
        return orderStartTime;
    }

    private int startKilometers;
    public void setStartKilometers (int startKilometers) {
        this.startKilometers = startKilometers;
    }
    public int getStartKilometers () {
        return startKilometers;
    }

    private int endKilometers;
    public void setEndKilometers (int endKilometers) {
        this.endKilometers = endKilometers;
    }
    public int getEndKilometers () {
        return endKilometers;
    }

    private boolean fuelWasFilled;
    public void setFuelWasFilled (boolean fuelWasFilled) {
        this.fuelWasFilled = fuelWasFilled;
    }
    public boolean getFuelWasFilled () {
        return fuelWasFilled;
    }

    private int literOfFuelFilled;
    public void setLiterOfFuelFilled (int literOfFuelFilled) {
        this.literOfFuelFilled = literOfFuelFilled;
    }
    public int getLiterOfFuelFilled () {
        return literOfFuelFilled;
    }

    private double billingAmount;
    public void setBillingAmount (double billingAmount) {
        this.billingAmount = billingAmount;
    }
    public double getBillingAmount () {
        return billingAmount;
    }

    private int invitationNumber;
    public void setInvitationNumber(int invitationNumber) {
        this.invitationNumber = invitationNumber;
    }
    public int getInvitationNumber () {
        return invitationNumber;
    }
}
