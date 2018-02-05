package com.example.user.project_java_5778.controller.Car;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
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

import com.example.user.project_java_5778.R;
import com.example.user.project_java_5778.controller.Car.AddCar;
import com.example.user.project_java_5778.controller.Car.CarList;
//import com.example.user.project_java_5778.controller.Car.UpdateCar;
import com.example.user.project_java_5778.model.backend.DBManagerFactory;
import com.example.user.project_java_5778.model.backend.DB_manager;
import com.example.user.project_java_5778.model.backend.TakeGo_Const;
import com.example.user.project_java_5778.model.entities.Car;
import com.example.user.project_java_5778.model.entities.Car;

import java.util.ArrayList;
import java.util.List;


public class CarList extends Activity implements View.OnClickListener {


    private DB_manager instance = DBManagerFactory.getInstanse();
    private Button addButton;
    private ListView CarList;
    ArrayAdapter<Car> adapter;

    /**
     * make the ListView and fill it with the ArrayList of cars
     */
    private void carListView() {

        CarList = (ListView) findViewById(R.id.list_view_car);
        final List<Car> filtercars = new ArrayList<>();

        //pull the list from the database
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                filtercars.addAll(instance.getCars());
                return null;
            }
        }.execute();

        //show in every item on the viewList the car ToString implementation
        //adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,instance.getcars());

        //show in every item on the viewList the row_item.xml
        adapter = new ArrayAdapter<Car>(this, R.layout.row_item, filtercars) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = View.inflate(com.example.user.project_java_5778.controller.Car.CarList.this,
                            R.layout.row_item, null);
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
                productIdTextView.setText("Number: " + filtercars.get(position).getCarNumber());
                productFirstNameTextView.setText("Model Name: " + filtercars.get(position).getCarModel());
                productLastNameTextView.setText("Branch Number: " + filtercars.get(position).getBranchNumber());

                return convertView;
            }

            @Override
            public Filter getFilter() {
                return new Filter() {
                    @Override
                    protected FilterResults performFiltering(CharSequence constraint) {

                        FilterResults filterResults = new FilterResults();
                        //clear();
                        List<Car> temp = new ArrayList<>();
                        final List<Car> CM = new ArrayList<>();

                        new AsyncTask<Void, Void, Void>() {
                            @Override
                            protected Void doInBackground(Void... params) {
                                CM.addAll(instance.getCars());
                                return null;
                            }
                        }.execute();


                        for (Car c : CM) {

                            if (Integer.toString(Integer.getInteger(c.getCarModel())).startsWith(constraint.toString())) {
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
                        addAll((List) results.values);
                    }
                };
            }
        };

        SearchView filterSearchView = (SearchView) findViewById(R.id.searchViewCar);

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


        CarList.setAdapter(adapter);

        /**
         * when you click the item in the list view it calls to onItemClick
         */
        CarList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //open the Updatecar Activity
                //Intent myIntent = new Intent(com.example.user.project_java_5778.controller.Car.carList.this, Updatecar.class);

                //put in the intent the id of the clicked car

                //myIntent.putExtra(TakeGo_Const.ConstValue.CAR_MODEL_KEY, filtercars.get(position).getModelCode());
                //startActivity(myIntent);
            }
        });
    }


    /**
     * Find the Views in the layout
     */
    private void findViews() {
        addButton = (Button) findViewById(R.id.add_button_car);

        addButton.setOnClickListener(this);
    }

    /**
     * Handle button click events
     */
    @Override
    public void onClick(View v) {
        if (v == addButton) {

            //only for example
            //Toast.makeText(carList.this,"ADD",Toast.LENGTH_SHORT).show();

            //open the Addcar Activity
            Intent myIntent = new Intent(com.example.user.project_java_5778.controller.Car.CarList.this, AddCar.class);
            startActivity(myIntent);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);

        findViews();
    }


    @Override
    protected void onStart() {
        super.onStart();
        carListView();
    }
}
