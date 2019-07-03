package com.snahva.sensorsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doListSensors(View view) {
        Intent intent = new Intent(this, ListSensorsActivity.class);
        startActivity(intent);
    }

    public void doSensorLight(View view) {
        try{
            Intent intent = new Intent(this, LightSensorActivity.class);
            startActivity(intent);
        }catch (Exception e){
            Log.d("--ERROR-- : ", e.toString());
        }

    }

    public void doSensorOrientation(View view) {
        Intent intent = new Intent(this, OrientationSensorActivity.class);
        startActivity(intent);
    }

    public void doBallGame(View view) {
        Intent intent = new Intent(this, BallGameActivity.class);
        startActivity(intent);
    }
}
