package com.example.chien.asyntask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai4Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEdtTime;
    private Button mBtnRun;
    private TextView mTvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        initView();

        mBtnRun.setOnClickListener(this);


    }

    private void initView() {
        mEdtTime = findViewById(R.id.edtTime);
        mBtnRun = findViewById(R.id.btnRun);
        mTvResult = findViewById(R.id.tvResult);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRun:
                AsyncTaskRuner asyncTaskRuner = new AsyncTaskRuner(mTvResult,mEdtTime,this);
                String sleepTime = mEdtTime.getText().toString();
                asyncTaskRuner.execute(sleepTime);
                break;
        }
    }
}
