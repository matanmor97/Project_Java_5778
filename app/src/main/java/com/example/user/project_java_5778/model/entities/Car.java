package com.example.user.project_java_5778.model.entities;

/**
 * Created by user on 14/11/2017.
 */

public class Car {

    //car
    private int branchNumber;
    public void setBranchNumber (int branchNUmber){this.branchNumber = branchNumber;}
    public int getBranchNumber  (){return this.branchNumber;}

    private String carModelCode;
    public void setCarModel (String carModel){this.carModelCode = carModel;}
    public String getCarModel (){return this.carModelCode;}

    private int kilometers;
    public void setKilometers (int kilometers){
        this.kilometers = kilometers;
    }
    public int getKilometers (){
        return this.kilometers;
    }

    private int carNumber;
    public void setCarNumber (int carNumber){
        this.carNumber = carNumber;
    }
    public int getCarNumber () {
        return this.carNumber;
    }


}