package rhm.com.fragment;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.FragmentManager;


import com.example.rhm.rhmandroidapp.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link location.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link location#newInstance} factory method to
 * create an instance of this fragment.
 */
public class location extends Fragment implements OnMapReadyCallback {

    private GoogleMap myGoogleMap;

    public location() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragLocation = inflater.inflate(R.layout.fragment_location, container, false);
        getActivity().setTitle("Localisation");
        return fragLocation;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment supportMapFrag = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.myMap);
        supportMapFrag.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.myGoogleMap = googleMap;
        //on déclare les coordonnées géographique de la zone que l'ont veut marquer ( Seoul Koré du sud pour les test )
        LatLng coord = new LatLng(37.566535, 126.97796919999996);
        MarkerOptions options = new MarkerOptions();
        options.position(coord).title("L'endroit que vous cherchez certainement").snippet("Avec de petites explications en plus");
        this.myGoogleMap.addMarker(options);
        this.myGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coord,13));

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            this.myGoogleMap.setMyLocationEnabled(true);
            this.myGoogleMap.getUiSettings().setZoomControlsEnabled(true);
            this.myGoogleMap.getUiSettings().setMapToolbarEnabled(true);
            this.myGoogleMap.getUiSettings().setCompassEnabled(true);
        }
        //on zoom la caméra sur le point de destination
        //this.myGoogleMap.getUiSettings().setAllGesturesEnabled(true);
    }
}
