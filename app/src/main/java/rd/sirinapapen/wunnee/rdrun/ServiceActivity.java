package rd.sirinapapen.wunnee.rdrun;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ServiceActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String idstring,avataString, nameString, surnameString;
    private ImageView imageView;
    private TextView nameTextView, surnameTextView;
    private int[] avataInts;
    private double userLatADouble = 13.806821, userLngADouble = 100.574754; //Connection



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_service);
        //Bind Widget
        imageView = (ImageView) findViewById(R.id.imageView7);
        nameTextView = (TextView) findViewById(R.id.textView8);
        surnameTextView = (TextView) findViewById(R.id.textView9);


        // Get Value From Intent
        idstring = getIntent().getStringExtra("id");
        avataString = getIntent().getStringExtra("Avata");
        nameString = getIntent().getStringExtra("Name");
        surnameString = getIntent().getStringExtra("Surname");

        //Show text
        nameTextView.setText(nameString);
        surnameTextView.setText(surnameString);

        // Show Avata
        MyConstant myConstant = new MyConstant();
        avataInts = myConstant.getAvataInts();
        imageView.setImageResource(avataInts[Integer.parseInt(avataString)]);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }// Main Method


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
     //Setup Center of Map
        LatLng latLng = new LatLng(userLatADouble, userLngADouble);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));

    }// onMap

}// Main Class
