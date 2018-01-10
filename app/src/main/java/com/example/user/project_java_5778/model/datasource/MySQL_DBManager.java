package com.example.user.project_java_5778.model.datasource;

import android.content.ContentValues;

import com.example.user.project_java_5778.model.backend.DB_manager;
import com.example.user.project_java_5778.model.entities.Branch;
import com.example.user.project_java_5778.model.entities.Car;
import com.example.user.project_java_5778.model.entities.CarModel;
import com.example.user.project_java_5778.model.entities.Client;

import java.util.List;

/**
 * Created by user on 10/01/2018.
 */

public class MySQL_DBManager implements DB_manager {


    @Override
    public boolean CheckClientExist(long id) {
        return false;
    }

    @Override
    public Client getClient(long id) {
        return null;
    }

    @Override
    public long addClient(ContentValues contentValues) {
        return 0;
    }

    @Override
    public boolean removeClient(long id) {
        return false;
    }

    @Override
    public void updateClient(long id, ContentValues values) {

    }

    @Override
    public List<Client> getClients() {
        return null;
    }

    @Override
    public int addBranch(ContentValues contentValues) {
        return 0;
    }

    @Override
    public boolean removeBranch(int id) {
        return false;
    }

    @Override
    public void updateBranch(int id, ContentValues values) {

    }

    @Override
    public List<Branch> getBranches() {
        return null;
    }

    @Override
    public String addCarModel(ContentValues contentValues) {
        return null;
    }

    @Override
    public boolean removeCarModel(String id) {
        return false;
    }

    @Override
    public void updateCarModel(String id, ContentValues values) {

    }

    @Override
    public List<CarModel> getCarModels() {
        return null;
    }

    @Override
    public int addCar(ContentValues contentValues) {
        return 0;
    }

    @Override
    public boolean removeCar(int id) {
        return false;
    }

    @Override
    public void updateCar(int id, ContentValues values) {

    }

    @Override
    public List<Car> getCars() {
        return null;
    }
}
