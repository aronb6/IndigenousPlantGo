package com.summerproject.indigenousGo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class ToponymActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toponym);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {

        mMap = googleMap;

        LatLng Axachu7 = new LatLng(49.304085, -123.138770);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(Axachu7);
        markerOptions.title("Áx̱achu7");
        markerOptions.snippet("Landmark");



        mMap.addMarker(markerOptions);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Axachu7));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10));

        mMap.setOnMarkerClickListener(this);



    }
    @Override
    public boolean onMarkerClick(Marker marker) {
       MediaPlayer player = MediaPlayer.create(this,R.raw.axachu71);
       player.start();
        return true;
    }

}