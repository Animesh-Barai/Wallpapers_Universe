package com.ok.aork.wallpapersapp;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private List<Custom_Items> list;
    public CustomAdapter adapter;
    private Toolbar toolbar;
    private TextView textView;
    NetworkInfo info;
    ProgressDialog dialog;
    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        dialog = new ProgressDialog(this);


        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(CONNECTIVITY_SERVICE);
        info = cm.getActiveNetworkInfo();
        if (info != null) {


            Toast.makeText(MainActivity.this, "Loading..", Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(this, "No Internet Connection!", Toast.LENGTH_LONG).show();

        }

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        list = new ArrayList<>();


        list.add(new Custom_Items("https://images.pexels.com/photos/1236701/pexels-photo-1236701.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        list.add(new Custom_Items("https://images.pexels.com/photos/257840/pexels-photo-257840.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        list.add(new Custom_Items("https://images.pexels.com/photos/1020315/pexels-photo-1020315.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        list.add(new Custom_Items("https://images.pexels.com/photos/1624496/pexels-photo-1624496.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        list.add(new Custom_Items("https://images.pexels.com/photos/443446/pexels-photo-443446.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        list.add(new Custom_Items("https://images.pexels.com/photos/853199/pexels-photo-853199.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        list.add(new Custom_Items("https://images.pexels.com/photos/1918290/pexels-photo-1918290.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        list.add(new Custom_Items("https://images.pexels.com/photos/1308624/pexels-photo-1308624.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        list.add(new Custom_Items("https://images.pexels.com/photos/67636/rose-blue-flower-rose-blooms-67636.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        list.add(new Custom_Items("https://images.pexels.com/photos/799443/pexels-photo-799443.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        list.add(new Custom_Items("https://images.pexels.com/photos/1591447/pexels-photo-1591447.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        list.add(new Custom_Items("https://images.pexels.com/photos/814499/pexels-photo-814499.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        list.add(new Custom_Items("https://images.pexels.com/photos/326055/pexels-photo-326055.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        list.add(new Custom_Items("https://images.pexels.com/photos/531321/pexels-photo-531321.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        list.add(new Custom_Items("https://images.pexels.com/photos/842711/pexels-photo-842711.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        list.add(new Custom_Items("https://images.pexels.com/photos/60597/dahlia-red-blossom-bloom-60597.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        list.add(new Custom_Items("https://images.pexels.com/photos/1040626/pexels-photo-1040626.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        list.add(new Custom_Items("https://images.pexels.com/photos/1227520/pexels-photo-1227520.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        list.add(new Custom_Items("https://images.pexels.com/photos/1366957/pexels-photo-1366957.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));



        list.add(new Custom_Items("https://images.pexels.com/photos/1930851/pexels-photo-1930851.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));

        list.add(new Custom_Items("https://images.pexels.com/photos/1999665/pexels-photo-1999665.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        list.add(new Custom_Items("https://images.pexels.com/photos/1978126/pexels-photo-1978126.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        list.add(new Custom_Items("https://images.pexels.com/photos/1933239/pexels-photo-1933239.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        list.add(new Custom_Items("https://images.pexels.com/photos/1959302/pexels-photo-1959302.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        list.add(new Custom_Items("https://images.pexels.com/photos/1938352/pexels-photo-1938352.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        list.add(new Custom_Items("https://images.pexels.com/photos/2006745/pexels-photo-2006745.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        list.add(new Custom_Items("https://images.pexels.com/photos/2019028/pexels-photo-2019028.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        list.add(new Custom_Items("https://images.pexels.com/photos/1575841/pexels-photo-1575841.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        list.add(new Custom_Items("https://images.pexels.com/photos/1603503/pexels-photo-1603503.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        list.add(new Custom_Items("https://images.pexels.com/photos/1696678/pexels-photo-1696678.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));






        getdata();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




        AdView firstAd = findViewById(R.id.adView);
        MobileAds.initialize(this,"ca-app-pub-2261579018587895~6193684476");
        AdRequest adRequest = new AdRequest.Builder().build();
        firstAd.loadAd(adRequest);


}

    private void getdata() {


        adapter = new CustomAdapter(list, this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));

        }
        if (id == R.id.action_exit) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to Exit?");
            builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    dialog.cancel();

                }
            });
            AlertDialog d = builder.create();
            d.show();

        }

        if (id == R.id.action_search) {

            finish();
            startActivity(getIntent());
            if (info != null) {
                getdata();

            } else {


                Toast.makeText(this, "Internet Not Connected!", Toast.LENGTH_SHORT).show();
            }


        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.wallpaper) {

            getdata();


        } else if (id == R.id.favorites) {

            getdata();

        } else if (id == R.id.Settings) {

            startActivity(new Intent(MainActivity.this, SettingsActivity.class));


        } else if (id == R.id.rate_us) {
            rateme();
        } else if (id == R.id.more_app) {
            MoreApp();
        }
        //Shere
        else if (id == R.id.shere) {


            Intent myintent = new Intent(Intent.ACTION_SEND);
            myintent.setType("text/plan");

            String shereBoday = "Your Boday Here";

            String shereSub = "\"http://play.google.com/store/apps/details?id=" + getPackageName();
            myintent.putExtra(Intent.EXTRA_SUBJECT, shereBoday);
            myintent.putExtra(Intent.EXTRA_TEXT, shereSub);
            startActivity(Intent.createChooser(myintent, "shere Using"));

        }


        //Exit


        else if (id == R.id.exit) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to Exit?");
            builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    dialog.cancel();

                }
            });
            AlertDialog d = builder.create();
            d.show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void MoreApp() {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://developer?id=" + "Account Name!")));
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/developer?id=" + "Account Name!")));


        }
    }




    public void rateme() {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + "Your Package name!")));
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
        }
    }


    /*interistail*/



}