package com.example.nasa;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

public class describe extends AppCompatActivity {

    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_describe);

//        image=findViewById(R.id.image);
//        Bundle extras = getIntent().getExtras();
//        Bitmap bmp = (Bitmap) extras.getParcelable("image");
//        image.setImageBitmap(bmp);
    }
}
