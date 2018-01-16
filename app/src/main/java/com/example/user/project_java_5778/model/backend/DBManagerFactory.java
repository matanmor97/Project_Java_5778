package com.example.user.project_java_5778.model.backend;

import com.example.user.project_java_5778.model.datasource.List_DBManager;
import com.example.user.project_java_5778.model.datasource.MySQL_DBManager;

/**
 * Created by user on 15/11/2017.
 */

public class DBManagerFactory {

    private static DB_manager instanse = null;
    private DBManagerFactory (){}


    public static DB_manager getInstanse (){
        if (instanse == null)
            instanse = new MySQL_DBManager();
            //instanse = new List_DBManager();

        return instanse;
    }
}
