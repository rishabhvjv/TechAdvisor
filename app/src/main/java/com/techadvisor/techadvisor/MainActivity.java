package com.techadvisor.techadvisor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnrecommend, btnbolg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnrecommend = (Button)findViewById(R.id.btn_RecommendSmartPhone);
        btnbolg = (Button)findViewById(R.id.btn_gotoblog);

        btnrecommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent thisIntent = new Intent(MainActivity.this,RecommendationActivity.class);
                startActivity(thisIntent);
            }
        });



    }
}
