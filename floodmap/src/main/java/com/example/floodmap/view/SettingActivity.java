package com.example.floodmap.view;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.floodmap.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


import org.osmdroid.config.Configuration;



public class SettingActivity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        Configuration.getInstance().setUserAgentValue(getPackageName());
        setContentView(R.layout.activity_settings);
        BottomNavigationView navigationMenu = findViewById(R.id.nav_bar);
        navigationMenu.setSelectedItemId(R.id.settings);
        navigationMenu.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.home){
                Intent intent = new Intent(SettingActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                return true;
            }
            else if(itemId == R.id.favourites){
                Intent intent = new Intent(SettingActivity.this, MapActivity.class);
                startActivity(intent);
                finish();
                return true;
            }
            else if(itemId == R.id.settings){
                return true;
            }
            return false;

        });
    }
}
