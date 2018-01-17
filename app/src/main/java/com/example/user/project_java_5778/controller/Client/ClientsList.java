package com.example.user.project_java_5778.controller.Client;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.project_java_5778.R;
import com.example.user.project_java_5778.model.backend.DBManagerFactory;
import com.example.user.project_java_5778.model.backend.DB_manager;
import com.example.user.project_java_5778.model.backend.TakeGo_Const;
import com.example.user.project_java_5778.model.entities.Client;

import java.util.ArrayList;
import java.util.List;


// need to add SEARCH option

public class ClientsList extends Activity implements View.OnClickListener {

    private DB_manager instance = DBManagerFactory.getInstanse();
    private Button addButton;
    private ListView clientList;
    ArrayAdapter<Client> adapter;





    /**
     * make the ListView and fill it with the ArrayList of clients
     */
    private void clientListView() {

        clientList = (ListView) findViewById(R.id.list_view_client);
        final List<Client> filterClients = new ArrayList<>();

        //pull the list from the database
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                filterClients.addAll(instance.getClients());
                return null;
            }
        }.execute();

        //show in every item on the viewList the Client ToString implementation
        //adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,instance.getClients());


        //show in every item on the viewList the row_item.xml
        adapter = new ArrayAdapter<Client>(this, R.layout.row_item, filterClients) {
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
                TextView productFirstNameTextView = (TextView) convertView
                        .findViewById(R.id.firstNameTextView);
                TextView productLastNameTextView = (TextView) convertView
                        .findViewById(R.id.lastNameTextView);
                ImageView productionImageView = (ImageView) convertView
                        .findViewById(R.id.image_view);
                //put the data in the views
                productIdTextView.setText("ID: " + Long.toString(filterClients.get(position).getId()));
                productFirstNameTextView.setText("First Name: " + filterClients.get(position).getFirstName());
                productLastNameTextView.setText("Last Name: " + filterClients.get(position).getLastName());

                return convertView;
            }

            @Override
            public Filter getFilter() {
                return new Filter() {
                    @Override
                    protected FilterResults performFiltering(CharSequence constraint) {

                        FilterResults filterResults = new FilterResults();
                        // clear();
                        List<Client> temp = new ArrayList<>();

                        for (Client c : instance.getClients()) {

                            if (c.getLastName().startsWith(constraint.toString())) {
                                temp.add(c);
                            }
                        }
                        //notifyDataSetChanged();
                        filterResults.values = temp;
                        filterResults.count = temp.size();

                        return filterResults;
                    }

                    @Override
                    protected void publishResults(CharSequence constraint, FilterResults results) {
                        clear();
                        addAll((List)results.values);


                        notifyDataSetChanged();
                    }
                };
            }
        };

        SearchView filterSearchView = (SearchView) findViewById(R.id.searchViewClient);

        filterSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });


        clientList.setAdapter(adapter);

        /**
         * when you click the item in the list view it calls to onItemClick
         */
        clientList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //open the UpdateClient Activity
                Intent myIntent = new Intent(ClientsList.this, UpdateClient.class);

                //put in the intent the id of the clicked client

                myIntent.putExtra(TakeGo_Const.ConstValue.CLIENT_ID_KEY, filterClients.get(position).getId());

                startActivity(myIntent);
            }
        });




    }


    /**
     * Find the Views in the layout
     */
    private void findViews() {
        addButton = (Button) findViewById(R.id.add_button_client);

        addButton.setOnClickListener(this);
    }

    /**
     * Handle button click events
     * DON'T WORKING!!!!!
     */
    @Override
    public void onClick(View v) {
        if (v == addButton) {

            //only for example
            //Toast.makeText(ClientsList.this, "need to move to different activity/fragments", Toast.LENGTH_SHORT).show();
            //Toast.makeText(ClientsList.this,"ADD",Toast.LENGTH_SHORT).show();

            //open the ClientProperty Activity
            Intent myIntent = new Intent(ClientsList.this, ClientProperty.class);
            startActivity(myIntent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients_list);

        //init();
        findViews();

    }


    @Override
    protected void onStart() {
        super.onStart();
        clientListView();
    }
}
