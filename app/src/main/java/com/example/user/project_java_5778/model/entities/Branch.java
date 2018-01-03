package com.example.user.project_java_5778.model.entities;

/**
 * Created by user on 12/11/2017.
 */

public class Branch {


    private String cityName
    public void setCityName (String cityName){
            this.cityName = cityName;
        }
    public String getCityName () {
            return cityName;
        }

    private String streetName;
    public void setStreetName (String streetName){
            this.streetName = streetName;
        }
    public String getStreetName () {
            return streetName;
        }

    private int number;
    public void setNumber (int number){
            this.number = number;
        }
    public int getNumber () {
            return number;
        }

    private int numOfParkingSpace;
    public void setNumOfParkingSpac (int numOfParkingSpace){
        this.numOfParkingSpace = numOfParkingSpace;
    }
    public int getNumOfParkingSpace (){
        return numOfParkingSpace;
    }

    private int branchNumber;
    public void setBranchNumber (int branchNumber){
        this.branchNumber = branchNumber;
    }
    public int getBranchNumber (){
        return branchNumber;
    }

}
