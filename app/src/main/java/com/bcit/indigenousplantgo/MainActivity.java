package com.bcit.indigenousplantgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btnHousespost, btnWaypoints, btnPlants, btnQRCode, btnToponym;

    public static final int housepost = 1001;
    public static final int waypoints = 1002;
    public static final int plants = 1003;
    public static final int qrcode = 1004;
    public static final int waypoints2 = 1005;
    public static final int toponym = 1006;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHousespost = (ImageButton) findViewById(R.id.btn1);
        btnWaypoints = (ImageButton) findViewById(R.id.btn2);
        btnPlants = (ImageButton) findViewById(R.id.btn3);
        btnQRCode  = (ImageButton) findViewById(R.id.btn4);


        btnHousespost.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), HousepostActivity.class);
                startActivityForResult(intent1, housepost);
            }
        });

        btnWaypoints.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), Waypoints2Activity.class);
                startActivityForResult(intent2, waypoints);
            }
        });

        btnPlants.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), PlantsActivity.class);
                startActivityForResult(intent3, plants);
            }
        });

        btnQRCode.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent4 = new Intent(getApplicationContext(), QRCodeActivity.class);
                //startActivityForResult(intent4, qrcode);

                // To test opening a youtube video in youtube app on Emulator as
                // QR code can't be scanned on emulator.
                 Intent webIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.youtube.com/watch?v=49BCc6FJEK8"));
                try {
                    MainActivity.this.startActivity(webIntent);
                } catch (ActivityNotFoundException ex) {
                }
            }
        });


    }
}
