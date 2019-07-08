package com.example.chien.asyntask;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtnB1;
    private Button mBtnB2;
    private Button mBtnB3;
    private Button mBtnB4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        mBtnB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,Bai1Activity.class);
                startActivity(intent1);
            }
        });

        mBtnB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this,Bai2Activity.class);
                startActivity(intent2);
            }
        });

        mBtnB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this,Bai3Activity.class);
                startActivity(intent3);
            }
        });

        mBtnB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(MainActivity.this,Bai4Activity.class);
                startActivity(intent4);
            }
        });
    }

    private void initView() {
        mBtnB1 = findViewById(R.id.btnB1);
        mBtnB2 = findViewById(R.id.btnB2);
        mBtnB3 = findViewById(R.id.btnB3);
        mBtnB4 = findViewById(R.id.btnB4);
    }
}
