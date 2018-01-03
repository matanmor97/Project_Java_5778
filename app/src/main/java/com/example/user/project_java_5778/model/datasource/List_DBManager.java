package com.example.user.project_java_5778.model.datasource;


import android.content.ContentValues;

import com.example.user.project_java_5778.model.backend.DB_manager;
import com.example.user.project_java_5778.model.backend.TakeGo_Const;
import com.example.user.project_java_5778.model.entities.*;
import java.util.List;

/**
 * Created by user on 15/11/2017.
 */

public class List_DBManager implements DB_manager {

    static List<Client> clients;
    static List<Branch> branches;
    static List<CarModel> carModels;
    static List<Car> cars;
    static List<Invitation> invitations;


    @Override
    public boolean CheckClientExist(String id) {

        Client client = GetClient(id);

        if (client != null)
            return true;

        return false;
    }



    public Client GetClient(String id){
        Client client = null;

        for (Client c:clients) {
            if (c.getId() == id)
                client = c;
        }

        return client;
    }
    @Override
    public String addClient(ContentValues contentValues) {

        Client client = TakeGo_Const.ContentValueToClient(contentValues);
        clients.add(client);

        return client.getId();
    }
    @Override
    public boolean removeClient(String id) {

        Client client = GetClient(id);
        return clients.remove(client);
    }
    @Override
    public void updateClient(String id, ContentValues values) {

        Client client = TakeGo_Const.ContentValueToClient(values);
        clients.set(clients.indexOf(GetClient(id)), client);
    }
    @Override
    public List<Client> getClients() {

        return clients;
    }




    public Branch GetBranch (int branchNumber){

        Branch branch = null;

        for (Branch b:branches) {
            if (b.getBranchNumber() == branchNumber)
                branch = b;
        }

        return branch;
    }
    @Override
    public int addBranch(ContentValues contentValues) {

        Branch branch = TakeGo_Const.ContentValueToBranch(contentValues);
        branches.add(branch);

        return branch.getBranchNumber();
    }
    @Override
    public boolean removeBranch(int branchNumber) {

        Branch branch = GetBranch(branchNumber);
        return branches.remove(branch);
    }
    @Override
    public void updateBranch(int branchNumber, ContentValues values) {

        Branch branch = TakeGo_Const.ContentValueToBranch(values);
        branches.set(branches.indexOf(GetBranch(branchNumber)), branch);
    }
    @Override
    public List<Branch> getBranches() {
        return branches;
    }


    public CarModel GetCarModel(String modelName){
        CarModel carModel = null;

        for (CarModel c:carModels) {
            if (c.getModelName() == modelName)
                carModel = c;
        }

        return carModel;
    }
    @Override
    public String addCarModel(ContentValues contentValues) {

        CarModel carmodel = TakeGo_Const.ContentValueToCarModel(contentValues);
        carModels.add(carmodel);

        return carmodel.getModelCode();
    }
    @Override
    public boolean removeCarModel(String modelName) {
        CarModel carModel = GetCarModel(modelName);
        return carModels.remove(modelName);
    }
    @Override
    public void updateCarModel(String modelName, ContentValues values) {

        CarModel carModel = TakeGo_Const.ContentValueToCarModel(values);
        carModels.set(carModels.indexOf(GetCarModel(modelName)),carModel);

    }
    @Override
    public List<CarModel> getCarModels() {

        return carModels;
    }



    public Car GetCar(int carNumber){

        Car car = null;

        for (Car c:cars) {
            if (c.getCarNumber() == carNumber)
                car = c;
        }

        return car;
    }
    @Override
    public int addCar(ContentValues contentValues) {

        Car car = TakeGo_Const.ContentValueToCar(contentValues);
        cars.add(car);

        return car.getCarNumber();
    }
    @Override
    public boolean removeCar(int carNumber) {

        Car car = GetCar(carNumber);
        return cars.remove(car);
    }
    @Override
    public void updateCar(int carNumber, ContentValues values) {

        Car car = TakeGo_Const.ContentValueToCar(values);
        cars.set(cars.indexOf(GetCar(carNumber)),car);
    }
    @Override
    public List<Car> getCars() {
        return cars;
    }
}