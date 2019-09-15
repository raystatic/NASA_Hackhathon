package com.example.nasa.api;

import android.content.Context;
import android.util.Log;

import com.example.nasa.api.listeners.LaunchDataListener;
import com.example.nasa.launches.models.LaunchData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiInteractor {

    Context context;
    ApiRepository repository;

    public ApiInteractor(Context context, ApiRepository repository) {
        this.context = context;
        this.repository = repository;
    }

    public void getLaunchData(LaunchDataListener launchDataListener,String type){
        repository.getLaunchData(type, new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                List<LaunchData> launchDataList = (List<LaunchData>) response.body();
                if (launchDataList!=null){
                    if (launchDataList.size()>0){
                        launchDataListener.setLaunchData(launchDataList);
                    }else{
                        launchDataListener.onError("No Data Found!");
                    }
                }else{
                    launchDataListener.onError("Null response");
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                launchDataListener.onError("Something went wrong! Please try again later");
                Log.d("launcherror",t.getLocalizedMessage());
            }
        });
    }

}
