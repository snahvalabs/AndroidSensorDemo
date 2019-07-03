package com.snahva.sensorsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.nfc.TagLostException;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import static android.os.PowerManager.PROXIMITY_SCREEN_OFF_WAKE_LOCK;

public class LightSensorActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager mSensorManager;
    private Sensor mSensorLight, mSensorProximity, mSensorGyro;
    TextView mLblSensorL, mLblSensorP, mLblSensorG;

    String msgNoSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sensor_cahaya);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        mLblSensorL = findViewById(R.id.tv_sensor_cahaya);
        mLblSensorP = findViewById(R.id.tv_sensor_proximity);
        mLblSensorG = findViewById(R.id.tv_sensor_gyri);

        mSensorProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        mSensorLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mSensorGyro = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        msgNoSensor = getResources().getString(R.string.no_sensor);

        testSensor();

   }


    void testSensor(){
        if(mSensorLight == null){
            mLblSensorL.setText("Light Sensor : " + msgNoSensor);
        }

        if(mSensorProximity == null){
            mLblSensorP.setText("Proximity Sensor : " + msgNoSensor);
        }

        if(mSensorGyro== null){
            mLblSensorG.setText("Gyroscope Sensor : " + msgNoSensor);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mSensorGyro != null){
            mSensorManager.registerListener(this, mSensorGyro,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }

        if(mSensorProximity != null){
            mSensorManager.registerListener(this, mSensorProximity,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }

        if(mSensorLight != null){
            mSensorManager.registerListener(this, mSensorLight,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onStop(){
        super.onStop();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        int sensorTYpe = sensorEvent.sensor.getType();

        float currentValue = sensorEvent.values[0];
        switch (sensorTYpe){
            case Sensor.TYPE_LIGHT:
                mLblSensorL.setText("Sensor Cahaya : " + currentValue);
                break;
            case Sensor.TYPE_PROXIMITY:
                mLblSensorP.setText("Sensor Kedekatan : " + currentValue);
                break;

            case Sensor.TYPE_GYROSCOPE:
                mLblSensorG.setText("Sensor Gyroscope : " + currentValue);
                break;
            default:

        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
