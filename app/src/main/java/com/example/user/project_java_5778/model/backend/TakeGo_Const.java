package com.example.user.project_java_5778.model.backend;

import android.animation.ObjectAnimator;
import android.content.ContentValues;
import android.content.Intent;

import com.example.user.project_java_5778.model.entities.*;

/**
 * Created by user on 15/11/2017.
 */

public class TakeGo_Const {

    public static class ClientConst {

        public static final String firstName = "firstName";
        public static final String lastName = "lastName";
        public static final String id = "_id";
        public static final String phoneNumber = "phoneNumber";
        public static final String emailAddress = "emailAddress";
        public static final String creditCard = "creditCard";
    }

    public static class BranchConst {
        public static final String cityName = "cityName";
        public static final String streetName = "streetName";
        public static final String number = "number";
        public static final String numOfParkingSpace = "numOfParkingSpace";
        public static final String branchNumber = "branchNumber";

    }

    public static class CarModelConst {

        public static final String modelCode = "modelCode";
        public static final String companyName = "companyName";
        public static final String modelName = "modelName";
        public static final String engineCapacity = "engineCapacity";
        public static final String gearbox = "gearbox";
        public static final String seats = "seats";

    }

    public static class CarConst {

        public static final String branchNumber = "branchNumber";
        public static final String carModel = "carModel";
        public static final String kilometers = "kilometers";
        public static final String carNumber = "carNumber";
    }


    public static CarModel StringToCarModel(String string) {

        CarModel carModel = new CarModel();

        //split the string where there is space
        String[] temp = string.split("\\s+");

        carModel.setModelCode(temp[0]);
        carModel.setCompanyName(temp[1]);
        carModel.setModelName(temp[2]);
        carModel.setEngineCapacity(temp[3]);
        carModel.setGearbox(CarModel.Gearbox.values()[Integer.parseInt(temp[4])]);
        carModel.setSeats(Integer.parseInt(temp[5]));


        return carModel;
    }


    public static ContentValues ClientToContentValues(Client client) {

        ContentValues contentValues = new ContentValues();

        try {
            contentValues.put(ClientConst.firstName, client.getFirstName());
            contentValues.put(ClientConst.lastName, client.getLastName());
            contentValues.put(ClientConst.id, client.getId());
            contentValues.put(ClientConst.phoneNumber, client.getPhoneNumber());
            contentValues.put(ClientConst.emailAddress, client.getEmailAddress());
            contentValues.put(ClientConst.creditCard, client.getCreditCard());
        }

        catch (Exception e){

        }
        return contentValues;
    }

    public static Client ContentValueToClient(ContentValues contentValues) {

        Client client = new Client();

        try {
            client.setFirstName(contentValues.getAsString(ClientConst.firstName));
            client.setLastName(contentValues.getAsString(ClientConst.lastName));
            client.setId(contentValues.getAsLong(ClientConst.id));
            client.setPhoneNumber(contentValues.getAsString(ClientConst.phoneNumber));
            client.setEmailAddress(contentValues.getAsString(ClientConst.emailAddress));
            client.setCreditCard(contentValues.getAsString(ClientConst.creditCard));
        }

        catch (Exception e){

        }
        return client;
    }

    public static ContentValues BranchToContentValues(Branch branch) {

        ContentValues contentValues = new ContentValues();

        try {
            contentValues.put(BranchConst.cityName, branch.address.getCityName());
            contentValues.put(BranchConst.streetName, branch.address.getStreetName());
            contentValues.put(BranchConst.number, branch.address.getNumber());
            contentValues.put(BranchConst.numOfParkingSpace, branch.getNumOfParkingSpace());
            contentValues.put(BranchConst.branchNumber, branch.getBranchNumber());
        }

        catch (Exception e){

        }
        return contentValues;
    }

    public static Branch ContentValueToBranch(ContentValues contentValues) {

        Branch branch = new Branch();

        try {
            branch.address.setCityName(contentValues.getAsString(BranchConst.cityName));
            branch.address.setStreetName(contentValues.getAsString(BranchConst.streetName));
            branch.address.setNumber(contentValues.getAsInteger(BranchConst.number));
            branch.setNumOfParkingSpac(contentValues.getAsInteger(BranchConst.numOfParkingSpace));
            branch.setBranchNumber(contentValues.getAsInteger(BranchConst.number));
        }
        catch (Exception e) {

        }
        return branch;
    }

    public static ContentValues CarModelToContentValues(CarModel carModel) {

        ContentValues contentValues = new ContentValues();

        try {
            contentValues.put(CarModelConst.modelCode, carModel.getModelCode());
            contentValues.put(CarModelConst.companyName, carModel.getCompanyName());
            contentValues.put(CarModelConst.modelName, carModel.getModelName());
            contentValues.put(CarModelConst.engineCapacity, carModel.getEngineCapacity());
            contentValues.put(CarModelConst.gearbox, carModel.getGearbox().ordinal());
            contentValues.put(CarModelConst.seats, carModel.getSeats());
        }

        catch (Exception e){

        }
        return contentValues;
    }

    public static CarModel ContentValueToCarModel(ContentValues contentValues) {

        CarModel carModel = new CarModel();

        try {
            carModel.setModelCode(contentValues.getAsString(CarModelConst.modelCode));
            carModel.setCompanyName(contentValues.getAsString(CarModelConst.companyName));
            carModel.setModelName(contentValues.getAsString(CarModelConst.modelName));
            carModel.setEngineCapacity(contentValues.getAsString(CarModelConst.engineCapacity));
            carModel.setGearbox(CarModel.Gearbox.values()[contentValues.getAsInteger(CarModelConst.gearbox)]);
            carModel.setSeats(contentValues.getAsInteger(CarModelConst.seats));
        }

        catch (Exception e){

        }
        return carModel;
    }

    public static ContentValues CarToContentValues(Car car) {


        ContentValues contentValues = new ContentValues();

        try {
            contentValues.put(CarConst.branchNumber, car.getBranchNumber());
            contentValues.put(CarConst.carModel, car.getCarModel().toString());
            contentValues.put(CarConst.kilometers, car.getKilometers());
            contentValues.put(CarConst.carNumber, car.getCarNumber());
        }

        catch (Exception e){

        }
        return contentValues;
    }

    public static Car ContentValueToCar(ContentValues contentValues) {


            Car car = new Car();

        try {
            car.setBranchNumber(contentValues.getAsInteger(CarConst.branchNumber));
            car.setKilometers(contentValues.getAsInteger(CarConst.kilometers));
            car.setCarNumber(contentValues.getAsInteger(CarConst.carNumber));
            car.setCarModel(StringToCarModel(contentValues.getAsString(CarConst.carModel)));
        }

        catch (Exception e) {

        }
        return car;
    }


}