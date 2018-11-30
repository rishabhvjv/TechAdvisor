package com.techadvisor.techadvisor;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.techadvisor.techadvisor.Algorithms.Algorithm_1;
import com.techadvisor.techadvisor.POJO.SmartPhone;

import java.util.ArrayList;

public class RecommendationActivity extends AppCompatActivity {

    EditText etMinPrice, etMaxPrice, et_ram, et_camera, et_battery, et_processor;
    Button btn_recommend;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    Integer min_price, max_price, ram, processor, camera, battery;

    ProgressDialog progressDialog;

    public static ArrayList<SmartPhone> smartPhonesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);

        etMinPrice = (EditText) findViewById(R.id.etMinPrice);
        etMaxPrice = (EditText) findViewById(R.id.etMaxPrice);
        et_ram = (EditText) findViewById(R.id.et_ram);
        et_camera = (EditText) findViewById(R.id.et_camera);
        et_battery = (EditText) findViewById(R.id.et_battery);
        et_processor = (EditText) findViewById(R.id.et_processor);
        btn_recommend = (Button) findViewById(R.id.btn_recommend);

        smartPhonesList = new ArrayList<>();

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("SmartPhones");

        progressDialog = new ProgressDialog(RecommendationActivity.this);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Loading...");

        btn_recommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkFields())
                {
                    getData();
                }
                else
                {
                    Toast.makeText(RecommendationActivity.this, "Please Fill all fields!!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    void getData() {
        progressDialog.show();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snap : dataSnapshot.getChildren()) {
                    Log.d("smart_phone", "onDataChange: " + snap.getValue());
                    SmartPhone smartPhone = snap.getValue(SmartPhone.class);
                    smartPhonesList.add(smartPhone);
                    Log.d("check_3", "onDataChange: " + smartPhonesList);
                }
                getValues();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    void getValues() {
        min_price = Integer.parseInt(etMinPrice.getText().toString());
        max_price = Integer.parseInt(etMaxPrice.getText().toString());
        ram = Integer.parseInt(etMinPrice.getText().toString());
        camera = Integer.parseInt(etMinPrice.getText().toString());
        battery = Integer.parseInt(etMinPrice.getText().toString());
        processor = Integer.parseInt(etMinPrice.getText().toString());

        callAlgorithm1();
    }

    void callAlgorithm1() {
        Algorithm_1.arrangeList(min_price, max_price, ram, camera, battery, processor);
        progressDialog.dismiss();
        startActivity(new Intent(this, ShowResultActivity.class));
    }

    boolean checkFields()
    {
        String s1,s2,s3,s4,s5,s6;
        s1 = etMinPrice.getText().toString();
        s2 = etMaxPrice.getText().toString();
        s3 = et_ram.getText().toString();
        s4 = et_battery.getText().toString();
        s5 = et_camera.getText().toString();
        s6 = et_processor.getText().toString();

        if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty()||s5.isEmpty()||s6.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
