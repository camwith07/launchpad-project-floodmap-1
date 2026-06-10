//package com.example.floodmap.controller;
//import com.example.floodmap.model.FloodWarning;
//
//
//public class FloodController {
//
//    String dataPassThrough;
//
//    public FloodController() {
//        // Empty constructor
//        //this.Severity = Severity;
//    }
//    public void controlCentre() {
//        FloodWarning retrieveData = new FloodWarning();
//        dataPassThrough = retrieveData.getSeverity();
//        System.out.println("Flood warning estimation " + dataPassThrough);
//    }
//    public static void main(String[] args){
//        FloodController controller = new FloodController();
//        controller.controlCentre();
//    }
//
//}
package com.example.floodmap.controller;

import com.example.floodmap.api.FloodDataCallBack;
import com.example.floodmap.api.FloodRepository;
import com.example.floodmap.model.ApiResponse;
import com.example.floodmap.model.FloodWarning;

import java.util.ArrayList;
import java.util.List;

public class FloodController {

    public interface ControllerCallback {
        void onWarningsReady(List<FloodWarning> warnings);
        void onError(String message);
    }

    private final FloodRepository repository;

    public FloodController() {
        this.repository = new FloodRepository();
    }

    public void loadFloodWarnings(int maxSeverityLevel, ControllerCallback callback) {
        repository.fetchFloodWarnings(new FloodDataCallBack() {
            @Override
            public void onSuccess(ApiResponse response) {
                List<FloodWarning> filtered = new ArrayList<>();

                if (response != null && response.getItems() != null) {
                    for (FloodWarning warning : response.getItems()) {
                        if (warning.getSeverityLevel() <= maxSeverityLevel) {
                            filtered.add(warning);
                        }
                    }
                }

                callback.onWarningsReady(filtered);
            }

            @Override
            public void onError(Throwable t) {
                callback.onError(t != null ? t.getMessage() : "Unknown error");
            }
        });
    }
}
