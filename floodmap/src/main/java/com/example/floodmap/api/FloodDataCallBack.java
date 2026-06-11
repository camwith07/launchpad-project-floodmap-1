//package com.example.floodmap.api;
//import com.example.floodmap.model.ApiResponse;
//import com.example.floodmap.model.FloodWarning;
//import java.util.List;
//public interface FloodDataCallBack {
//    //callback interface for async data results
//    void onSuccess(ApiResponse response);
//    void onError(Throwable t);
//}
package com.example.floodmap.api;

import com.example.floodmap.model.ApiResponse;

public interface FloodDataCallBack {
    void onSuccess(ApiResponse response);
    void onError(Throwable t);
}