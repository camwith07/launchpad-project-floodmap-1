// What this should do is:
//call base URL
//hit the endpoint: /id/floods
//return an ApiResponse(which contains List<FloodWarning>)


package com.example.floodmap.api;
import com.example.floodmap.model.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FloodApiService {

    @GET("id/floods")
    Call<ApiResponse> getFloodWarnings();

    @GET("id/floods")
    Call<ApiResponse> getFloodWarningByCounty(@Query("floodArea.county") String county);
}
