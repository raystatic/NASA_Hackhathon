package com.example.nasa.api.listeners;

import com.example.nasa.launches.models.LaunchData;

import java.util.List;

public interface LaunchDataListener {

    void setLaunchData(List<LaunchData> launchData);

    void onError(String error);

}
