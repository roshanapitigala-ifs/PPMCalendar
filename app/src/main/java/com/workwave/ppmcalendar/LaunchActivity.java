package com.workwave.ppmcalendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.workwave.ppmcalendar.s1.MainActivity;
import com.workwave.ppmcalendar.s2.GVActivity;
import com.workwave.ppmcalendar.s3.PSHActivity;

public class LaunchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_activity);
    }

    public void onClickS1(View v){
        startActivity(new Intent(this, MainActivity.class));
    }

    public void onClickS2(View v){
        startActivity(new Intent(this, GVActivity.class));
    }

    public void onClickS3(View v){
        startActivity(new Intent(this, PSHActivity.class));
    }
}
