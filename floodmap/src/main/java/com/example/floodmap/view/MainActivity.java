package com.example.floodmap.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.floodmap.R;
import com.example.floodmap.controller.FloodController;
import com.example.floodmap.model.FloodWarning;
import com.example.floodmap.tests.FloodRepositoryTester;
import com.example.floodmap.tests.TestDataHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.example.floodmap.homeLayout;
import com.example.floodmap.settings;

import org.osmdroid.config.Configuration;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private FloodController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration.getInstance().setUserAgentValue(getPackageName());
        setContentView(R.layout.activity_main);

        controller = new FloodController();

        Button liveBtn = findViewById(R.id.btnLiveData);
        Button testBtn = findViewById(R.id.btnTestData);
        BottomNavigationView navigationMenu = findViewById(R.id.nav_bar);

        // Set default fragment
        replaceFragment(new homeLayout());
        
        navigationMenu.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.home) {
                replaceFragment(new homeLayout());
            } else if (itemId == R.id.favourites) {
                List<FloodWarning> testWarnings = TestDataHelper.getTestWarnings();
                launchMap(testWarnings);
            }
            else if (itemId == R.id.settings) {
                replaceFragment(new settings());
            }
            return true;
        });

        liveBtn.setOnClickListener(v ->
                controller.loadFloodWarnings(2, new FloodController.ControllerCallback() {
                    @Override
                    public void onWarningsReady(List<FloodWarning> warnings) {
                        runOnUiThread(()->{
                            if (warnings == null || warnings.isEmpty()){
                                new AlertDialog.Builder(MainActivity.this)
                                        .setTitle("No Live Flood Warnings")
                                        .setMessage("There are currently no flood warnings")
                                        .setPositiveButton("Got it", (dialog, which)-> dialog.dismiss())
                                                .show();
                            }
                            else{
                                launchMap(warnings);
                            }
                        });

                        //runOnUiThread(() -> launchMap(warnings));
                    }

                    @Override
                    public void onError(String message) {
                        runOnUiThread(() ->
                                Toast.makeText(
                                        MainActivity.this,
                                        "Error loading live data. Try Demo Mode.\n" + message,
                                        Toast.LENGTH_LONG
                                ).show()
                        );
                    }
                })
        );

        testBtn.setOnClickListener(v -> {
            List<FloodWarning> testWarnings = TestDataHelper.getTestWarnings();
            launchMap(testWarnings);
        });
        
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
        
        // Hide/Show the original main buttons depending on which fragment is shown
        View mainContent = findViewById(R.id.main_content);
        if (mainContent != null) {
            if (fragment instanceof homeLayout) {
                mainContent.setVisibility(View.VISIBLE);
            } else {
                mainContent.setVisibility(View.GONE);
            }
        }
    }

    private void launchMap(List<FloodWarning> warnings) {
        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra("warnings", new ArrayList<>(warnings));
        startActivity(intent);
    }
}