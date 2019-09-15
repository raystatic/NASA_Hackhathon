package com.example.nasa.launches.view.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.nasa.HomeActivity;
import com.example.nasa.R;
import com.example.nasa.api.ApiInteractor;
import com.example.nasa.api.ApiRepository;
import com.example.nasa.api.listeners.LaunchDataListener;
import com.example.nasa.launches.models.LaunchData;
import com.example.nasa.launches.view.adapters.UpcomingAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PastFragment extends Fragment implements LaunchDataListener {

    RecyclerView recyclerView;
    UpcomingAdapter adapter;
    HomeActivity homeActivity;


    public PastFragment(HomeActivity homeActivity) {
        // Required empty public constructor
        this.homeActivity=homeActivity;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_past, container, false);

        recyclerView = view.findViewById(R.id.pastrv);

        ApiInteractor apiInteractor = new ApiInteractor(this.requireContext(),new ApiRepository());
        apiInteractor.getLaunchData(this,"getPastLaunches");

        return view;
    }

    @Override
    public void setLaunchData(List<LaunchData> launchData) {
        adapter = new UpcomingAdapter(this.requireContext(),launchData);
        LinearLayoutManager layoutManager =new LinearLayoutManager(this.requireContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        homeActivity.loder.setVisibility(View.GONE);
    }

    @Override
    public void onError(String error) {
        homeActivity.loder.setVisibility(View.GONE);
        Toast.makeText(this.requireContext(),error,Toast.LENGTH_SHORT).show();
    }
}
