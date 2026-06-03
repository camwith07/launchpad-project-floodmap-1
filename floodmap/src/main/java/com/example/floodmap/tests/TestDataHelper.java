package com.example.floodmap.tests;
import com.example.floodmap.model.FloodWarning;
import java.util.ArrayList;
import java.util.List;


public class TestDataHelper {
    public static List<FloodWarning> getTestWarnings() {
        List<FloodWarning> warnings = new ArrayList<>();

        FloodWarning w1 = new FloodWarning(
                "flood-warning-1",
                "Flood Warning",
                2,
                "River Rea at Ladywood",
                "Flooding is expected. Immediate action required.",
                "area-ladywood-001",
                52.4778,
                -1.9124
        );

        FloodWarning w2 = new FloodWarning(
                "flood-warning-2",
                "Flood Alert",
                3,
                "River Tame at Birmingham",
                "Flooding is possible. Be prepared.",
                "area-birmingham-tame-001",
                52.5200,
                -1.8900
        );

        FloodWarning w3 = new FloodWarning(
                "flood-warning-3",
                "Severe Flood Warning",
                1,
                "Bourn Brook at Selly Oak",
                "Severe flooding expected. Danger to life.",
                "area-sellyoak-001",
                52.4350,
                -1.9350
        );

        FloodWarning w4 = new FloodWarning(
                "flood-warning-4",
                "Flood Alert",
                3,
                "River Cole at Sheldon",
                "Flooding is possible in low lying areas.",
                "area-sheldon-001",
                52.4600,
                -1.7900
        );

        warnings.add(w1);
        warnings.add(w2);
        warnings.add(w3);
        warnings.add(w4);

        return warnings;
    }
}
