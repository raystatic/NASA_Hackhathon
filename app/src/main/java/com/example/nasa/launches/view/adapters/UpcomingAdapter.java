package com.example.nasa.launches.view.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nasa.R;
import com.example.nasa.describe;
import com.example.nasa.launches.models.LaunchData;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

public class UpcomingAdapter extends RecyclerView.Adapter<UpcomingAdapter.MyViewHolder> {

    Bitmap image;
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

        Target target =new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                holder.image.setImageBitmap(bitmap);
                image=bitmap;
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

            }
            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        };

        Picasso.get().load(data.getRocketImageUrl())
                .into(target);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context, describe.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return launchData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView launchname,rocketname,locationname,date;
        ImageView image;
        View view;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view=itemView;
            launchname = itemView.findViewById(R.id.launch_name);
            rocketname = itemView.findViewById(R.id.rocket_name);
            locationname = itemView.findViewById(R.id.location_name);
            date = itemView.findViewById(R.id.date);
            image = itemView.findViewById(R.id.image);
        }
    }

}
