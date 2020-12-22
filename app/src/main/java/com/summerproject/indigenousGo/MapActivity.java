package com.summerproject.indigenousGo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    // [START_EXCLUDE]
    // [START maps_marker_get_map_async]

    //Plants
    private final LatLng LAVENDER  = new LatLng(49.254500, -122.998250);
    private final LatLng KINNIKINNICK = new LatLng(49.253722, -122.998167);
    private final LatLng STRAWBERRY = new LatLng(49.253667, -123.001333);
    private final LatLng SALAL = new LatLng(49.251508, -123.003891);
    private final LatLng SNOWBERRY = new LatLng(49.253667, -122.998167);
    private final LatLng TOBACCO = new LatLng(49.245982, -122.998682);

    //Points of Interest
    private final LatLng TIEREDGARDENS = new LatLng(49.250428, -123.002965);
    private final LatLng THEGATHERINGPLACE = new LatLng(49.2508575,-123.0030182);
    private final LatLng THEHOUSEPOST = new LatLng(49.2511455,-123.0031097);
    private final LatLng THESWEATLODGE = new LatLng(49.245982, -122.998682);

    // A default location (Lavender plant location) and default zoom to use when location permission is
    // not granted.
    private final LatLng defaultLocation = new LatLng(49.254500, -122.998250);
    private static final int DEFAULT_ZOOM = 15;
    private static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;
    private boolean locationPermissionGranted;

    // The geographical location where the device is currently located. That is, the last-known
    // location retrieved by the Fused Location Provider.
    private Location lastKnownLocation;

    // Keys for storing activity state.
    // [START maps_current_place_state_keys]
    private static final String KEY_CAMERA_POSITION = "camera_position";
    private static final String KEY_LOCATION = "location";
    // [END maps_current_place_state_keys]

    private static final String TAG = MapActivity.class.getSimpleName();
    private GoogleMap map;
    private CameraPosition cameraPosition;

    // The entry point to the Fused Location Provider.
    private FusedLocationProviderClient fusedLocationProviderClient;

    private Intent intent;
    //SupportMapFragment mapFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            lastKnownLocation = savedInstanceState.getParcelable(KEY_LOCATION);
            cameraPosition = savedInstanceState.getParcelable(KEY_CAMERA_POSITION);
        }

        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_map);

        // Construct a FusedLocationProviderClient.
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        // Get the SupportMapFragment and request notification when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Toast.makeText(MapActivity.this, receivedName, Toast.LENGTH_SHORT).show();

    }
    // Saves the state of the map when the activity is paused.
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (map != null) {
            outState.putParcelable(KEY_CAMERA_POSITION, map.getCameraPosition());
            outState.putParcelable(KEY_LOCATION, lastKnownLocation);
        }
        super.onSaveInstanceState(outState);
    }

    /**
     * Manipulates the map when it's available.
     * The API invokes this callback when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user receives a prompt to install
     * Play services inside the SupportMapFragment. The API invokes this method after the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.map = googleMap;

        // Prompt the user for permission.
        getLocationPermission();

        // Turn on the My Location layer and the related control on the map.
        updateLocationUI();

        // Get the current location of the device and set the position of the map.
        getDeviceLocation();

        LatLng marker = LAVENDER;

        intent = getIntent();

        String receivedName =  intent.getStringExtra("name");

        switch(receivedName)
        {
            case "Lavender":
                marker = LAVENDER;
                break;
            case "Kinnikinnick":
                marker = KINNIKINNICK;
                break;
            case "Strawberry":
                marker = STRAWBERRY;
                break;
            case "Salal":
                marker = SALAL;
                break;
            case "Snowberry":
                marker = SNOWBERRY;
                break;
            case "Tobacco":
                marker = TOBACCO;
                break;
            case "Tiered Gardens":
                marker = TIEREDGARDENS;
                break;
            case "The Gathering Place":
                marker = THEGATHERINGPLACE;
                break;
            case "The House Post":
                marker = THEHOUSEPOST;
                break;
            case "The Sweat Lodge":
                marker = THESWEATLODGE;
                break;
            default:

        }

        //map = googleMap;

        map.addMarker(new MarkerOptions()
                .position(marker)
                .title(receivedName));
        // [START_EXCLUDE silent]
        map.moveCamera(CameraUpdateFactory.newLatLng(marker));

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker,17));
        // Zoom in, animating the camera.
        googleMap.animateCamera(CameraUpdateFactory.zoomIn());
        // Zoom out to zoom level 10, animating with a duration of 2 seconds.
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(17), 2000, null);
    }

    /**
     * Gets the current location of the device, and positions the map's camera.
     */
    // [START maps_current_place_get_device_location]
    private void getDeviceLocation() {
        /*
         * Get the best and most recent location of the device, which may be null in rare
         * cases when a location is not available.
         */
        try {
            if (locationPermissionGranted) {
                Task<Location> locationResult = fusedLocationProviderClient.getLastLocation();
                locationResult.addOnCompleteListener(this, new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        if (task.isSuccessful()) {
                            // Set the map's camera position to the current location of the device.
                            lastKnownLocation = task.getResult();
                            if (lastKnownLocation != null) {
                                map.moveCamera(CameraUpdateFactory.newLatLngZoom(
                                        new LatLng(lastKnownLocation.getLatitude(),
                                                lastKnownLocation.getLongitude()), DEFAULT_ZOOM));
                            }
                        } else {
                            Log.d(TAG, "Current location is null. Using defaults.");
                            Log.e(TAG, "Exception: %s", task.getException());
                            map.moveCamera(CameraUpdateFactory
                                    .newLatLngZoom(defaultLocation, DEFAULT_ZOOM));
                            map.getUiSettings().setMyLocationButtonEnabled(false);
                        }
                    }
                });
            }
        } catch (SecurityException e)  {
            Log.e("Exception: %s", e.getMessage(), e);
        }
    }

    // Prompts the user for permission to use the device location.
    private void getLocationPermission() {
        /*
         * Request location permission, so that we can get the location of the
         * device. The result of the permission request is handled by a callback,
         * onRequestPermissionsResult.
         */
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            locationPermissionGranted = true;
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }
    }

    /**
     * Handles the result of the request for location permissions.
     */
    // [START maps_current_place_on_request_permissions_result]
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        locationPermissionGranted = false;
        switch (requestCode) {
            case PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    locationPermissionGranted = true;
                }
            }
        }
        updateLocationUI();
    }

    /**
     * Updates the map's UI settings based on whether the user has granted location permission.
     */
    // [START maps_current_place_update_location_ui]
    private void updateLocationUI() {
        if (map == null) {
            return;
        }
        try {
            if (locationPermissionGranted) {
                map.setMyLocationEnabled(true);
                map.getUiSettings().setMyLocationButtonEnabled(true);
            } else {
                map.setMyLocationEnabled(false);
                map.getUiSettings().setMyLocationButtonEnabled(false);
                lastKnownLocation = null;
                getLocationPermission();
            }
        } catch (SecurityException e)  {
            Log.e("Exception: %s", e.getMessage());
        }
    }
}

