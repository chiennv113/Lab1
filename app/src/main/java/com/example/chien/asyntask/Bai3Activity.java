package com.example.chien.asyntask;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Bai3Activity extends AppCompatActivity implements View.OnClickListener,Listener {

    private ImageView mImgAndroid;
    private TextView mTvMess;
    private Button mBtnLoad;

    public static final String IMAGE_URL = "https://www.cstatic-images.com/car-pictures/xl/usc90lgc053b01300.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        initView();
        mBtnLoad.setOnClickListener(this);
    }

    private void initView() {
        mImgAndroid = findViewById(R.id.imgAndroid);
        mTvMess = findViewById(R.id.tvMess);
        mBtnLoad = findViewById(R.id.btnLoad);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLoad:
                new LoadImageTask(this,this).execute(IMAGE_URL);
                break;
        }
    }

    @Override
    public void onImageLoaded(Bitmap bitmap) {
        mImgAndroid.setImageBitmap(bitmap);
        mTvMess.setText("Image Dowloaded");
    }

    @Override
    public void onError() {
        mTvMess.setText("Error dowload image");
    }
}
