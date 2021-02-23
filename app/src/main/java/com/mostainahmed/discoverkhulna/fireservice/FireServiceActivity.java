package com.mostainahmed.discoverkhulna.fireservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.mostainahmed.discoverkhulna.R;
import com.mostainahmed.discoverkhulna.hospital.Hospital;

import java.util.ArrayList;
import java.util.List;

public class FireServiceActivity extends AppCompatActivity {

    List<FireService> fireServiceList;

    ImageView backButton;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_service);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        backButton = findViewById(R.id.img_back);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fireServiceList = new ArrayList<>();
        listOfFireService();

        FireServiceAdapter adapter = new FireServiceAdapter(this, fireServiceList);
        recyclerView.setAdapter(adapter);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void listOfFireService() {
        fireServiceList.add(
                new FireService(
                        1,
                        "Khalishpur Fire Station",
                        "041-761005",
                        R.drawable.ic_call_green_24dp,
                        "Khalishpur, Khulna"
                )
        );
        fireServiceList.add(
                new FireService(
                        2,
                        "Daulatpur Fire Station & Civil Defense",
                        "041-762052",
                        R.drawable.ic_call_green_24dp,
                        "Daulatpur, Khulna"
                )
        );
        fireServiceList.add(
                new FireService(
                        3,
                        "Khulna Land and River Fire Station",
                        "041-890048",
                        R.drawable.ic_call_green_24dp,
                        "Rupsha, Khulna"
                )
        );
        fireServiceList.add(
                new FireService(
                        4,
                        "Fire Service And Civil Defense",
                        "041-760333",
                        R.drawable.ic_call_green_24dp,
                        "Fulbari Gate, Khulna"
                )
        );
        fireServiceList.add(
                new FireService(
                        5,
                        "Fire Service and Civil Defence",
                        "01767-897013",
                        R.drawable.ic_call_green_24dp,
                        "Boyra, Khulna"
                )
        );
        fireServiceList.add(
                new FireService(
                        6,
                        "Noapara Fire Station",
                        "01611-934071",
                        R.drawable.ic_call_green_24dp,
                        "Noapara, Khulna"
                )
        );



    }
}
