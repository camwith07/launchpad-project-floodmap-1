//this class should:
//builds and configures a single Retrofit instance
//uses the base URL
//Adds the Gson converter of JSON


package com.example.floodmap.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class FloodApiClient {

    private static final String baseURL ="http://environment.data.gov.uk/flood-monitoring/";
    private static  Retrofit retrofit = null;

    //private constructor  so no one accidentally does new FloodApiClient()
    private FloodApiClient(){}

    public static Retrofit getClient(){
        if (retrofit ==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static FloodApiService getApiService(){
        return getClient().create(FloodApiService.class);
    }

}
