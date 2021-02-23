package com.mostainahmed.discoverkhulna.hotel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mostainahmed.discoverkhulna.R;

public class HotelDetailActivity extends AppCompatActivity {
    ImageView imageView, buttonBack;
    TextView hotelDescription, hotelPrice, textTitle, textViewNumber, textViewLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_detail);
        imageView = findViewById(R.id.imageViewOne);
        buttonBack = findViewById(R.id.img_back);
        hotelDescription = findViewById(R.id.textViewDesc);
        hotelPrice = findViewById(R.id.textViewPrice);
        textTitle = findViewById(R.id.txt_title);
        textViewNumber = findViewById(R.id.textViewNumber);
        textViewLocation = findViewById(R.id.textViewLocation);

        textTitle.setText(getIntent().getStringExtra("name"));
        hotelDescription.setText(getIntent().getStringExtra("desc"));
        hotelPrice.setText(getIntent().getStringExtra("price"));
        imageView.setImageResource(getIntent().getIntExtra("image", R.drawable.ic_bank_green_24dp));
        textViewLocation.setText(getIntent().getStringExtra("location"));
        textViewNumber.setText(getIntent().getStringExtra("number"));

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
