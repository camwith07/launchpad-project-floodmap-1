package com.example.floodmap.model;
import org.osmdroid.util.GeoPoint;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class FloodArea {
    @SerializedName("floodAreaID")
    private String floodAreaID;

    @SerializedName("couny")
    private String county;

    @SerializedName("RiverorSea")
    private String riverOrSea;

    @SerializedName("label")
    private String label;

    private List<GeoPoint> polygon;

    public FloodArea(){}

    public FloodArea(String floodAreaID,
                     String county,
                     String riverOrSea,
                     String label,
                     List<GeoPoint> polygon) {
        this.floodAreaID = floodAreaID;
        this.county = county;
        this.riverOrSea = riverOrSea;
        this.label = label;
        this.polygon = polygon;
    }

    public String getFloodAreaID(){
        return floodAreaID;
    }

    public void setFloodAreaID(String floodAreaID){
        this.floodAreaID = floodAreaID;
    }

    public String getCounty(){
        return county;
    }

    public void setCounty(String county){
        this.county = county;
    }

    public String getRiverOrSea(){
        return riverOrSea;
    }

    public void setRiverOrSea(String riverOrSea){
        this.riverOrSea = riverOrSea;
    }

    public String getLabel(){
        return label;
    }

    public void setLabel(String Label){
        this.label = label;
    }

    public List<GeoPoint> getPolygon(){
        return polygon;
    }
    public void setPolygon(List<GeoPoint>polygon){
        this.polygon = polygon;
    }

}