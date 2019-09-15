package com.example.nasa;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nasa.launches.models.LaunchData;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class Describe extends AppCompatActivity {

    ImageView image;
//    rocketImageUrl,rocketWikiURL,lspWikiURL
    TextView launchName,rocketName,lspAbbrev,lspName,lspCountryCode,locationName, date;
    TextView launchNameTitle,rocketNameTitle,lspAbbrevTitle,lspNameTitle,lspCountryCodeTitle,locationNameTitle, dateTitle;
    TextView statusTitle,status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_describe);

        LaunchData l= (LaunchData) getIntent().getSerializableExtra("data");

        image=findViewById(R.id.image);
        Target target =new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                image.setImageBitmap(bitmap);
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

            }
            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        };

        Picasso.get().load(l.getRocketImageUrl())
                .into(target);
        launchName=findViewById(R.id.data_column1);
        launchNameTitle=findViewById(R.id.name_coloumn1);
        launchNameTitle.setText("Launch");
        launchName.setText(l.getLaunchName());

        rocketName=findViewById(R.id.data_column2);
        rocketNameTitle=findViewById(R.id.name_coloumn2);
        rocketNameTitle.setText("Rocket Name");
        rocketName.setText(l.getRocketName());

        lspAbbrev=findViewById(R.id.data_column3);
        lspAbbrevTitle=findViewById(R.id.name_coloumn3);
        lspAbbrevTitle.setText("LSP ABBREV");
        lspAbbrev.setText(l.getLspAbbrev());

        lspName=findViewById(R.id.data_column4);
        lspNameTitle=findViewById(R.id.name_coloumn4);
        lspNameTitle.setText("LSP Name");
        lspName.setText(l.getLspName());

        lspCountryCode=findViewById(R.id.data_column5);
        lspCountryCodeTitle=findViewById(R.id.name_coloumn5);
        lspCountryCodeTitle.setText("Country code");
        lspCountryCode.setText(l.getLspCountryCode());


        locationName=findViewById(R.id.data_column6);
        locationNameTitle=findViewById(R.id.name_coloumn6);
        locationNameTitle.setText("Location");
        locationName.setText(l.getLocationName());

        date=findViewById(R.id.data_column7);
        dateTitle=findViewById(R.id.name_coloumn7);
        dateTitle.setText("Date");
        date.setText(l.getDate());

        status=findViewById(R.id.data_column8);
        statusTitle=findViewById(R.id.name_coloumn8);
        String name="";
        String description="";

        switch (l.getStatus()) {

            case 1:
                name = "Go";
                description= "Launch is GO";
                break;
            case 2:
                name = "TBD";
                description = "Launch is NO-GO";
            break;
            case 3:
                name = "Success";
                description = "Launch was a success";
            break;
            case 4:
                name = "Failure";
                description = "Launch failed";
            break;
            case 5:
                name = "Hold";
                description = "Unplanned hold";
                break;
            case 6:
                name = "In Flight";
                description = "Vehicle is in flight";
                break;

            case 7:
                name = "Partial Failure";
                description = "There was a partial failure during launch";
                break;
        }
        status.setText("Status");
        status.setText(name+", "+description);
    }
}
