package com.sinothk.map.amap.comm;

public interface MapCallback<T> {
    void onFail(String msg);

    void onSuccess(T poiListInfo);
}
