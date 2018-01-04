package com.example.user.project_java_5778.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.project_java_5778.R;
import com.example.user.project_java_5778.model.backend.DBManagerFactory;
import com.example.user.project_java_5778.model.backend.DB_manager;
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
    private DB_manager instance = DBManagerFactory.getInstanse();


    private void findViews() {
        addClient = (Button) findViewById(R.id.addButton);
        lastName_editText = (EditText) findViewById(R.id.lastName_editText);
        firstName_editText = (EditText) findViewById(R.id.fristName_editText);
        phoneNumber_editText = (EditText) findViewById(R.id.phoneNumber_editText);
        emailAddress_editText = (EditText) findViewById(R.id.emailAddress_editText);
        creditCard_editText = (EditText) findViewById(R.id.creditCard_editText);

        addClient.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {

        final ContentValues contentValues = new ContentValues();

        contentValues.put(TakeGo_Const.ClientConst.lastName, lastName_editText.getText().toString());
        contentValues.put(TakeGo_Const.ClientConst.firstName, firstName_editText.getText().toString());
        contentValues.put(TakeGo_Const.ClientConst.phoneNumber, phoneNumber_editText.getText().toString());
        contentValues.put(TakeGo_Const.ClientConst.emailAddress, emailAddress_editText.getText().toString());
        contentValues.put(TakeGo_Const.ClientConst.creditCard, creditCard_editText.getText().toString());

        //Toast.makeText(getBaseContext(), "It's working", Toast.LENGTH_LONG).show();

        new AsyncTask<Void, Void, Integer>() {
            @Override
            protected void onPostExecute(Integer idResult) {
                super.onPostExecute(idResult);
                if (idResult > 0)
                    Toast.makeText(getBaseContext(), "insert id: " + idResult, Toast.LENGTH_LONG).show();
            }

            @Override
            protected Integer doInBackground(Void... params) {
                return instance.addClient(contentValues);

            }
        }.execute();



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_property);

        findViews();

    }

}
