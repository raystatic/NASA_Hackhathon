package com.example.nasa.api;

public class ApiRepository {

    ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

    public ApiRepository(){

    }



}
