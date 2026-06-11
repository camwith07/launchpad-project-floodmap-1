package com.example.floodmap.view;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.floodmap.R;
import com.example.floodmap.favourites;
import com.example.floodmap.homeLayout;
import com.example.floodmap.model.FloodWarning;
import com.example.floodmap.settings;
import com.google.android.material.bottomnavigation.BottomNavigationView;


import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import com.example.floodmap.R;
import com.example.floodmap.favourites;
import com.example.floodmap.homeLayout;
import com.example.floodmap.model.FloodWarning;
import java.util.ArrayList;
import java.util.List;


public class SettingActivity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        Configuration.getInstance().setUserAgentValue(getPackageName());
        setContentView(R.layout.activity_settings);
    }
}
