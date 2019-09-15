package com.example.nasa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nasa.launches.view.adapters.PagerViewAdapter;

public class HomeActivity extends AppCompatActivity {

    TextView upcoming, past;
    ViewPager viewPager;
    public LinearLayout loder;

    PagerViewAdapter pagerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        upcoming = findViewById(R.id.upcominglaunches);
        loder = findViewById(R.id.loder);
        past = findViewById(R.id.pastlaunches);
        viewPager=findViewById(R.id.mainPager);

        pagerViewAdapter=new PagerViewAdapter(getSupportFragmentManager(),this);
        viewPager.setAdapter(pagerViewAdapter);


        upcoming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0);
            }
        });

        past.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
            }
        });


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                changeTabs(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void changeTabs(int position) {
        if (position==0)
        {
            upcoming.setTextColor(getResources().getColor(R.color.textTabBright));
            upcoming.setTextSize(18);

            past.setTextColor(getResources().getColor(R.color.textTabLight));
            past.setTextSize(16);

        }
        if (position==1)
        {
            upcoming.setTextColor(getResources().getColor(R.color.textTabLight));
            upcoming.setTextSize(16);

            past.setTextColor(getResources().getColor(R.color.textTabBright));
            past.setTextSize(18);

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}
