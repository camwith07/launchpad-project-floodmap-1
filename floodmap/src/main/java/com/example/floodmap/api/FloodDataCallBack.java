package com.example.floodmap.api;
import com.example.floodmap.model.FloodWarning;
import java.util.List;
public interface FloodDataCallBack {
    //callback interface for async data results
    void onSuccess(List<FloodWarning> warnings);
    void onError(Throwable t);
}
