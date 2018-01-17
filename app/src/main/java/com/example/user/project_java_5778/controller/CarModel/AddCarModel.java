package com.example.user.project_java_5778.controller.CarModel;

import android.content.ContentValues;
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

public class AddCarModel extends AppCompatActivity implements View.OnClickListener {


    private Button addCarModel;
    private EditText companyName_editText;
    private EditText modelName_editText;
    private EditText engineCapacity_editText;
    private EditText gearbox_editText;
    private EditText seats_editText;
    private DB_manager instance = DBManagerFactory.getInstanse();

    private void findViews() {
        addCarModel = (Button) findViewById(R.id.addButton_carModel_add);
        companyName_editText = (EditText) findViewById(R.id.companyName_editText_add);
        modelName_editText = (EditText) findViewById(R.id.modelName_editText_add);
        engineCapacity_editText = (EditText) findViewById(R.id.engineCapacity_editText_add);
        gearbox_editText = (EditText) findViewById(R.id.gearbox_editText_add);
        seats_editText = (EditText) findViewById(R.id.seats_editText_add);

        addCarModel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v == addCarModel) {
            final ContentValues contentValues = new ContentValues();

            try {
                contentValues.put(TakeGo_Const.CarModelConst.companyName, this.companyName_editText.getText().toString());
                contentValues.put(TakeGo_Const.CarModelConst.modelName, this.modelName_editText.getText().toString());
                contentValues.put(TakeGo_Const.CarModelConst.engineCapacity, this.engineCapacity_editText.getText().toString());
                contentValues.put(TakeGo_Const.CarModelConst.gearbox, this.gearbox_editText.getText().toString());
                contentValues.put(TakeGo_Const.CarModelConst.seats, this.seats_editText.getText().toString());
                //Toast.makeText(getBaseContext(), "It's working", Toast.LENGTH_LONG).show();

                new AsyncTask<Void, Void, Integer>() {

                    @Override
                    protected Integer doInBackground(Void... params) {
                        return instance.addCarModel(contentValues);
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


        DBManagerFactory.getInstanse().getCarModels();

        findViews();

    }

}
