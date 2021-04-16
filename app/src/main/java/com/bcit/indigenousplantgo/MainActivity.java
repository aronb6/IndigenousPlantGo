package com.bcit.indigenousplantgo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btnHousespost, btnWaypoints, btnPlants, btnQRCode, btnToponym, btnVideos;

    public static final int housepost = 1001;
    public static final int waypoints = 1002;
    public static final int plants = 1003;
    public static final int qrcode = 1004;
    public static final int waypoints2 = 1005;
    public static final int videos = 1006;
    public static final int toponym = 1007;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnHousespost = (ImageButton) findViewById(R.id.btn1);
        btnWaypoints = (ImageButton) findViewById(R.id.btn2);
        btnPlants = (ImageButton) findViewById(R.id.btn3);
        btnQRCode  = (ImageButton) findViewById(R.id.btn4);
        btnVideos = (ImageButton) findViewById(R.id.btn5);


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
                Intent intent2 = new Intent(getApplicationContext(), WaypointsActivity.class);
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
                Intent intent4 = new Intent(getApplicationContext(), QRCodeActivity.class);
                startActivityForResult(intent4, qrcode);

                // To test opening a youtube video in youtube app on Emulator as
                // QR code can't be scanned on emulator.
                /*Intent webIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.youtube.com/watch?v=49BCc6FJEK8"));
                try {
                    MainActivity.this.startActivity(webIntent);
                } catch (ActivityNotFoundException ex) {
                } */
            }
        });

        // button link to the youtube video "Healing Tools & Methods with Gerry Oldman"
        btnVideos.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.youtube.com/watch?v=yUiDIaAQYBo"));
                try {
                    MainActivity.this.startActivity(webIntent);
                } catch (ActivityNotFoundException ex) {
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
}
