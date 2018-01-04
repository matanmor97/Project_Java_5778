package com.example.user.project_java_5778.model.backend;

import android.content.ContentValues;

import com.example.user.project_java_5778.model.entities.*;

import java.util.List;

/**
 * Created by user on 14/11/2017.
 */

public interface DB_manager {

    boolean CheckClientExist (int id);

    int addClient (ContentValues contentValues);
    boolean removeClient (int id);
    void updateClient(int id, ContentValues values);
    List<Client> getClients();

    int addBranch (ContentValues contentValues);
    boolean removeBranch (int id);
    void updateBranch(int id, ContentValues values);
    List<Branch> getBranches();

    String addCarModel (ContentValues contentValues);
    boolean removeCarModel (String id);
    void updateCarModel(String id, ContentValues values);
    List<CarModel> getCarModels();

    int addCar (ContentValues contentValues);
    boolean removeCar (int id);
    void updateCar(int id, ContentValues values);
    List<Car> getCars();


    /**









     String addInvitation (ContentValues Invitation);
     boolean removeInvitation (String id);
     void updateInvitation(String id, ContentValues values);
     List<Invitation> GetInvitation();

     **/
}
