package com.example.user.project_java_5778.controller.CarModel;

import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.project_java_5778.R;
import com.example.user.project_java_5778.model.backend.DBManagerFactory;
import com.example.user.project_java_5778.model.backend.DB_manager;
import com.example.user.project_java_5778.model.backend.TakeGo_Const;
import com.example.user.project_java_5778.model.entities.CarModel;
import com.example.user.project_java_5778.model.entities.Client;

public class UpdateCarModel extends AppCompatActivity implements View.OnClickListener {


    private Button addCarModel;
    private EditText companyName_editText;
    private EditText modelName_editText;
    private EditText engineCapacity_editText;
    private EditText gearbox_editText;
    private EditText seats_editText;
    private DB_manager instance = DBManagerFactory.getInstanse();
    private int carModelCode;

    private void findViews() {
        addCarModel = (Button) findViewById(R.id.addButton_carModel_update);
        companyName_editText = (EditText) findViewById(R.id.companyName_editText_update);
        modelName_editText = (EditText) findViewById(R.id.modelName_editText_update);
        engineCapacity_editText = (EditText) findViewById(R.id.engineCapacity_editText_update);
        gearbox_editText = (EditText) findViewById(R.id.gearbox_editText_update);
        seats_editText = (EditText) findViewById(R.id.seats_editText_update);

        addCarModel.setOnClickListener(this);

    }

    // initialization the text in the EditTexts to the current value of the client
    public void init() {

        Intent intent = getIntent();
        carModelCode = intent.getIntExtra(TakeGo_Const.ConstValue.CAR_MODEL_KEY, -1);
        final CarModel carModel = new CarModel();

        new AsyncTask<Void, Void, CarModel>() {

            @Override
            protected CarModel doInBackground(Void... params) {

                return instance.getCarModel(carModelCode);
            }

            @Override
            protected void onPostExecute(CarModel idResult) {
                if (idResult.getModelCode() > 0) {

                    carModel.setModelCode(idResult.getModelCode());
                    carModel.setCompanyName(idResult.getCompanyName());
                    carModel.setModelName(idResult.getCompanyName());
                    carModel.setEngineCapacity(idResult.getEngineCapacity());
                    carModel.setGearbox(idResult.getGearbox());
                    carModel.setSeats(idResult.getModelCode());
                }
                finish();
            }


        }.execute();

        companyName_editText.setText(carModel.getCompanyName());
        modelName_editText.setText(carModel.getModelName());
        engineCapacity_editText.setText(Integer.toString(carModel.getEngineCapacity()));
        seats_editText.setText(Integer.toString(carModel.getSeats()));

        //gearbox_editText.setText(carModel.getGearbox());
    }

    @Override
    public void onClick(View v) {

        if (v == addCarModel) {
            final ContentValues contentValues = new ContentValues();

            try {
                contentValues.put(TakeGo_Const.CarModelConst.modelCode, carModelCode);
                contentValues.put(TakeGo_Const.CarModelConst.companyName, this.companyName_editText.getText().toString());
                contentValues.put(TakeGo_Const.CarModelConst.modelName, this.modelName_editText.getText().toString());
                contentValues.put(TakeGo_Const.CarModelConst.engineCapacity, this.engineCapacity_editText.getText().toString());
                contentValues.put(TakeGo_Const.CarModelConst.gearbox, this.gearbox_editText.getText().toString());
                contentValues.put(TakeGo_Const.CarModelConst.seats, this.seats_editText.getText().toString());
                //Toast.makeText(getBaseContext(), "It's working", Toast.LENGTH_LONG).show();

                new AsyncTask<Void, Void, Void>() {

                    @Override
                    protected Void doInBackground(Void... params) {
                        instance.updateCarModel(carModelCode, contentValues);

                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void idResult) {

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
        setContentView(R.layout.activity_update_car_model);


        DBManagerFactory.getInstanse().getCarModels();

        findViews();
        init();
    }

}
