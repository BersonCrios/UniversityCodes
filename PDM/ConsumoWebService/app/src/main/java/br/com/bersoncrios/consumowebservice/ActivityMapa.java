package br.com.bersoncrios.consumowebservice;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ActivityMapa extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    String lat = null;
    String longi = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mapa);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Bundle dicionario = this.getIntent().getExtras();

          lat = dicionario.getString("latitude");
          longi = dicionario.getString("longitude");


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

        LatLng locale = new LatLng(Double.parseDouble(lat),Double.parseDouble(longi));
        mMap.addMarker(new MarkerOptions().position(locale).title("Minha localizaçao"));
        CameraUpdate camera = CameraUpdateFactory.newLatLngZoom(locale, 15);
        mMap.moveCamera(camera);
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }
}
