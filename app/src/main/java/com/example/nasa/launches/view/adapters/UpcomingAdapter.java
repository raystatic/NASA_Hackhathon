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
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nasa.R;
import com.example.nasa.Describe;
import com.example.nasa.launches.models.LaunchData;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.Serializable;
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
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, Describe.class);

                Intent in = new Intent(context,Describe.class);
                i.putExtra("data",data);
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
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.cardView);
            launchname = itemView.findViewById(R.id.launch_name);
            rocketname = itemView.findViewById(R.id.rocket_name);
            locationname = itemView.findViewById(R.id.location_name);
            date = itemView.findViewById(R.id.date);
            image = itemView.findViewById(R.id.image);
        }
    }

}
