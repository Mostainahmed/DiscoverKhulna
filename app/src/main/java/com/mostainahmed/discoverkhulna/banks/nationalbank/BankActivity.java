package com.mostainahmed.discoverkhulna.banks.nationalbank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.mostainahmed.discoverkhulna.R;

import java.util.ArrayList;
import java.util.List;

public class BankActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView backButton;
    List<Bank> bankList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        backButton = findViewById(R.id.img_back);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        bankList = new ArrayList<>();

        listOfBanks();

        BankListAdapter adapter = new BankListAdapter(this, bankList);
        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    public void listOfBanks(){
        bankList.add(
                new Bank(
                        "Sonali Bank Limited",
                        "041720793",
                        "South Central Road Branch, Khulna",
                        "https://www.sonalibank.com.bd/",
                        R.drawable.ic_bank_green_24dp
                )
        );

        bankList.add(
                new Bank(
                        "Janata Bank Limited",
                        "041722412",
                        "Upper Jessore Rd, Khulna",
                        "https://www.jb.com.bd/",
                        R.drawable.ic_bank_green_24dp
                )
        );


        bankList.add(
                new Bank(
                        "Bangladesh Bank",
                        "041-723191",
                        "Khulna 9100",
                        "https://www.bb.org.bd/",
                        R.drawable.ic_bank_green_24dp
                )
        );
        bankList.add(
                new Bank(
                        "Agrani Bank",
                        "01713253783",
                        "Rupsha Ghat Rd, Khulna",
                        "https://www.agranibank.org/",
                        R.drawable.ic_bank_green_24dp
                )
        );
        bankList.add(
                new Bank(
                        "Rupali Bank Limited",
                        "041722064",
                        "Upper Jessore Rd, Khulna",
                        "http://www.rupalibank.org/",
                        R.drawable.ic_bank_green_24dp
                )
        );


    }
}
