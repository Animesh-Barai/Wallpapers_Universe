package com.ok.aork.wallpapersapp;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ViewActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button setBack;
    private InterstitialAd mInterstitialAd;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        imageView = findViewById(R.id.viewImage);
        setBack = findViewById(R.id.setBackground);


        AdView firstAd = findViewById(R.id.adView);
        MobileAds.initialize(this,"ca-app-pub-2261579018587895~6193684476");
        AdRequest adRequest = new AdRequest.Builder().build();
        firstAd.loadAd(adRequest);


        Glide.with(this).load(getIntent().getStringExtra("images")).into(imageView);

        setBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBackgroundImage();

            }
        });



        prepareAD();
        ScheduledExecutorService scheduledExecutorService =
                Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (mInterstitialAd.isLoaded()){
                            mInterstitialAd.show();
                        }
                        else {
                            Log.d("TAG", "interistial ad not loaded");
                        }
                        prepareAD();
                    }
                });
            }
        },45, 45, TimeUnit.SECONDS);

    }



    public void prepareAD(){
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2261579018587895/8628276122");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    @RequiresApi(api = Build.VERSION_CODES.ECLAIR)
    private void setBackgroundImage() {
        Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
        WallpaperManager manager =  WallpaperManager.getInstance(getApplicationContext());
        try {
            manager.setBitmap(bitmap);
            Toast.makeText(getApplicationContext(), "Set Wallpaper Successfully ", Toast.LENGTH_SHORT).show();
        }
        catch (IOException e)
        {
            Toast.makeText(this, "Wallpaper not load yet!", Toast.LENGTH_SHORT).show();
        }
    }



}
