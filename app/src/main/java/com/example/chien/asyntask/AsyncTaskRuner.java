package com.example.chien.asyntask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

public class AsyncTaskRuner extends AsyncTask<String, String, String> {

    TextView tvResult;
    EditText edtTime;
    Context context;
    private String resp;
    public ProgressDialog dialog;

    public AsyncTaskRuner(TextView tvResult, EditText edtTime, Context context) {
        this.tvResult = tvResult;
        this.edtTime = edtTime;
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {
        publishProgress("Sleeping...");
        try {
            int time = Integer.parseInt(strings[0])*1000;
            Thread.sleep(time);
            resp = "Sleep for " + strings[0] + "seconds";
        } catch (Exception e){
            e.printStackTrace();
            resp = e.getMessage();
        }
        return resp;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        if (dialog.isShowing()){
            dialog.dismiss();
        }
        tvResult.setText(s);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = ProgressDialog.show
                (context, "ProgressDialog", "Wait for " + edtTime.getText().toString() + "seconds");

    }
}
