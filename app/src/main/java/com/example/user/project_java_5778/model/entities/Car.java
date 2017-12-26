package com.example.user.project_java_5778.model.entities;

/**
 * Created by user on 14/11/2017.
 */

public class Car {

    //car
    private int branchNumber;
    public void setBranchNumber (int branchNUmber){this.branchNumber = branchNumber;}
    public int getBranchNumber  (){return this.branchNumber;}

    private CarModel carModel;
    public void setCarModel (CarModel carModel){this.carModel = carModel;}
    public CarModel getCarModel (){return this.carModel;}

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