package com.sinothk.map.amap.poi;

import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.poisearch.IndoorData;
import com.amap.api.services.poisearch.Photo;

import java.util.List;

public class PoiEntity {

    private String adCode;
    private String adName;
    private String title;
    private String businessArea;
    private String cityCode;
    private String provinceName;
    private String provinceCode;
    private String direction;
    private String website;
    private int distance;
    private String email;
    private LatLonPoint enter;
    private LatLonPoint exit;
    private LatLonPoint latLonPoint;
    private List<Photo> photos;
    private String tel;
    private String parkingType;
    private String typeDes;
    private IndoorData indoorData;
    private String postcode;
    private String snippet;

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LatLonPoint getEnter() {
        return enter;
    }

    public void setEnter(LatLonPoint enter) {

        this.enter = enter;
    }

    public LatLonPoint getExit() {
        return exit;
    }

    public void setExit(LatLonPoint exit) {
        this.exit = exit;
    }

    public LatLonPoint getLatLonPoint() {
        return latLonPoint;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.latLonPoint = latLonPoint;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


    public String getParkingType() {
        return parkingType;
    }

    public void setParkingType(String parkingType) {
        this.parkingType = parkingType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTypeDes() {
        return typeDes;
    }

    public void setTypeDes(String typeDes) {
        this.typeDes = typeDes;
    }


    public IndoorData getIndoorData() {
        return indoorData;
    }

    public void setIndoorData(IndoorData indoorData) {
        this.indoorData = indoorData;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getWebsite() {
        return website;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }
}
