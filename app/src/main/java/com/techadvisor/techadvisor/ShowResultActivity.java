package com.techadvisor.techadvisor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.techadvisor.techadvisor.Adapters.SmartphoneRecyclerAdapter;
import com.techadvisor.techadvisor.Algorithms.Algorithm_1;
import com.techadvisor.techadvisor.POJO.WeightedSmartPhone;

import java.util.ArrayList;

public class ShowResultActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SmartphoneRecyclerAdapter adapter;
    ArrayList<WeightedSmartPhone> smartPhones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);

        smartPhones = Algorithm_1.list1;
        recyclerView = (RecyclerView) findViewById(R.id.rvList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SmartphoneRecyclerAdapter(this,smartPhones);
        recyclerView.setAdapter(adapter);
    }
}
