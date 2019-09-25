package com.sinothk.map.amap.view.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.sinothk.map.amap.comm.MapCallback;
import com.sinothk.map.amap.poi.PoiEntity;
import com.sinothk.map.amap.poi.PoiUtil;

import java.util.ArrayList;

public class PoiSearchDemoActivity extends AppCompatActivity {

    private TextView resultTv;
    private EditText keyEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poi_search_demo);

        keyEt = findViewById(R.id.keyEt);
        resultTv = findViewById(R.id.resultTv);


    }

    public void doSearchNearbyBtn(View view) {
        int pageNum = 1;
        PoiUtil.getPoiForNearbyList(this, pageNum, 5000, new MapCallback<ArrayList<PoiEntity>>() {

            @Override
            public void onFail(String msg) {
                if (msg == null) {

                }
            }

            @Override
            public void onSuccess(ArrayList<PoiEntity> poiListInfo) {
                if (poiListInfo == null) {

                }
            }
        });
    }

    public void doSearch(View view) {

        String keyword = keyEt.getText().toString();

        int pageNum = 1;
        PoiUtil.getPoiForKeywordList(this, pageNum, keyword, new MapCallback<ArrayList<PoiEntity>>() {

            @Override
            public void onFail(String msg) {
                if (msg == null) {

                }
            }

            @Override
            public void onSuccess(ArrayList<PoiEntity> poiListInfo) {
                if (poiListInfo == null) {

                }
            }
        });
    }
}
