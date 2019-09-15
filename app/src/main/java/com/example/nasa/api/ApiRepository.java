package com.example.nasa.api;

import android.util.Log;

import retrofit2.Callback;

public class ApiRepository {

    ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

    public ApiRepository(){

    }

    public void getLaunchData(String type, Callback callback){
        apiInterface.getLaunchData(type).enqueue(callback);
        Log.d("launch_error",apiInterface.getLaunchData(type).request().url().toString());
    }

}
