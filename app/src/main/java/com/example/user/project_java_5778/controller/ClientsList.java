package com.example.user.project_java_5778.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.project_java_5778.R;
import com.example.user.project_java_5778.model.backend.DBManagerFactory;
import com.example.user.project_java_5778.model.backend.DB_manager;
import com.example.user.project_java_5778.model.backend.TakeGo_Const;
import com.example.user.project_java_5778.model.datasource.List_DBManager;
import com.example.user.project_java_5778.model.entities.Car;
import com.example.user.project_java_5778.model.entities.Client;

import java.util.List;


//need to add SEARCH option

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

        clientList = (ListView)findViewById(R.id.list_view);

        //show in every item on the viewList the Client ToString implementation
        //AsyncTask<Void, Integer, Void>???
        //adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,instance.getClients());

        //show in every item on the viewList the row_item.xml
        adapter = new ArrayAdapter<Client>(this,R.layout.row_item,instance.getClients())
        {
            @Override
            public View getView(int position, View convertView, ViewGroup parent)
            {
                if (convertView == null)
                {
                    convertView = View.inflate(ClientsList.this,
                            R.layout.row_item,null);
                }
                //Find the Views in the layout
                TextView productIdTextView = (TextView) convertView
                        .findViewById(R.id.idTextView);
                TextView productNameTextView = (TextView) convertView
                        .findViewById(R.id.nameTextView);
                ImageView productionImageView = (ImageView) convertView
                        .findViewById(R.id.image_view);
                //put the data in the views
                productIdTextView.setText(Long.toString(instance.getClients().get(position).getId()));
                productNameTextView.setText(instance.getClients().get(position).getFirstName() + " , " + instance.getClients().get(position).getLastName());

                return convertView;
            }

           /* filter
            @NonNull
            @Override
            public Filter getFilter() {

                return new Filter() {
                    @Override
                    protected FilterResults performFiltering(CharSequence constraint) {
                        return null;
                    }

                    @Override
                    protected void publishResults(CharSequence constraint, FilterResults results) {

                    }
                };
            }*/
        };


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

                //put in the intent the id of the clicked client

                myIntent.putExtra(TakeGo_Const.ConstValue.CLIENT_ID_KEY , instance.getClients().get(position).getId());

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
