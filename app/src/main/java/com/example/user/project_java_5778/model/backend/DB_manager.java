package com.example.user.project_java_5778.model.backend;

import android.content.ContentValues;

import com.example.user.project_java_5778.model.entities.*;

import java.util.List;

/**
 * Created by user on 14/11/2017.
 */

public interface DB_manager {

    boolean CheckClientExist (String id);

    String addClient (ContentValues client);
    boolean removeClient (String id);
    void updateClient(String id, ContentValues values);
    List<Client> getClients();

    int addBranch (ContentValues Branch);
    boolean removeBranch (int id);
    void updateBranch(int id, ContentValues values);
    List<Branch> getBranches();

    String addCarModel (ContentValues CarModel);
    boolean removeCarModel (String id);
    void updateCarModel(String id, ContentValues values);
    List<CarModel> getCarModels();

    int addCar (ContentValues Car);
    boolean removeCar (String id);
    void updateCar(String id, ContentValues values);
    List<Car> getCars();


    /**









     String addInvitation (ContentValues Invitation);
     boolean removeInvitation (String id);
     void updateInvitation(String id, ContentValues values);
     List<Invitation> GetInvitation();

     **/
}
