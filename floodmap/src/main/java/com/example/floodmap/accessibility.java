package com.example.floodmap;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.slider.Slider;

public class accessibility extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accessibility);

        Slider slider = findViewById(R.id.textSizeSlider);
        TextView textView = findViewById(R.id.textView);

        slider.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(Slider slider, float value, boolean fromUser) {
                textView.setTextSize(value);
            }
        });
    }
}
