package com.sinothk.map.amap.view.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.sinothk.map.amap.location.AMapLocationCallback;
import com.sinothk.map.amap.location.AMapLocationEntity;
import com.sinothk.map.amap.location.MapLocationHelper;

public class LocationDemoMainActivity extends AppCompatActivity {
    String TAG = LocationDemoMainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_demo_main);

    }

    public void locBtn(View view) {
        MapLocationHelper.with(this).location(new AMapLocationCallback() {

            @Override
            public void complete(AMapLocationEntity locEntity) {
                if (locEntity.getCode() == 0) {
                    Log.e(TAG, locEntity.toString());
                } else {

                }
            }
        });
    }

    public void locUntilBtn(View view) {
        MapLocationHelper.with(this).locateContinue(3, new AMapLocationCallback() {
            @Override
            public void complete(AMapLocationEntity locEntity) {
                if (locEntity.getCode() == 0) {
                    Log.e(TAG, locEntity.toString());
                } else {

                }
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(15 * 1000);

                    MapLocationHelper.with(LocationDemoMainActivity.this).locateStop();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
