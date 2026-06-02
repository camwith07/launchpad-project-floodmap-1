package com.example.floodmap.view;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.floodmap.R;
import com.example.floodmap.api.FloodRepository;
import com.example.floodmap.tests.FloodRepositoryTester;


public class ApiTestActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_test);//blank layout

        FloodRepositoryTester tester = new FloodRepositoryTester();
        tester.runtest();
    }
}
