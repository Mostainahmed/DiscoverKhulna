package com.mostainahmed.discoverkhulna;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class DialerActivity extends AppCompatActivity {
    public static final int REQUEST_CALL = 1;
    public String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialer);

        number = getIntent().getStringExtra("number");
        if(number.equals("")){
            finish();
        }else{
            dialer(number);
        }

    }
    public void dialer(String number){
        if(ContextCompat.checkSelfPermission(DialerActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(DialerActivity.this,new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        }else{
            String uri = "tel:" + number;
            Intent i = new Intent(Intent.ACTION_DIAL);
            i.setData(Uri.parse(uri));
            startActivity(i);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CALL){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                number = getIntent().getStringExtra("number");
                dialer(number);
            }
        }else{
            Toast.makeText(this, "Permission Required", Toast.LENGTH_SHORT).show();
        }
    }
}
