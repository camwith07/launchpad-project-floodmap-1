package com.example.floodmap.view;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import com.example.floodmap.R;
import com.example.floodmap.model.FloodWarning;
import java.util.ArrayList;
import java.util.List;


public class MapActivity extends AppCompatActivity{
    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Configuration.getInstance().setUserAgentValue(getPackageName());
        setContentView(R.layout.activity_map);

        mapView = findViewById(R.id.mapView);
        mapView.setMultiTouchControls(true);
        mapView.setTileSource(TileSourceFactory.MAPNIK);
        mapView.getController().setZoom(13.0);
        mapView.getController().setCenter(new GeoPoint(52.4778, -1.9124));

        ArrayList<FloodWarning> warnings = (ArrayList<FloodWarning>) getIntent().getSerializableExtra("warnings");

        if (warnings != null && !warnings.isEmpty()){
            displayWarnings(warnings);
        }

    }

    public void displayWarnings(List<FloodWarning>warnings){
        mapView.getOverlays().clear();
        for (FloodWarning warning: warnings){
            Marker marker = new Marker(mapView);
            marker.setPosition(new GeoPoint(warning.getLatitude(), warning.getLongitude()));
            mapView.getOverlays().add(marker);
        }
        mapView.invalidate();
    }

    @Override
    protected void onResume(){
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
        mapView.onPause();
    }

}
