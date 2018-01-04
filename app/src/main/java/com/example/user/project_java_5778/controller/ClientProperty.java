package com.example.user.project_java_5778.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.project_java_5778.R;
import com.example.user.project_java_5778.model.backend.TakeGo_Const;
import com.example.user.project_java_5778.model.datasource.List_DBManager;

import com.example.user.project_java_5778.model.backend.TakeGo_Const;

public class ClientProperty extends AppCompatActivity implements View.OnClickListener {

    private Button addClient;
    private EditText lastName_editText;
    private EditText firstName_editText;
    private EditText phoneNumber_editText;
    private EditText emailAddress_editText;
    private EditText creditCard_editText;

    private void findViews() {
        addClient = (Button) findViewById(R.id.addButton);
        lastName_editText = (EditText) findViewById(R.id.lastName_editText)
        firstName_editText = (EditText) findViewById(R.id.fristName_editText)
        phoneNumber_editText = (EditText) findViewById(R.id.phoneNumber_editText)
        emailAddress_editText = (EditText) findViewById(R.id.emailAddress_editText)
        creditCard_editText = (EditText) findViewById(R.id.creditCard_editText)

        addClient.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {

        ContentValues contentValues = new ContentValues();

        String lastName = lastName_editText.getText().toString();
        contentValues.put(TakeGo_Const.ClientConst.lastName, lastName);

        String firstName = firstName_editText.getText().toString();
        contentValues.put(TakeGo_Const.ClientConst.firstName, firstName);

        String phoneNumber = phoneNumber_editText.getText().toString();
        contentValues.put(TakeGo_Const.ClientConst.phoneNumber, phoneNumber);

        String emailAddress = emailAddress_editText.getText().toString();
        contentValues.put(TakeGo_Const.ClientConst.emailAddress, emailAddress);

        String creditCard = creditCard_editText.getText().toString();
        contentValues.put(TakeGo_Const.ClientConst.creditCard, creditCard);


        List_DBManager.clients.add(TakeGo_Const.ContentValueToClient(contentValues));


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_property);



    }

}
