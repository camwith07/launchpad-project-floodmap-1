package com.example.floodmap.view;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import org.osmdroid.config.Configuration;
import com.example.floodmap.R;
//import com.example.floodmap.controller.FloodController;
import com.example.floodmap.model.FloodWarning;
import com.example.floodmap.tests.TestDataHelper;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Configuration.getInstance().setUserAgentValue(getPackageName());
        setContentView(R.layout.activity_main);

        Button liveBtn = findViewById(R.id.btnLiveData);
        Button testBtn = findViewById(R.id.btnTestData);

        /**
         * Live button is not currently wired (As controller classes still need to be done
         * Will be done as soon as FloodController() is made
         */
        liveBtn.setOnClickListener(v -> {
            Toast.makeText(this, "Live Data comming soon", Toast.LENGTH_SHORT).show();
        });
        testBtn.setOnClickListener(v -> {
            List<FloodWarning> testWarnings = TestDataHelper.getTestWarnings();
            launchMap(testWarnings);
        });
    }

    private void launchMap(List<FloodWarning> warnings){
        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra("warnings", new ArrayList<>(warnings));
        startActivity(intent);
    }

}
