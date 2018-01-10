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
        addClient = (Button) findViewById(R.id.addButton_add);
        lastName_editText = (EditText) findViewById(R.id.lastName_editText_add);
        firstName_editText = (EditText) findViewById(R.id.fristName_editText_add);
        phoneNumber_editText = (EditText) findViewById(R.id.phoneNumber_editText_add);
        emailAddress_editText = (EditText) findViewById(R.id.emailAddress_editText_add);
        creditCard_editText = (EditText) findViewById(R.id.creditCard_editText_add);

        addClient.setOnClickListener( this );


    }

    @Override
    public void onClick(View v) {

        if (v == addClient) {
            final ContentValues contentValues = new ContentValues();

            try {
                contentValues.put(TakeGo_Const.ClientConst.lastName, this.lastName_editText.getText().toString());
                contentValues.put(TakeGo_Const.ClientConst.firstName, this.firstName_editText.getText().toString());
                contentValues.put(TakeGo_Const.ClientConst.phoneNumber, this.phoneNumber_editText.getText().toString());
                contentValues.put(TakeGo_Const.ClientConst.emailAddress, this.emailAddress_editText.getText().toString());
                contentValues.put(TakeGo_Const.ClientConst.creditCard, this.creditCard_editText.getText().toString());

                //Toast.makeText(getBaseContext(), "It's working", Toast.LENGTH_LONG).show();

                new AsyncTask<Void, Void, Long>() {

                    @Override
                    protected Long doInBackground(Void... params) {
                        return instance.addClient(contentValues);
                    }

                    @Override
                    protected void onPostExecute(Long idResult) {
                        super.onPostExecute(idResult);
                        if (idResult > 0)
                            Toast.makeText(getBaseContext(), "insert id: " + idResult, Toast.LENGTH_LONG).show();
                        finish();
                    }


                }.execute();

            } catch (Exception e) {

                Toast.makeText(getBaseContext(), "It's not working", Toast.LENGTH_LONG).show();

            }
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_property);




        DBManagerFactory.getInstanse().getClients();

        findViews();

    }

}
