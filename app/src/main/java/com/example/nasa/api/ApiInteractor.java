package com.example.nasa.api;

import android.content.Context;

public class ApiInteractor {

    Context context;
    ApiRepository repository;

    public ApiInteractor(Context context, ApiRepository repository) {
        this.context = context;
        this.repository = repository;
    }



}
