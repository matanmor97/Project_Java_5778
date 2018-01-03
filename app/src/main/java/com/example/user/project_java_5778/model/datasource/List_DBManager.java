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
    public boolean removeClient(String id) {

        Client client = GetClient(id);
        return clients.remove(client);
    }
    @Override
    public void updateClient(String id, ContentValues values) {

        Client client = TakeGo_Const.ContentValueToClient(values);
        GetClient(id);

        clients.set(clients.indexOf(client), client);


    }
    @Override
    public List<Client> getClients() {

        return clients;
    }
    @Override
    public String addClient(ContentValues contentValues) {

        Client client = TakeGo_Const.ContentValueToClient(contentValues);
        clients.add(client);

        return client.getId();
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

    public String addBranch(ContentValues Branch) {
        return null;
    }

    @Override
    public boolean removeBranch(String id) {
        return false;
    }

    @Override
    public void updateBranch(String id, ContentValues values) {
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
    public void updateCarModel(String id, ContentValues values) {
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
    public void updateCar(String id, ContentValues values) {
        return false;
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }
}
