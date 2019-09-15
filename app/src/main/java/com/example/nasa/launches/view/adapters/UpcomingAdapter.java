package com.example.nasa.launches.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nasa.R;
import com.example.nasa.launches.models.LaunchData;

import org.w3c.dom.Text;

import java.util.List;

public class UpcomingAdapter extends RecyclerView.Adapter<UpcomingAdapter.MyViewHolder> {

    Context context;
    List<LaunchData> launchData;

    public UpcomingAdapter(Context context, List<LaunchData> launchData) {
        this.context = context;
        this.launchData = launchData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.upcoming_adapter_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        LaunchData data = launchData.get(position);
        holder.locationname.setText(data.getLocationName());
        holder.rocketname.setText(data.getRocketName());
        holder.launchname.setText(data.getLaunchName());
        holder.date.setText(data.getDate());
    }

    @Override
    public int getItemCount() {
        return launchData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView launchname,rocketname,locationname,date;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            launchname = itemView.findViewById(R.id.launch_name);
            rocketname = itemView.findViewById(R.id.rocket_name);
            locationname = itemView.findViewById(R.id.location_name);
            date = itemView.findViewById(R.id.date);
        }
    }

}
