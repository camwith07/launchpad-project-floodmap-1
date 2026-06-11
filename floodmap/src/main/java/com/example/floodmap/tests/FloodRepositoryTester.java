package com.example.floodmap.tests;
import com.example.floodmap.api.FloodRepository;
import com.example.floodmap.api.FloodDataCallBack;
import com.example.floodmap.model.ApiResponse;
import com.example.floodmap.model.FloodWarning;
import java.util.List;

public class FloodRepositoryTester {
    private final FloodRepository repository = new FloodRepository();
    public void runtest(){
        repository.fetchFloodWarnings(new FloodDataCallBack() {
            @Override
            public void onSuccess(ApiResponse response) {
                System.out.println("==Test success==");
                List<FloodWarning> warnings = response.getItems();
                System.out.println("Warnings count: " + warnings.size());

                for (int i = 0; i < Math.min(5, warnings.size()); i++){
                    FloodWarning w = warnings.get(i);
                    System.out.println("Warning "+ i +": "
                                        + w.getId() + "|"
                                        + w.getSeverity() +"|"
                                        + w.getDescription());
                }
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("==test Error==");
                t.printStackTrace();

            }
        });

    }
}
