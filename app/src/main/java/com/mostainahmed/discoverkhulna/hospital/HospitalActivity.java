package com.mostainahmed.discoverkhulna.hospital;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.mostainahmed.discoverkhulna.R;

import java.util.ArrayList;
import java.util.List;

public class HospitalActivity extends AppCompatActivity {

    List<Hospital> hospitalList;
    ImageView backButton;
    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        backButton = findViewById(R.id.img_back);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        hospitalList = new ArrayList<>();
        listOfHospitals();

        HospitalAdapter adapter = new HospitalAdapter(this, hospitalList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void listOfHospitals() {
        hospitalList.add(
                new Hospital(
                        10,
                        "Khulna Medical College Hospital",
                        "041-761535",
                        R.drawable.ic_call_green_24dp,
                        "Boyra, Khulna"
                ));
        hospitalList.add(
                new Hospital(
                        1,
                        "Shaheed Sheikh Abu Naser Specialised Hospital",
                        "041-760390",
                        R.drawable.ic_call_green_24dp,
                        "New Staff Quarters, Khulna"
                ));
        hospitalList.add(
                new Hospital(
                        2,
                        "Digholia Upazila Health Complex, Khulna",
                        "01711-308382",
                        R.drawable.ic_call_green_24dp,
                        "Digholia, Khulna"
                ));
        hospitalList.add(
                new Hospital(
                        3,
                        "Fortis Escorts Heart Institute,Khulna.",
                        "01755-660067",
                        R.drawable.ic_call_green_24dp,
                        "Sonadanga, Khulna"
                ));
        hospitalList.add(
                new Hospital(
                        4,
                        "Ad-Din Akij Medical College Hospital",
                        "01713-488495",
                        R.drawable.ic_call_green_24dp,
                        "Baikali Mor, Khulna"
                ));
        hospitalList.add(
                new Hospital(
                        5,
                        "Khulna BNSB Eye Hospital",
                        " 01714-028139",
                        R.drawable.ic_call_green_24dp,
                        "Shiromoni, Khulna 9100"
                ));
        hospitalList.add(
                new Hospital(
                        6,
                        "Popular General Hospital",
                        "01713-488495",
                        R.drawable.ic_call_green_24dp,
                        "Rd No. 12, Khulna"
                ));
        hospitalList.add(
                new Hospital(
                        7,
                        "Khulna Shishu Hospital",
                        "041-811704",
                        R.drawable.ic_call_green_24dp,
                        "K.D. Ghos Rd, Khulna"
                ));
        hospitalList.add(
                new Hospital(
                        8,
                        "Islami Bank Hospital",
                        "01712-068684",
                        R.drawable.ic_call_green_24dp,
                        "Khan Jahan Ali Rd, Shantidham More, Khulna 9100"
                ));
        hospitalList.add(
                new Hospital(
                        9,
                        "Moon Drops & Daps Hospital",
                        "01719-031735",
                        R.drawable.ic_call_green_24dp,
                        "145 Khan Jahan Ali Rd, Khulna 9100"
                ));
    }
}
