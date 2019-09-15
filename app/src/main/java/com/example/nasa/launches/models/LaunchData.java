package com.example.nasa.launches.models;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class LaunchData {

    int id,status,locationId,rocketId,lspId,lspType;
    String launchName, rocketImageUrl, rocketWikiURL,rocketName,lspAbbrev,lspName,lspCountryCode,lspWikiURL;

}
