# MapViewByAMap

## Step 1. Add the JitPack repository to your build file

  Add it in your root build.gradle at the end of repositories:

      allprojects {
        repositories {
          ...
          maven { url 'https://www.jitpack.io' }
        }
      }
## Step 2. Add the dependency

      dependencies {
              implementation 'com.github.sinothk:MapViewByAMap:5.19.0925'
      }

# 使用
## 清单文件
      <!-- 地图SDK（包含其搜索功能）需要的基础权限 -->
      <!-- 允许程序打开网络套接字 -->
      <uses-permission android:name="android.permission.INTERNET" /> <!-- 允许程序设置内置sd卡的写权限 -->
      <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" /> <!-- 允许程序获取网络状态 -->
      <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" /> <!-- 允许程序访问WiFi网络信息 -->
      <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" /> <!-- 允许程序读写手机状态和身份 -->
      <uses-permission android:name="android.permission.READ_PHONE_STATE" /> <!-- 允许程序访问CellID或WiFi热点来获取粗略的位置 -->
      <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
      
      <meta-data
            android:name="com.amap.api.v2.apikey"
            android:value="2bef576587ffbd1f1f4ce25dcf02792c" />
     <service android:name="com.amap.api.location.APSService" />
   
   ## java
      
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
     
