package com.example.ujiangis;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in luwuk and move the camera
        LatLng luwuk = new LatLng(-0.962608658447741, 122.79176074736486);
        LatLng apotik = new LatLng(-0.9502484931876028, 122.79117543035282);
        // costum size marker
        int tinggi = 70;
        int lebar = 70;
        BitmapDrawable bitmapStart = (BitmapDrawable) getResources().getDrawable(R.drawable.pin_map_hitam);
        BitmapDrawable bitmapDes =  (BitmapDrawable) getResources().getDrawable(R.drawable.pin_map_merah);
        Bitmap s = bitmapStart.getBitmap();
        Bitmap d = bitmapDes.getBitmap();
        Bitmap markerStart = Bitmap.createScaledBitmap(s, lebar, tinggi,  false);
        Bitmap markerDes = Bitmap.createScaledBitmap(d, lebar, tinggi,false);

        // add marker to map
        mMap.addMarker(new MarkerOptions().position(luwuk).title("Marker in Luwuk")
                .snippet("Ini Adalah Rumah saya")
                .icon(BitmapDescriptorFactory.fromBitmap(markerStart)));
        mMap.addMarker(new MarkerOptions().position(apotik).title("Marker in Apotik Al-kautsar")
                .snippet("Ini adalah Apotik Al- kautsar")
                .icon(BitmapDescriptorFactory.fromBitmap(markerDes)));

        mMap.addMarker(new MarkerOptions().position(luwuk).title("Marker in Luwuk")
                .snippet("Ini adalah Luwuk")
                .icon(BitmapDescriptorFactory.fromBitmap(markerStart)));
        mMap.addMarker(new MarkerOptions().position(apotik).title("Marker in Apotik")
                .snippet("Ini adalah apotik")
                .icon(BitmapDescriptorFactory.fromBitmap(markerDes)));

        mMap.addPolyline(new PolylineOptions().add(
                luwuk,
                new LatLng( -0.9621446105155962, 122.79190971400472),
                new LatLng(-0.9623684022290929, 122.79282714345372),
                new LatLng(-0.9581055351152766, 122.79433038276942),
                new LatLng(-0.9587590156847351, 122.79282468528359),
                new LatLng(-0.9572723015883684, 122.79166151253737),
                new LatLng(-0.9578428482792967, 122.79067767398617),
                new LatLng(-0.9550835655163767, 122.7889657947902),
                new LatLng(-0.9512667999469289, 122.79080065373518),
                new LatLng(-0.9511044889496797, 122.79077113857865),
                new LatLng(-0.9502165641303083, 122.79117836810332),
                apotik
        ).width(10)
          .color(Color.BLUE));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom( luwuk, 11.5f ));
    }
}