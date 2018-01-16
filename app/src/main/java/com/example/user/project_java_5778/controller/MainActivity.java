package com.example.user.project_java_5778.controller;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.user.project_java_5778.R;
import com.example.user.project_java_5778.model.backend.DBManagerFactory;
import com.example.user.project_java_5778.model.backend.DB_manager;
import com.example.user.project_java_5778.model.backend.TakeGo_Const;
import com.example.user.project_java_5778.model.entities.CarModel;
import com.example.user.project_java_5778.model.entities.Client;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private DB_manager instance = DBManagerFactory.getInstanse();
    private Button clients;
    private Button branches;
    private Button carModels;
    private Button cars;
    /**
     * Find the Views in the layout.
     */
    private void findViews() {
        clients = (Button)findViewById( R.id.clients );
        branches = (Button)findViewById( R.id.branches );
        carModels = (Button)findViewById( R.id.carModels );
        cars = (Button)findViewById( R.id.cars );

        clients.setOnClickListener( this );
        branches.setOnClickListener( this );
        carModels.setOnClickListener( this );
        cars.setOnClickListener( this );
    }

    /**
     * Handle button click events
     */
    @Override
    public void onClick(View v) {

        if ( v == clients ) {
            // Handle clicks for clients
            Intent myIntent = new Intent(MainActivity.this, ClientsList.class);
            startActivity(myIntent);

        } else if ( v == branches ) {
            // Handle clicks for branches
        } else if ( v == carModels ) {
            // Handle clicks for carModels
            Intent myIntent = new Intent(MainActivity.this, CarModelList.class);
            startActivity(myIntent);
        } else if ( v == cars ) {
            // Handle clicks for cars
        }
    }

    /**
     * initialization
     */
    private void init() {
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        Client client1 = new Client();
        client1.setFirstName("a");
        client1.setLastName("a");
        client1.setId(123);
        client1.setEmailAddress("aa");
        client1.setCreditCard("1232");

        Client client2 = new Client();
        client2.setFirstName("b");
        client2.setLastName("b");

        Client client3 = new Client();
        client3.setFirstName("b");
        client3.setLastName("b");

        instance.addClient(TakeGo_Const.ClientToContentValues(client1));
        instance.addClient(TakeGo_Const.ClientToContentValues(client2));
        instance.addClient(TakeGo_Const.ClientToContentValues(client3));
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        CarModel carModel1 = new CarModel();
        carModel1.setModelCode("11111");

        CarModel carModel2 = new CarModel();

        CarModel carModel3 = new CarModel();

        instance.addCarModel(TakeGo_Const.CarModelToContentValues(carModel1));
        instance.addCarModel(TakeGo_Const.CarModelToContentValues(carModel2));
        instance.addCarModel(TakeGo_Const.CarModelToContentValues(carModel3));
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();
        findViews();
    }
}

