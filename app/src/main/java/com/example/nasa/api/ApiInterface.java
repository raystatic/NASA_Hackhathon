package com.example.nasa.api;

import com.example.nasa.launches.models.LaunchData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("launch/next/{i}")
    Call<List<LaunchData>> getLaunchData(@Query("type") String type);

}
