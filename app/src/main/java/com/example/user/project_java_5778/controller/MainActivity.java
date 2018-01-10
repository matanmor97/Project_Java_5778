package com.example.user.project_java_5778.controller;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.user.project_java_5778.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


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

            Intent myIntent = new Intent(MainActivity.this, ClientsList.class);
            startActivity(myIntent);
            // Handle clicks for clients
        } else if ( v == branches ) {
            // Handle clicks for branches
        } else if ( v == carModels ) {
            // Handle clicks for carModels
        } else if ( v == cars ) {
            // Handle clicks for cars
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
    }
}

