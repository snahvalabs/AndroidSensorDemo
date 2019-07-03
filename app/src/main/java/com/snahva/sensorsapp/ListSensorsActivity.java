package com.snahva.sensorsapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class ListSensorsActivity extends AppCompatActivity {

    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sensors);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        listSensors();
    }

    void listSensors(){
        List<Sensor> sensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        StringBuilder sensorText = new StringBuilder();
        for(Sensor currentSensor : sensorList){
            sensorText.append(currentSensor.getName())
                        .append("\n");
        }
        TextView tvSensorList = findViewById(R.id.tv_sensors_list);
        tvSensorList.setText(sensorText);
    }

}
