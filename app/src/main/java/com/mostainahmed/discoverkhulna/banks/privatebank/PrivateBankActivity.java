package com.mostainahmed.discoverkhulna.banks.privatebank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.mostainahmed.discoverkhulna.R;

import java.util.ArrayList;
import java.util.List;

public class PrivateBankActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView backButton;
    List<PrivateBank> privateBankList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_bank);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        backButton = findViewById(R.id.img_back);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        privateBankList = new ArrayList<>();

        listOfPrivateBanks();

        PrivateBankListAdapter adapter = new PrivateBankListAdapter(this, privateBankList);
        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    public void listOfPrivateBanks(){

        privateBankList.add(
                new PrivateBank(
                        "Islami Bank Khulna",
                        "https://bit.ly/2Vz9nYh",
                        R.drawable.ic_private_banks
                )

        );
        privateBankList.add(
                new PrivateBank(
                        "Bangladesh Commerce Bank",
                        "https://bit.ly/2VPXORq",
                        R.drawable.ic_private_banks
                )
        );
        privateBankList.add(
                new PrivateBank(
                        "Dutch Bangla Bank",
                        "https://bit.ly/2HqzyfZ",
                        R.drawable.ic_private_banks
                )
        );
        privateBankList.add(
                new PrivateBank(
                        "Eastern bank khulna",
                        "https://bit.ly/2VvZlap",
                        R.drawable.ic_private_banks
                )
        );
        privateBankList.add(
                new PrivateBank(
                        "AB bank",
                        "https://bit.ly/2WVdsaS",
                        R.drawable.ic_private_banks
                )
        );
        privateBankList.add(
                new PrivateBank(
                        "Bank Asia",
                        "https://bit.ly/2JPJ7Xo",
                        R.drawable.ic_private_banks
                )
        );
        privateBankList.add(
                new PrivateBank(
                        "BRAC Bank",
                        "https://bit.ly/2LRWqt3",
                        R.drawable.ic_private_banks
                )
        );
        privateBankList.add(
                new PrivateBank(
                        "City Bank",
                        "https://bit.ly/2VvGLPL",
                        R.drawable.ic_private_banks
                )
        );
        privateBankList.add(
                new PrivateBank(
                        "Community Bank Bangladesh",
                        "https://bit.ly/2JQ5j3u",
                        R.drawable.ic_private_banks
                )
        );
        privateBankList.add(
                new PrivateBank(
                        "Dhaka Bank Limited",
                        "https://bit.ly/2EhpFiM",
                        R.drawable.ic_private_banks
                )
        );
        privateBankList.add(
                new PrivateBank(
                        "IFIC Bank Limited",
                        "https://bit.ly/2WfHpFl",
                        R.drawable.ic_private_banks
                )
        );
        privateBankList.add(
                new PrivateBank(
                        "Jamuna Bank Limited",
                        "https://bit.ly/2JttcyJ",
                        R.drawable.ic_private_banks
                )
        );
        privateBankList.add(
                new PrivateBank(
                        "Meghna Bank Limited",
                        "https://bit.ly/2VNIiWp",
                        R.drawable.ic_private_banks
                )
        );
        privateBankList.add(
                new PrivateBank(
                        "Mercantile Bank Limited",
                        "https://bit.ly/30vUsl9",
                        R.drawable.ic_private_banks
                )
        );
        privateBankList.add(
                new PrivateBank(
                        "Midland Bank Limited",
                        "https://bit.ly/2We4WXc",
                        R.drawable.ic_private_banks
                )
        );
        privateBankList.add(
                new PrivateBank(
                        "Modhumoti Bank Limited",
                        "https://bit.ly/2VCiRSy",
                        R.drawable.ic_private_banks
                )
        );
        privateBankList.add(
                new PrivateBank(
                        "Mutual Trust Bank Limited",
                        "https://bit.ly/2w9yqXu",
                        R.drawable.ic_private_banks
                )
        );
        privateBankList.add(
                new PrivateBank(
                        "National Bank Limited",
                        "https://bit.ly/2LUut3Q",
                        R.drawable.ic_private_banks
                )
        );
        privateBankList.add(
                new PrivateBank(
                        "National Credit & Commerce Bank",
                        "https://bit.ly/2YyPBhq",
                        R.drawable.ic_private_banks
                )
        );
        privateBankList.add(
                new PrivateBank(
                        "NRB Bank Limited",
                        "https://bit.ly/2w3MS3m",
                        R.drawable.ic_private_banks
                )
        );
        privateBankList.add(
                new PrivateBank(
                        "NRB Commercial Bank Ltd",
                        "https://bit.ly/2JQ1oUo",
                        R.drawable.ic_private_banks
                )
        );
        privateBankList.add(
                new PrivateBank(
                        "NRB Global Bank Limited",
                        "https://bit.ly/2VMd5D1",
                        R.drawable.ic_private_banks
                )
        );
        privateBankList.add(
                new PrivateBank(
                        "One Bank Limited",
                        "https://bit.ly/2VNTHp1",
                        R.drawable.ic_private_banks
                )
        );
        privateBankList.add(
                new PrivateBank(
                        "Padma Bank Limited",
                        "https://bit.ly/2HsIUId",
                        R.drawable.ic_private_banks
                )
        );
        privateBankList.add(
                new PrivateBank(
                        "Premier Bank Limited",
                        "https://bit.ly/30xW51I",
                        R.drawable.ic_private_banks
                )
        );
        privateBankList.add(
                new PrivateBank(
                        "Prime Bank Limited",
                        "https://bit.ly/30xW51I",
                        R.drawable.ic_private_banks
                )
        );

    }
}
