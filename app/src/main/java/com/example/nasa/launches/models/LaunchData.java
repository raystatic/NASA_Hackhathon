package com.example.nasa.launches.models;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class LaunchData {

    int id,status,locationId,rocketId,lspId,lspType;
    String launchName, rocketImageUrl, rocketWikiURL,rocketName,lspAbbrev,lspName,lspCountryCode,lspWikiURL, locationName, date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getRocketId() {
        return rocketId;
    }

    public void setRocketId(int rocketId) {
        this.rocketId = rocketId;
    }

    public int getLspId() {
        return lspId;
    }

    public void setLspId(int lspId) {
        this.lspId = lspId;
    }

    public int getLspType() {
        return lspType;
    }

    public void setLspType(int lspType) {
        this.lspType = lspType;
    }

    public String getLaunchName() {
        return launchName;
    }

    public void setLaunchName(String launchName) {
        this.launchName = launchName;
    }

    public String getRocketImageUrl() {
        return rocketImageUrl;
    }

    public void setRocketImageUrl(String rocketImageUrl) {
        this.rocketImageUrl = rocketImageUrl;
    }

    public String getRocketWikiURL() {
        return rocketWikiURL;
    }

    public void setRocketWikiURL(String rocketWikiURL) {
        this.rocketWikiURL = rocketWikiURL;
    }

    public String getRocketName() {
        return rocketName;
    }

    public void setRocketName(String rocketName) {
        this.rocketName = rocketName;
    }

    public String getLspAbbrev() {
        return lspAbbrev;
    }

    public void setLspAbbrev(String lspAbbrev) {
        this.lspAbbrev = lspAbbrev;
    }

    public String getLspName() {
        return lspName;
    }

    public void setLspName(String lspName) {
        this.lspName = lspName;
    }

    public String getLspCountryCode() {
        return lspCountryCode;
    }

    public void setLspCountryCode(String lspCountryCode) {
        this.lspCountryCode = lspCountryCode;
    }

    public String getLspWikiURL() {
        return lspWikiURL;
    }

    public void setLspWikiURL(String lspWikiURL) {
        this.lspWikiURL = lspWikiURL;
    }
}
