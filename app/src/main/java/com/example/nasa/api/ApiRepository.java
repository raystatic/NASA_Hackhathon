package com.example.nasa.api;

import retrofit2.Callback;

public class ApiRepository {

    ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

    public ApiRepository(){

    }

    public void getLaunchData(String type, Callback callback){
        apiInterface.getLaunchData(type).enqueue(callback);
    }

}
