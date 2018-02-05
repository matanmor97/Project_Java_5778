package com.example.user.project_java_5778.controller.Car;

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


public class AddCar extends AppCompatActivity implements View.OnClickListener {


    private Button addCar;
    private EditText branchNumber_editText;
    private EditText carModelCode_editText;
    private EditText kilometers_editText;
    private EditText carNumber_editText;
    private DB_manager instance = DBManagerFactory.getInstanse();

    private void findViews() {
        addCar = (Button) findViewById(R.id.addButton_car_add);
        branchNumber_editText = (EditText) findViewById(R.id.branchNumber_editText_add);
        carModelCode_editText = (EditText) findViewById(R.id.carModelCode_editText_add);
        kilometers_editText = (EditText) findViewById(R.id.kilometers_editText_add);
        carNumber_editText = (EditText) findViewById(R.id.carNumber_editText_add);

        addCar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v == addCar) {
            final ContentValues contentValues = new ContentValues();

            try {
                contentValues.put(TakeGo_Const.CarConst.branchNumber, this.branchNumber_editText.getText().toString());
                contentValues.put(TakeGo_Const.CarConst.carModelCode, this.carModelCode_editText.getText().toString());
                contentValues.put(TakeGo_Const.CarConst.kilometers, this.kilometers_editText.getText().toString());
                contentValues.put(TakeGo_Const.CarConst.carNumber, this.carNumber_editText.getText().toString());
                //Toast.makeText(getBaseContext(), "It's working", Toast.LENGTH_LONG).show();

                new AsyncTask<Void, Void, Integer>() {

                    @Override
                    protected Integer doInBackground(Void... params) {
                        return instance.addCar(contentValues);
                    }

                    @Override
                    protected void onPostExecute(Integer idResult) {
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
        setContentView(R.layout.activity_add_car_model);


        DBManagerFactory.getInstanse().getCars();

        findViews();

    }

}
