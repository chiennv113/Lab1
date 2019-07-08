package com.example.chien.asyntask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

public class Bai1Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImgAndroid;
    private TextView mTvMess;
    private Button mBtnLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        initView();
        mBtnLoad.setOnClickListener(this);
    }

    private Bitmap loadImageFromNetWork(String link){
        URL url;
        Bitmap bitmap = null;
        try {
            url = new URL(link);
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e){
            e.printStackTrace();
        }
        return bitmap;
    }

    private void initView() {
        mImgAndroid = findViewById(R.id.imgAndroid);
        mTvMess = findViewById(R.id.tvMess);
        mBtnLoad = findViewById(R.id.btnLoad);
    }

    @Override
    public void onClick(View v) {
        final Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap = loadImageFromNetWork("https://www.cstatic-images.com/car-pictures/xl/usc90lgc053b01300.png");
                mImgAndroid.post(new Runnable() {
                    @Override
                    public void run() {
                        mTvMess.setText("Image Dowloaded");
                        mImgAndroid.setImageBitmap(bitmap);
                    }
                });
            }
        });

        myThread.start();
    }
}
