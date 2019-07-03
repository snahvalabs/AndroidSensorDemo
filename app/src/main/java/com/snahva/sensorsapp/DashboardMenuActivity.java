package com.snahva.sensorsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DashboardMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_menu);
    }

    public void doHash(View view) {
        Intent intent = new Intent(DashboardMenuActivity.this,LightSensorActivity.class);
        startActivity(intent);
    }
}
