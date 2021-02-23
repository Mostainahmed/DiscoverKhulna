package com.mostainahmed.discoverkhulna;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mostainahmed.discoverkhulna.banks.BankCatagories;
import com.mostainahmed.discoverkhulna.banks.nationalbank.BankActivity;
import com.mostainahmed.discoverkhulna.hospital.HospitalActivity;
import com.mostainahmed.discoverkhulna.hotel.HotelActivity;
import com.mostainahmed.discoverkhulna.places.PlacesActivity;
import com.mostainahmed.discoverkhulna.seurityservices.SecurityServices;
import com.mostainahmed.discoverkhulna.touroperators.TourOperators;
import com.mostainahmed.discoverkhulna.transportation.Transportation;
import com.mostainahmed.discoverkhulna.website.WebListActivity;

import java.util.Locale;

public class MenuActivity extends AppCompatActivity {

    private LinearLayout hospitalLinearLayout, transportationLinearLayout, securityLinearLayout, placesLinearLayout, hotelsLinearLayout, websiteLinearLayout, bankLinearLayout, tourServicesLinearLayout;
    private TextView titleText;
    ImageView imageViewBackButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int en = getIntent().getIntExtra("english", 1);
        int bn = getIntent().getIntExtra("bangla", 1);
        if(en == 2){
            setAppLocale("en");
        }else if(bn == 1){
            setAppLocale("bn");
        }else
            setAppLocale("bn");
        setContentView(R.layout.activity_menu);

        hospitalLinearLayout = findViewById(R.id.hospitalDetails);
        //policeLinearLayout = findViewById(R.id.policeStation);
        //fireStationLinearLayout = findViewById(R.id.fireService);
        placesLinearLayout = findViewById(R.id.touristPlaces);
        hotelsLinearLayout = findViewById(R.id.hotelList);
        websiteLinearLayout = findViewById(R.id.aboutUs);
        bankLinearLayout = findViewById(R.id.bankingUs);
        transportationLinearLayout = findViewById(R.id.transportation);
        tourServicesLinearLayout = findViewById(R.id.touroperators);
        securityLinearLayout = findViewById(R.id.securityservice);
        titleText = findViewById(R.id.title_text);
        imageViewBackButton = findViewById(R.id.img_back);


        Typeface CustomFont = Typeface.createFromAsset(getAssets(), "fonts/Qonquer.ttf");
        titleText.setTypeface(CustomFont);

        hospitalLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, HospitalActivity.class));
            }
        });

        transportationLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, Transportation.class));
            }
        });

        tourServicesLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, TourOperators.class));
            }
        });

        securityLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, SecurityServices.class));
            }
        });

        placesLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, PlacesActivity.class));
            }
        });

        hotelsLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, HotelActivity.class));
            }
        });

        websiteLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, WebListActivity.class));
                //Toast.makeText(MenuActivity.this, "website", Toast.LENGTH_SHORT).show();
            }
        });
        bankLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, BankCatagories.class));
            }
        });

        imageViewBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }


    private void setAppLocale(String localCode){

        Resources res= getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration cnf = res.getConfiguration();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN_MR1){
            cnf.setLocale(new Locale(localCode.toLowerCase()));
        }else{
            cnf.locale = new Locale(localCode.toLowerCase());
        }
        res.updateConfiguration(cnf,dm);

    }
}
