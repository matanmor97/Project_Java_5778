package com.example.user.project_java_5778.controller.Client;

import android.content.ContentValues;
import android.content.Intent;
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
import com.example.user.project_java_5778.model.entities.Client;

public class UpdateClient extends AppCompatActivity implements View.OnClickListener {

    private Button updateClient;
    private EditText lastName_editText;
    private EditText firstName_editText;
    private EditText phoneNumber_editText;
    private EditText emailAddress_editText;
    private EditText creditCard_editText;
    private DB_manager instance = DBManagerFactory.getInstanse();
    private Long clientId;

    private void findViews() {
        updateClient = (Button) findViewById(R.id.addButton_update);
        lastName_editText = (EditText) findViewById(R.id.lastName_editText_update);
        firstName_editText = (EditText) findViewById(R.id.fristName_editText_update);
        phoneNumber_editText = (EditText) findViewById(R.id.phoneNumber_editText_update);
        emailAddress_editText = (EditText) findViewById(R.id.emailAddress_editText_update);
        creditCard_editText = (EditText) findViewById(R.id.creditCard_editText_update);

        updateClient.setOnClickListener( this );


    }

    // initialization the text in the EditTexts to the current value of the client
    public void init () {

        Intent intent = getIntent();
        clientId = intent.getLongExtra(TakeGo_Const.ConstValue.CLIENT_ID_KEY, -1);
        final Client client = new Client();

        new AsyncTask<Void, Void, Client>() {

            @Override
            protected Client doInBackground(Void... params) {
                return instance.getClient(clientId);
            }

            @Override
            protected void onPostExecute(Client idResult) {
                if (idResult.getId() > 0) {

                    client.setFirstName(idResult.getFirstName());
                    client.setLastName(idResult.getLastName());
                    client.setId(idResult.getId());
                    client.setPhoneNumber(idResult.getPhoneNumber());
                    client.setCreditCard(idResult.getCreditCard());
                    client.setEmailAddress(idResult.getEmailAddress());
                }
                finish();
            }


        }.execute();

        lastName_editText.setText(client.getLastName());
        firstName_editText.setText(client.getFirstName());
        phoneNumber_editText.setText(client.getPhoneNumber());
        emailAddress_editText.setText(client.getEmailAddress());
        creditCard_editText.setText(client.getCreditCard());
    }

    @Override
    public void onClick(View v) {

        if (v == updateClient) {
            final ContentValues contentValues = new ContentValues();

            try {
                contentValues.put(TakeGo_Const.ClientConst.lastName, this.lastName_editText.getText().toString());
                contentValues.put(TakeGo_Const.ClientConst.firstName, this.firstName_editText.getText().toString());
                contentValues.put(TakeGo_Const.ClientConst.id, clientId);
                contentValues.put(TakeGo_Const.ClientConst.phoneNumber, this.phoneNumber_editText.getText().toString());
                contentValues.put(TakeGo_Const.ClientConst.emailAddress, this.emailAddress_editText.getText().toString());
                contentValues.put(TakeGo_Const.ClientConst.creditCard, this.creditCard_editText.getText().toString());

                //Toast.makeText(getBaseContext(), "It's working", Toast.LENGTH_LONG).show();

                new AsyncTask<Void, Void, Void>() {

                    @Override
                    protected Void doInBackground(Void... params) {
                        DBManagerFactory.getInstanse().updateClient(clientId ,contentValues);

                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void result) {

                        Toast.makeText(getBaseContext(), "UPDATE", Toast.LENGTH_SHORT).show();
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
        setContentView(R.layout.activity_update_client);

        findViews();
        init();

    }

}