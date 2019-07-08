package com.example.chien.asyntask;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Bai2Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImgAndroid;
    private TextView mTvMess;
    private Button mBtnLoad;

    private ProgressDialog progressDialog;
    private String url = "https://www.cstatic-images.com/car-pictures/xl/usc90lgc053b01300.png";
    private Bitmap bitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        initView();
        mBtnLoad.setOnClickListener(this);
    }

    private void initView() {
        mImgAndroid = findViewById(R.id.imgAndroid);
        mTvMess = findViewById(R.id.tvMess);
        mBtnLoad = findViewById(R.id.btnLoad);
    }

    private Handler messageHandler = new Handler(){
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            String message = (String) bundle.get("message");
            mTvMess.setText(message);
            mImgAndroid.setImageBitmap(bitmap);
            progressDialog.dismiss();
        }

    };

    @Override
    public void onClick(View v) {
        progressDialog = ProgressDialog.show(Bai2Activity.this,"","Dowloading...");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                bitmap = dowloadBitmap(url);
                Message msg = messageHandler.obtainMessage();
                Bundle bundle = new Bundle();
                String threadMessage = "Image downloaded";
                bundle.putString("message",threadMessage);;
                msg.setData(bundle);
                messageHandler.sendMessage(msg);
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

    private Bitmap dowloadBitmap(String link){
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();;
            InputStream inputStream = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch ( Exception e){
            e.printStackTrace();
        }
        return  null;
    }
 }
