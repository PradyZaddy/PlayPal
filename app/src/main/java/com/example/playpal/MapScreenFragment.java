package com.example.playpal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import org.maplibre.android.MapLibre;
import org.maplibre.android.camera.CameraPosition;
import org.maplibre.android.geometry.LatLng;
import org.maplibre.android.maps.MapLibreMap;
import org.maplibre.android.maps.MapView;
import org.maplibre.android.maps.OnMapReadyCallback;
import org.maplibre.android.maps.Style;
import org.maplibre.android.annotations.MarkerOptions;
import java.util.ArrayList;
import java.util.List;

public class MapScreenFragment extends Fragment {
    private MapView mapView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Initialize MapLibre
        MapLibre.getInstance(requireContext());

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map_screen, container, false);

        // Initialize MapView
        mapView = view.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull MapLibreMap mapLibreMap) {
                mapLibreMap.setStyle(new Style.Builder().fromUri("https://api.maptiler.com/maps/basic-v2/style.json?key=tVXrLSTgtVeYX9RNuJsx"));

                // Set initial camera position
                mapLibreMap.setCameraPosition(new CameraPosition.Builder()
                        .target(new LatLng(50.67573281130573, -120.34401137561703))
                        .zoom(11.0)
                        .build());

                // Add markers after style is loaded
                mapLibreMap.setStyle(new Style.Builder()
                                .fromUri("https://api.maptiler.com/maps/basic-v2/style.json?key=tVXrLSTgtVeYX9RNuJsx"),
                        new Style.OnStyleLoaded() {
                            @Override
                            public void onStyleLoaded(@NonNull Style style) {
                                // list of marker locations
                                List<MarkerOptions> markers = new ArrayList<>();

                                // Add markers
                                markers.add(new MarkerOptions()
                                        .position(new LatLng(50.66834797844717, -120.36555155565617))
                                        .title("Tournament Capital Centre")
                                        .snippet("Multi-purpose sports and recreation facility, offering a variety of events, including tournaments, fitness activities, and community programs."));

                                markers.add(new MarkerOptions()
                                        .position(new LatLng(50.74161168121386, -120.12083304741242))
                                        .title("Paul Lake Provincial Park")
                                        .snippet("A beautiful spot for hiking, swimming, and kayaking. Great for outdoor activities in nature."));

                                markers.add(new MarkerOptions()
                                        .position(new LatLng(50.662397325405394, -120.402954376738))
                                        .title("Kenna Cartwright Park")
                                        .snippet("Popular park for hiking, biking, and scenic views of Kamloops."));

                                markers.add(new MarkerOptions()
                                        .position(new LatLng(50.67851007498256, -120.3372978709366))
                                        .title("Riverside Park")
                                        .snippet("A lovely park with outdoor volleyball, tennis courts, walking trails, and beautiful river views."));

                                markers.add(new MarkerOptions()
                                        .position(new LatLng(50.69568617164387, -120.37185837813531))
                                        .title("Kamloops Skatepark")
                                        .snippet("A popular spot for skateboarding and BMX biking, offering fun and challenging ramps."));

                                markers.add(new MarkerOptions()
                                        .position(new LatLng(50.69633719180566, -120.37720968950924))
                                        .title("McArthur Island Park")
                                        .snippet("Features baseball fields, soccer fields, tennis courts, and a great place for outdoor sports."));

                                markers.add(new MarkerOptions()
                                        .position(new LatLng(50.883734871681945, -119.88926209320084))
                                        .title("Sun Peaks Resort")
                                        .snippet("Famous resort offering skiing, snowboarding, and mountain biking throughout the year."));

                                markers.add(new MarkerOptions()
                                        .position(new LatLng(50.71295303159929, -120.41411791775484))
                                        .title("The Bunker Indoor Golf")
                                        .snippet("Golf simulators and virtual golf experience, perfect for golf enthusiasts."));

                                markers.add(new MarkerOptions()
                                        .position(new LatLng(50.6537660588332, -120.36521536067579))
                                        .title("Anytime Fitness Kamloops")
                                        .snippet("24/7 gym with state-of-the-art equipment and personal training services. Open to members anytime."));

                                markers.add(new MarkerOptions()
                                        .position(new LatLng(50.66054496472459, -120.36226270485477))
                                        .title("Gold's Gym Kamloops")
                                        .snippet("A well-equipped gym offering strength training, cardio, and group fitness classes."));

                                mapLibreMap.addMarkers(markers);
                            }
                        });
            }
        });

        return view;
    }

    // Lifecycle methods
    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}