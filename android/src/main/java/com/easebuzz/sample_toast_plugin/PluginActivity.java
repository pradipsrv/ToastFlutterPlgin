package com.easebuzz.sample_toast_plugin;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.easebuzz.payment.kit.PWECouponsActivity;

import datamodels.StaticDataModel;

public class PluginActivity extends AppCompatActivity {
    public SampleToastPlugin stp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plugin);
        stp = new SampleToastPlugin();
        startPayment();
    }

    public void startPayment()
    {
        String response = "";

        Intent showactivity = new Intent(PluginActivity.this, PWECouponsActivity.class);
        showactivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivityForResult(showactivity, StaticDataModel.PWE_REQUEST_CODE);



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(data != null ) {
            String result = data.getStringExtra("result");
            stp.listenResponse(result);
        }
    }
}
