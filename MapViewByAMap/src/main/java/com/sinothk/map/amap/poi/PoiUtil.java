package com.sinothk.map.amap.poi;

import android.content.Context;
import android.util.Log;

import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.sinothk.map.amap.comm.MapCallback;
import com.sinothk.map.amap.location.AMapLocationCallback;
import com.sinothk.map.amap.location.AMapLocationEntity;
import com.sinothk.map.amap.location.MapLocationHelper;

import java.util.ArrayList;

public class PoiUtil {

    private static final String TAG = PoiUtil.class.getSimpleName();

    public static void getPoiForNearbyList(Context context, int pageNum, int accuracy, MapCallback mapCallback) {
        getPoiForNearbyList(context, pageNum, 20, accuracy, mapCallback);
    }

    private static void getPoiForNearbyList(final Context context, final int pageNum, final int pageSize, final int accuracy, final MapCallback mapCallback) {

        MapLocationHelper.with(context).location(new AMapLocationCallback() {

            @Override
            public void complete(AMapLocationEntity locEntity) {
                if (locEntity.getCode() == 0) {

                    PoiSearch.Query query = new PoiSearch.Query("", "", "");
                    //keyWord表示搜索字符串，
                    //第二个参数表示POI搜索类型，二者选填其一，选用POI搜索类型时建议填写类型代码，码表可以参考下方（而非文字）
                    //cityCode表示POI搜索区域，可以是城市编码也可以是城市名称，也可以传空字符串，空字符串代表全国在全国范围内进行搜索
                    query.setPageSize(pageSize);// 设置每页最多返回多少条poiitem
                    query.setPageNum(pageNum);//设置查询页码

                    PoiSearch poiSearch = new PoiSearch(context, query);
                    poiSearch.setOnPoiSearchListener(new PoiSearch.OnPoiSearchListener() {

                        @SuppressWarnings("unchecked")
                        @Override
                        public void onPoiSearched(PoiResult poiResult, int i) {
                            if (mapCallback != null) {
                                mapCallback.onSuccess(getPoiListInfo(poiResult));
                            }
                        }

                        @Override
                        public void onPoiItemSearched(PoiItem poiItem, int i) {
                            if (poiItem == null) {

                            }
                        }
                    });
                    poiSearch.searchPOIAsyn();
                    poiSearch.setBound(new PoiSearch.SearchBound(new LatLonPoint(
                            locEntity.getLatitude(), locEntity.getLongitude())
                            , accuracy));//设置周边搜索的中心点以及半径
                } else {
                    mapCallback.onFail(locEntity.getMsg());
                }
            }
        });


    }

    private static ArrayList<PoiEntity> getPoiListInfo(PoiResult poiResult) {

        if (poiResult == null || poiResult.getPois() == null || poiResult.getPois().size() == 0) {
            return new ArrayList<>();
        }

        ArrayList<PoiEntity> listData = new ArrayList<>();

        for (PoiItem poi : poiResult.getPois()) {
            Log.e(TAG, poi.toString());

            PoiEntity poiEntity = new PoiEntity();

            poiEntity.setAdCode(poi.getAdCode());
            poiEntity.setAdName(poi.getAdName());
            poiEntity.setBusinessArea(poi.getBusinessArea());
            poiEntity.setCityCode(poi.getCityCode());
            poiEntity.setCityName(poi.getCityName());
            poiEntity.setProvinceCode(poi.getProvinceCode());
            poiEntity.setProvinceName(poi.getProvinceName());
            poiEntity.setDirection(poi.getDirection());
            poiEntity.setDistance(poi.getDistance());
            poiEntity.setEmail(poi.getEmail());
            poiEntity.setEnter(poi.getEnter());
            poiEntity.setExit(poi.getExit());
            poiEntity.setLatLonPoint(poi.getLatLonPoint());
            poiEntity.setPhotos(poi.getPhotos());
            poiEntity.setTel(poi.getTel());
            poiEntity.setParkingType(poi.getParkingType());
            poiEntity.setTitle(poi.getTitle());
            poiEntity.setTypeDes(poi.getTypeDes());
            poiEntity.setWebsite(poi.getWebsite());
            poiEntity.setIndoorData(poi.getIndoorData());
            poiEntity.setPostcode(poi.getPostcode());
            poiEntity.setSnippet(poi.getSnippet());

            listData.add(poiEntity);
        }
        return listData;
    }

    /**
     * @param context
     * @param pageNum
     * @param keyword
     * @param callback
     */
    public static void getPoiForKeywordList(final Context context, int pageNum, String keyword, MapCallback<ArrayList<PoiEntity>> callback) {
        getPoiForKeywordList(context, pageNum, 20, keyword, "", callback);
    }

    /**
     * @param context
     * @param pageNum
     * @param keyword
     * @param adCode
     * @param callback
     */
    public static void getPoiForKeywordList(final Context context, int pageNum, String keyword, String adCode, MapCallback<ArrayList<PoiEntity>> callback) {
        getPoiForKeywordList(context, pageNum, 20, keyword, adCode, callback);
    }

    /**
     * @param context
     * @param pageNum
     * @param pageSize
     * @param keyword
     * @param adCode
     * @param mapCallback
     */
    public static void getPoiForKeywordList(final Context context, int pageNum, int pageSize, String keyword, String adCode, final MapCallback<ArrayList<PoiEntity>> mapCallback) {

        PoiSearch.Query query = new PoiSearch.Query(keyword, "", adCode);
        //keyWord表示搜索字符串，
        //第二个参数表示POI搜索类型，二者选填其一，选用POI搜索类型时建议填写类型代码，码表可以参考下方（而非文字）
        //cityCode表示POI搜索区域，可以是城市编码也可以是城市名称，也可以传空字符串，空字符串代表全国在全国范围内进行搜索
        query.setPageSize(pageSize);// 设置每页最多返回多少条poiitem
        query.setPageNum(pageNum);//设置查询页码

        PoiSearch poiSearch = new PoiSearch(context, query);
        poiSearch.setOnPoiSearchListener(new PoiSearch.OnPoiSearchListener() {

            @Override
            public void onPoiSearched(PoiResult poiResult, int i) {
                if (mapCallback != null) {
                    mapCallback.onSuccess(getPoiListInfo(poiResult));
                }
            }

            @Override
            public void onPoiItemSearched(PoiItem poiItem, int i) {
                if (poiItem == null) {

                }
            }
        });
        poiSearch.searchPOIAsyn();
    }
}
