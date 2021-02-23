package com.mostainahmed.discoverkhulna.policestation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.mostainahmed.discoverkhulna.R;

import java.util.ArrayList;
import java.util.List;

public class PoliceStationActivity extends AppCompatActivity {

    private List<PoliceStation> policeStationList;
    ImageView backButton;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_station);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        backButton = findViewById(R.id.img_back);

        policeStationList = new ArrayList<>();

        listOfPoliceStation();

        PoliceStationAdapter adapter = new PoliceStationAdapter(this, policeStationList);
        recyclerView.setAdapter(adapter);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void listOfPoliceStation() {
        policeStationList.add(
                new PoliceStation(
                        1,
                        "Daulatpur Thana",
                        "01713-373293",
                        R.drawable.ic_call_green_24dp,
                        "Daulatpur, Khulna"
                )
        );
        policeStationList.add(
                new PoliceStation(
                        2,
                        "Khalishpur Thana",
                        "01713-373287",
                        R.drawable.ic_call_green_24dp,
                        "Khalishpur, Khulna"
                )
        );
        policeStationList.add(
                new PoliceStation(
                        3,
                        "Arongghata Police Station",
                        "01558-328305",
                        R.drawable.ic_call_green_24dp,
                        "Arongghata, Khulna"
                )
        );
        policeStationList.add(
                new PoliceStation(
                        4,
                        "Khulna Sadar Police Station",
                        "01713-373285",
                        R.drawable.ic_call_green_24dp,
                        "Dak Banglow, Khulna"
                )
        );
        policeStationList.add(
                new PoliceStation(
                        5,
                        "Digholia Police Station",
                        "041-890014",
                        R.drawable.ic_call_green_24dp,
                        "Digholia, Khulna"
                )
        );
        policeStationList.add(
                new PoliceStation(
                        6,
                        "Horintana Thana",
                        "01711-211904",
                        R.drawable.ic_call_green_24dp,
                        "Lobonchora, Khulna"

                )

        );
        policeStationList.add(
                new PoliceStation(
                        7,
                        "Khanjahan Ali Thana",
                        "041-785457",
                        R.drawable.ic_call_green_24dp,
                        "Shiromoni, Khulna"

                )

        );
        policeStationList.add(
                new PoliceStation(
                        8,
                        "Sonadanga Model Police Station",
                        "01713-373286",
                        R.drawable.ic_call_green_24dp,
                        "Majid Sarani, Khulna 9200"

                )

        );

    }
}
