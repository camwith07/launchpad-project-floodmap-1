package com.example.floodmap.model;
import com.google.gson.annotations.SerializedName;
import java.util.List;
public class ApiResponse {
    @SerializedName("items")
    private List<FloodWarning> items;

    @SerializedName("meta")
    private Object meta;

    public ApiResponse(){}

    public List<FloodWarning> getItems(){
        return items;
    }

    public void setItems(List<FloodWarning> items){
        this.items = items;
    }

    public Object getMeta(){
        return meta;
    }

    public void setMeta(Object meta){
        this.meta = meta;
    }

}