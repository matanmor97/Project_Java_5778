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
    boolean updateClient(String id, ContentValues values);
    List<Client> getClients();

    String addBranch (ContentValues Branch);
    boolean removeBranch (String id);
    boolean updateBranch(String id, ContentValues values);
    List<Branch> getBranches();

    String addCarModel (ContentValues CarModel);
    boolean removeCarModel (String id);
    boolean updateCarModel(String id, ContentValues values);
    List<CarModel> getCarModels();

    int addCar (ContentValues Car);
    boolean removeCar (String id);
    boolean updateCar(String id, ContentValues values);
    List<Car> getCars();


    /**









     String addInvitation (ContentValues Invitation);
     boolean removeInvitation (String id);
     boolean updateInvitation(String id, ContentValues values);
     List<Invitation> GetInvitation();

     **/
}
