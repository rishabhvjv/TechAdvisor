package com.techadvisor.techadvisor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.techadvisor.techadvisor.POJO.SmartPhone;

import java.util.Random;

public class UploadDataActivity extends AppCompatActivity {

    EditText et_upload_name, et_price, et_ram, et_camera, et_battery, et_processer;
    Button btnUpload;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_data);

        et_upload_name = (EditText) findViewById(R.id.upload_name);
        et_price = (EditText) findViewById(R.id.upload_price);
        et_ram = (EditText) findViewById(R.id.upload_ram);
        et_camera = (EditText) findViewById(R.id.upload_camera);
        et_battery = (EditText) findViewById(R.id.upload_battery);
        et_processer = (EditText) findViewById(R.id.upload_processor);
        btnUpload = (Button) findViewById(R.id.btn_Upload);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("SmartPhones");

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmartPhone smartPhone = new SmartPhone(et_upload_name.getText().toString(), Integer.parseInt(et_price.getText().toString()),
                        Integer.parseInt(et_ram.getText().toString()), Integer.parseInt(et_camera.getText().toString()),
                        Integer.parseInt(et_battery.getText().toString()), Integer.parseInt(et_processer.getText().toString()));

                databaseReference.child(getSaltString()).setValue(smartPhone);
                Toast.makeText(UploadDataActivity.this,"Data successfully uploaded to server!!!",Toast.LENGTH_LONG).show();
            }
        });


    }

    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
}
