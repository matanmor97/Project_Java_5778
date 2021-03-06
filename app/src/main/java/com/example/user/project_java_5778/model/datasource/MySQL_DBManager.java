package com.example.user.project_java_5778.model.datasource;

import android.content.ContentValues;

import com.example.user.project_java_5778.model.backend.DB_manager;
import com.example.user.project_java_5778.model.backend.TakeGo_Const;
import com.example.user.project_java_5778.model.entities.Branch;
import com.example.user.project_java_5778.model.entities.Car;
import com.example.user.project_java_5778.model.entities.CarModel;
import com.example.user.project_java_5778.model.entities.Client;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 10/01/2018.
 */

public class MySQL_DBManager implements DB_manager {

    private String WEB_URL = "http://matanmos.vlab.jct.ac.il/test/php";

    @Override
    public boolean CheckClientExist(long id) {
        return false;
    }

    static long ID = 235897210;


    @Override
    public Client getClient(long id) {
        List<Client> temp = getClients();
        Client result ;
        try {
            result=temp.get((int)id);
            return result;
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long addClient(ContentValues contentValues) {

        contentValues.put(TakeGo_Const.ClientConst.id, ID++);
        try {
            String result = PHPTools.POST(WEB_URL + "/addClient.php", contentValues);
            Long id = contentValues.getAsLong(TakeGo_Const.ClientConst.id);
            return id;
        }

        catch (IOException e) {
            return -1;
        }
    }

    @Override
    public boolean removeClient(long id) {
        return false;
    }



    @Override
    public List<Client> getClients () {
        List<Client> result = new ArrayList<Client>();
        try {
            String str = PHPTools.GET(WEB_URL + "/getClients.php");
            JSONArray array = new JSONObject(str).getJSONArray("clients");//clients is the name of the jason array


            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                ContentValues contentValues = PHPTools.JsonToContentValues(jsonObject);
                Client client = TakeGo_Const.ContentValueToClient(contentValues);
                result.add(client);
            }
            return result;

        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void updateClient(long id, ContentValues values) {

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
    public int addCarModel(ContentValues contentValues) {
        return 0;
    }

    @Override
    public boolean removeCarModel(int modelCode) {
        return false;
    }

    @Override
    public void updateCarModel(int modelCode, ContentValues values) {

    }

    @Override
    public CarModel getCarModel(int modleCode) {
        return null;
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
