package com.example.user.project_java_5778.model.datasource;


import android.content.ContentValues;

import com.example.user.project_java_5778.model.backend.DB_manager;
import com.example.user.project_java_5778.model.backend.TakeGo_Const;
import com.example.user.project_java_5778.model.entities.*;

import java.util.ArrayList;
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

    static {

        clients = new ArrayList<>();
        branches = new ArrayList<>();
        carModels = new ArrayList<>();
        cars = new ArrayList<>();
        invitations = new ArrayList<>();

    }


    @Override
    public boolean CheckClientExist(long id) {

        Client client = getClient(id);

        if (client != null)
            return true;

        return false;
    }


    static long ID = 235897210;

    @Override
    public Client getClient(long id) {
        Client client = null;

        for (Client c : clients) {
            if (c.getId() == id)
                client = c;
        }

        return client;
    }

    @Override
    public long addClient(ContentValues contentValues) {

        //change the ID by adding 1 when we add a Client
        contentValues.put(TakeGo_Const.ClientConst.id, ID++);
        Client client = TakeGo_Const.ContentValueToClient(contentValues);
        clients.add(client);

        return client.getId();
    }

    @Override
    public boolean removeClient(long id) {

        Client client = getClient(id);
        return clients.remove(client);
    }

    @Override
    public void updateClient(long id, ContentValues values) {

        Client client = TakeGo_Const.ContentValueToClient(values);
        clients.set(clients.indexOf(getClient(id)), client);
    }

    public List<Client> getClients() {

        return clients;
    }


    public Branch GetBranch(int branchNumber) {

        Branch branch = null;

        for (Branch b : branches) {
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

    @Override
    public CarModel getCarModel(int modelCode) {
        CarModel carModel = null;

        for (CarModel c : carModels) {
            if (c.getModelCode() == modelCode)
                carModel = c;
        }

        return carModel;
    }

    static int Code = 235897210;

    @Override
    public int addCarModel(ContentValues contentValues) {

        //change the model code by adding 1 when we add a Car model
        contentValues.put(TakeGo_Const.CarModelConst.modelCode, Integer.toString(Code++));
        CarModel carmodel = TakeGo_Const.ContentValueToCarModel(contentValues);
        carModels.add(carmodel);

        return carmodel.getModelCode();
    }

    @Override
    public boolean removeCarModel(int modleCode) {
        CarModel carModel = getCarModel(modleCode);
        return carModels.remove(carModel);
    }

    @Override
    public void updateCarModel(int modleCode, ContentValues values) {

        CarModel carModel = TakeGo_Const.ContentValueToCarModel(values);
        carModels.set(carModels.indexOf(getCarModel(modleCode)), carModel);

    }

    @Override
    public List<CarModel> getCarModels() {

        return carModels;
    }


    public Car GetCar(int carNumber) {

        Car car = null;

        for (Car c : cars) {
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
        cars.set(cars.indexOf(GetCar(carNumber)), car);
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }
}