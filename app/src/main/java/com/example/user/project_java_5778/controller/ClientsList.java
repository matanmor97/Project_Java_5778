package com.example.user.project_java_5778.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.project_java_5778.R;
import com.example.user.project_java_5778.model.backend.DBManagerFactory;
import com.example.user.project_java_5778.model.backend.DB_manager;
import com.example.user.project_java_5778.model.backend.TakeGo_Const;
import com.example.user.project_java_5778.model.datasource.List_DBManager;
import com.example.user.project_java_5778.model.entities.Car;
import com.example.user.project_java_5778.model.entities.Client;


//need to add SEARCH and ADD NEW option

public class ClientsList extends Activity implements View.OnClickListener  {

    private DB_manager instance = DBManagerFactory.getInstanse();
    private Button addButton;
    private ListView clientList;
    ArrayAdapter<Client> adapter;

    /**
     * initialization
     */
    private void init()
    {
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

    }

    /**
     * make the ListView and fill it with the ArrayList of clients
     */
    private void clientListView() {


        /**
         * show the ArrayList of the client in the ViewList
         * using the adapter
         *(i don't know what is the second argument on the ArrayAdapter constructor)
         */

        clientList = (ListView)findViewById(R.id.list_view);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,instance.getClients());
        clientList.setAdapter(adapter);

        /**
         * when you click the item in the list view it calls to onItemClick
         */
        clientList.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //only for example
                Toast.makeText(ClientsList.this,"need to move to different activity/fragments",Toast.LENGTH_SHORT).show();

                //open the UpdateClient Activity
                //don't working!!!!!!!!!!!!!!!!!!!!!!!!!
                Intent myIntent = new Intent(ClientsList.this, UpdateClient.class);

                //myIntent.putExtra(TakeGo_Const.ConstValue.CLIENT_ID_KEY,)

                startActivity(myIntent);
            }
        });

    }

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        addButton = (Button)findViewById( R.id.add_button );

        addButton.setOnClickListener(this);
    }

    /**
     * Handle button click events
     * DON'T WORKING!!!!!
     */
    @Override
    public void onClick(View v) {
        if ( v == addButton ) {

            //only for example
            Toast.makeText(ClientsList.this,"need to move to different activity/fragments",Toast.LENGTH_SHORT).show();

            //open the ClientProperty Activity
            Intent myIntent = new Intent(ClientsList.this, ClientProperty.class);
            startActivity(myIntent);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients_list);

        init();
        clientListView();


        findViews();
    }




}
