package com.sinothk.map.amap.view.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MapViewMainDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_view_main_demo);
    }

    public void gotoPoiSearch(View view) {
        startActivity(new Intent(MapViewMainDemoActivity.this, PoiSearchDemoActivity.class));
    }

    public void gotoMapView(View view) {
        startActivity(new Intent(MapViewMainDemoActivity.this, MapViewByAMapMainActivity.class));
    }

    public void gotoLoc(View view) {
        startActivity(new Intent(MapViewMainDemoActivity.this, LocationDemoMainActivity.class));
    }


}
