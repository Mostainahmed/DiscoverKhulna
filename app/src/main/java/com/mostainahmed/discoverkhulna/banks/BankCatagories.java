package com.mostainahmed.discoverkhulna.banks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mostainahmed.discoverkhulna.R;
import com.mostainahmed.discoverkhulna.banks.nationalbank.BankActivity;
import com.mostainahmed.discoverkhulna.banks.privatebank.PrivateBankActivity;

public class BankCatagories extends AppCompatActivity {

    private LinearLayout govBankLinearLayout, privateBankLinearLayout;
    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_catagories);

        govBankLinearLayout = findViewById(R.id.government_banks);
        privateBankLinearLayout = findViewById(R.id.private_banks);
        backButton = findViewById(R.id.img_back);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        govBankLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BankCatagories.this, BankActivity.class));
            }
        });
        privateBankLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BankCatagories.this, PrivateBankActivity.class));
            }
        });
    }
}
