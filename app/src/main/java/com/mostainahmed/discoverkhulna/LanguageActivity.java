package com.mostainahmed.discoverkhulna;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;
import com.shashank.sony.fancydialoglib.FancyAlertDialogListener;
import com.shashank.sony.fancydialoglib.Icon;

import java.util.Locale;

public class LanguageActivity extends AppCompatActivity {

    Button bangla, english;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        bangla = findViewById(R.id.bangla);
        english = findViewById(R.id.english);

        bangla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LanguageActivity.this, MenuActivity.class);
                i.putExtra("bangla",1);
                startActivity(i);
            }
        });

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LanguageActivity.this, MenuActivity.class);
                i.putExtra("english",2);
                startActivity(i);
            }
        });

    }
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        new FancyAlertDialog.Builder(this)
                .setTitle("Are you sure?")
                .setBackgroundColor(Color.parseColor("#823038"))  //Don't pass R.color.colorvalue
                .setMessage("Do you really want to Exit ?")
                .setNegativeBtnText("Cancel")
                .setPositiveBtnBackground(Color.parseColor("#823038"))  //Don't pass R.color.colorvalue
                .setPositiveBtnText("Exit")
                .setNegativeBtnBackground(Color.parseColor("#60ad5e"))  //Don't pass R.color.colorvalue
                .setAnimation(Animation.SLIDE)
                .isCancellable(true)
                .setIcon(R.drawable.ic_exit, Icon.Visible)
                .OnPositiveClicked(new FancyAlertDialogListener() {
                    @Override
                    public void OnClick() {
                        finish();
                    }
                })
                .OnNegativeClicked(new FancyAlertDialogListener() {
                    @Override
                    public void OnClick() {

                    }
                })
                .build();
    }

}
