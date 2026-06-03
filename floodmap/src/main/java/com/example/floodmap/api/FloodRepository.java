package com.example.floodmap.api;
import com.example.floodmap.model.ApiResponse;
import com.example.floodmap.model.FloodWarning;
import com.example.floodmap.api.FloodApiClient;
import com.example.floodmap.api.FloodApiService;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * FloodRepository
 *
 * -this is the class that is called by the controller
 * -it uses FloodApiClient + FloodApiService to talk to the Environment Agency API
 * -it fetches the JSON data asynchronously and returns it via a callback
 */
public class FloodRepository {

    private final FloodApiService apiService;

    public FloodRepository(){
        this.apiService = FloodApiClient.getApiService();
    }

    /**
     * fetchFloodWarnings as the name suggests fetches ALL the flood warnings returned by the API
     */

    public void fetchFloodWarnings(final FloodDataCallBack callback){
        Call<ApiResponse> call = apiService.getFloodWarnings();
        call.enqueue(new Callback<ApiResponse>(){

            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response){
                if (!response.isSuccessful()){
                    callback.onError(new Exception("HTTP error code: "+ response.code()));
                    return;
                }
                ApiResponse body = response.body();

                if (body == null){
                    callback.onError(new Exception("Response body is null "));
                    return;
                }
                List<FloodWarning> warnings = body.getItems();
                if (warnings == null){
                    warnings = Collections.emptyList();
                }

                callback.onSuccess(body);
            }
            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t){
                callback.onError(t);
            }
        });

    }






}
