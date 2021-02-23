package com.mostainahmed.discoverkhulna;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mostainahmed.discoverkhulna.maps.MapsActivity;
import com.mostainahmed.discoverkhulna.maps.MapsActivity2;

public class DetailsActivity extends AppCompatActivity {

    TextView textViewTitle, textViewShortDesc, textViewHowToGo;
    ImageView imageViewOne, imageViewTwo, imageViewThree;
    Button googleMap;
    ImageView backButton;
    String longitude, latitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        textViewTitle = findViewById(R.id.txt_title);
        textViewShortDesc = findViewById(R.id.textViewDesc);
        textViewHowToGo = findViewById(R.id.textViewHowToGo);
        imageViewOne = findViewById(R.id.imageViewOne);
        imageViewTwo = findViewById(R.id.imageViewTwo);
        imageViewThree= findViewById(R.id.imageViewThree);
        googleMap = findViewById(R.id.googleMapButton);
        backButton = findViewById(R.id.img_back);

        final String title = getIntent().getStringExtra("TITLE");

        textViewTitle.setText(getIntent().getStringExtra("TITLE"));
        textViewShortDesc.setText(getIntent().getStringExtra("DESC"));
        textViewHowToGo.setText(getIntent().getStringExtra("RULES"));
        imageViewOne.setImageResource(getIntent().getIntExtra("ONE", R.drawable.ic_places));
        imageViewTwo.setImageResource(getIntent().getIntExtra("TWO",R.drawable.ic_places));
        imageViewThree.setImageResource(getIntent().getIntExtra("THREE",R.drawable.ic_places));
        longitude = getIntent().getStringExtra("LONG");
        latitude = getIntent().getStringExtra("LAT");

        googleMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isNetworkConnected()){
                    Intent i = new Intent(DetailsActivity.this, MapsActivity2.class);
                    i.putExtra("TITLE",title);
                    i.putExtra("LONG1",longitude);
                    i.putExtra("LAT1", latitude);
                    startActivity(i);
                }else Toast.makeText(DetailsActivity.this, "Please connect to the internet", Toast.LENGTH_SHORT).show();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
