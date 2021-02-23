package com.mostainahmed.discoverkhulna.website;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.mostainahmed.discoverkhulna.R;

import java.util.ArrayList;
import java.util.List;

public class WebListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView backButton;
    List<Web> webList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_list);

        recyclerView = findViewById(R.id.recyclerView);
        backButton = findViewById(R.id.img_back);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        webList = new ArrayList<>();

        addWebList();

        WebListAdapter adapter = new WebListAdapter(this, webList);
        recyclerView.setAdapter(adapter);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    public void addWebList(){
        webList.add(
                new Web(
                        R.drawable.ic_website,
                        "http://www.khulna.gov.bd/",
                        "Khulna Zilla Website",
                        "All the necessary details of Khulna Zilla will be found here"
                )
        );
        webList.add(
                new Web(
                        R.drawable.ic_website,
                        "http://www.lged.gov.bd/",
                        "Bangladesh Govt. website",
                        "Bangladesh Government official Website"
                )
        );
        webList.add(
                new Web(
                        R.drawable.ic_website,
                        "https://www.bb.org.bd/",
                        "Bangladesh Bank",
                        "Bangladesh Government Bank"
                )
        );
        webList.add(
                new Web(
                        R.drawable.ic_website,
                        "https://www.btrc.gov.bd/",
                        "BTRC",
                        "BTRC | Bangladesh Telecommunication Regulatory Commission"
                )
        );
        webList.add(
                new Web(
                        R.drawable.ic_website,
                        "http://www.acc.org.bd",
                        "Anti Corruption Commission",
                        "This is the official website of Anti Corruption Commission - ACC, Bangladesh"
                )
        );
        webList.add(
                new Web(
                        R.drawable.ic_website,
                        "http://www.bard.gov.bd",
                        "BARD",
                        "Bangladesh Academy For Rural Development"
                )
        );
        webList.add(
                new Web(
                        R.drawable.ic_website,
                        "http://www.banbeis.gov.bd",
                        "BBEIS",
                        "Bangladesh Bureau Of Educational Information And Statistics"
                )
        );



    }
}
