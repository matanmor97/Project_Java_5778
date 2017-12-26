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

        for (Client client:clients){
            if (client.getId() == id)
                return true;
        }

        return false;
    }

    @Override
    public String addClient(ContentValues contentValues) {

        Client client = TakeGo_Const.ContentValueToClient(contentValues);
        clients.add(client);

        return client.getId();
    }
    @Override
    public boolean removeClient(String id) {
        Client client = getClients()
    }

    @Override
    public boolean updateClient(String id, ContentValues values) {
        return false;
    }

    @Override
    public List<Client> getClients() {

        return clients;
    }


    @Override
    public String addBranch(ContentValues Branch) {
        return null;
    }

    @Override
    public boolean removeBranch(String id) {
        return false;
    }

    @Override
    public boolean updateBranch(String id, ContentValues values) {
        return false;
    }

    @Override
    public List<Branch> getBranches() {
        return branches;
    }


    @Override
    public String addCarModel(ContentValues contentValues) {

        CarModel carmodel = TakeGo_Const.ContentValueToCarModel(contentValues);
        carModels.add(carmodel);

        return carmodel.getModelCode();
    }

    @Override
    public boolean removeCarModel(String id) {
        return false;
    }

    @Override
    public boolean updateCarModel(String id, ContentValues values) {
        return false;
    }

    @Override
    public List<CarModel> getCarModels() {
        return carModels;
    }


    @Override
    public int addCar(ContentValues contentValues) {

        Car car = TakeGo_Const.ContentValueToCar(contentValues);
        cars.add(car);

        return car.getCarNumber();
    }

    @Override
    public boolean removeCar(String id) {
        return false;
    }

    @Override
    public boolean updateCar(String id, ContentValues values) {
        return false;
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }
}
