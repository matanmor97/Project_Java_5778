package com.example.user.project_java_5778.controller;

import android.app.Activity;
import android.content.Intent;
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
import com.example.user.project_java_5778.model.entities.CarModel;
import com.example.user.project_java_5778.model.entities.Client;

import java.util.ArrayList;
import java.util.List;


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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.project_java_5778.R;
import com.example.user.project_java_5778.model.backend.DBManagerFactory;
import com.example.user.project_java_5778.model.backend.DB_manager;
import com.example.user.project_java_5778.model.backend.TakeGo_Const;
import com.example.user.project_java_5778.model.datasource.List_DBManager;
import com.example.user.project_java_5778.model.entities.Car;
import com.example.user.project_java_5778.model.entities.Client;

import java.util.ArrayList;
import java.util.List;


public class CarModelList extends Activity implements View.OnClickListener {


    private DB_manager instance = DBManagerFactory.getInstanse();
    private Button addButton;
    private ListView CarModelList;
    ArrayAdapter<CarModel> adapter;




    /**
     * initialization
     */
    private void init() {
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

    /**
     * make the ListView and fill it with the ArrayList of CarModel
     */
    private void CarModelListView() {

        CarModelList = (ListView) findViewById(R.id.list_view_carModel);
        final List<CarModel> filterCarModels = new ArrayList<>();
        filterCarModels.addAll(instance.getCarModels());
        //show in every item on the viewList the CarModel ToString implementation
        //adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,instance.getCarModels());

        //show in every item on the viewList the row_item.xml
        adapter = new ArrayAdapter<CarModel>(this, R.layout.row_item, filterCarModels) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent)
            {
                if (convertView == null)
                {
                    convertView = View.inflate(CarModelList.this,
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
                productIdTextView.setText("Model Code: " + instance.getCarModels().get(position).getModelCode());
                productFirstNameTextView.setText("Model Name: " + instance.getCarModels().get(position).getModelName());
                productLastNameTextView.setText("Company Name: " + instance.getCarModels().get(position).getCompanyName());

                return convertView;
            }

            @Override
            public Filter getFilter() {
                return new Filter() {
                    @Override
                    protected FilterResults performFiltering(CharSequence constraint) {

                        FilterResults filterResults = new FilterResults();
                        clear();
                        //List<Client> temp = new ArrayList<>();

                        for (CarModel c : instance.getCarModels()) {

                            if (c.getModelName().startsWith(constraint.toString())) {
                                filterCarModels.add(c);
                            }
                        }
                        //notifyDataSetChanged();
                        //filterResults.values = filterCarModels;
                        //filterResults.count = filterCarModels.size();

                        return null;
                    }

                    @Override
                    protected void publishResults(CharSequence constraint, FilterResults results) {

                    }
                };
            }
        };

        SearchView filterSearchView = (SearchView) findViewById(R.id.searchViewCarModel);

        filterSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                adapter.notifyDataSetChanged();
                return false;
            }
        });


        CarModelList.setAdapter(adapter);

        /**
         * when you click the item in the list view it calls to onItemClick
         */
        CarModelList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //open the UpdateClient Activity
                Intent myIntent = new Intent(CarModelList.this, UpdateClient.class);

                //put in the intent the id of the clicked client

                myIntent.putExtra(TakeGo_Const.ConstValue.CAR_MODEL_KEY, instance.getCarModels().get(position).getModelCode());

                startActivity(myIntent);
            }
        });




    }


    /**
     * Find the Views in the layout
     */
    private void findViews() {
        addButton = (Button) findViewById(R.id.add_button_carModel);

        addButton.setOnClickListener(this);
    }

    /**
     * Handle button click events
     */
    @Override
    public void onClick(View v) {
        if (v == addButton) {

            //only for example
            Toast.makeText(CarModelList.this,"ADD",Toast.LENGTH_SHORT).show();

            //open the ?? Activity
            Intent myIntent = new Intent(CarModelList.this, ClientProperty.class);
            startActivity(myIntent);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_model_list);


        init();
        findViews();
    }


    @Override
    protected void onStart() {
        super.onStart();
        CarModelListView();
    }
}
