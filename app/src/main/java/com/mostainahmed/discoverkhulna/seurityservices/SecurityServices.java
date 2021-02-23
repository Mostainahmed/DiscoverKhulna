package com.mostainahmed.discoverkhulna.seurityservices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mostainahmed.discoverkhulna.R;
import com.mostainahmed.discoverkhulna.policestation.PoliceStationActivity;

public class SecurityServices extends AppCompatActivity {

    private LinearLayout policeLinearLayout, rabLinearLayout, coastLinearLayout, forestLinearLayout;
    ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_services);

        policeLinearLayout = findViewById(R.id.policestation);
        backButton = findViewById(R.id.img_back);

        policeLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecurityServices.this, PoliceStationActivity.class));
            }
        });




        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
