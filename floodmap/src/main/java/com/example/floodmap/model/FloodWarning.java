package com.example.floodmap.model;
import com.google.gson.annotations.SerializedName;

public class FloodWarning {

    //fields
    @SerializedName("id")
    private String id;

    @SerializedName("severity")
    private String severity;

    @SerializedName("severityLevel")
    private int severityLevel;

    @SerializedName("description")
    private String description;

    @SerializedName("message")
    private String message;

    @SerializedName("floodAreaID")
    private String floodAreaID;

    private double latitude;
    private double longitude;


    public FloodWarning(){}

    // this Flood Warning is for testing:
    public FloodWarning(String id,
                        String severity,
                        int severityLevel,
                        String description,
                        String message,
                        String floodAreaID,
                        double latitude,
                        double longitude){
        this.id = id;
        this.severity = severity;
        this.severityLevel = severityLevel;
        this.description = description;
        this.message = message;
        this.floodAreaID = floodAreaID;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getSeverity(){
        return severity;
    }

    public void setSeverity(String severity){
        this.severity = severity;
    }

    public int getSeverityLevel(){
        return severityLevel;
    }

    public void setSeverityLevel(int severityLevel){
        this.severityLevel = severityLevel;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getFloodAreaID(){
        return floodAreaID;
    }

    public void setFloodAreaID(String floodAreaID){
        this.floodAreaID = floodAreaID;
    }

    public double getLatitude(){
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude(){
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString(){
        return "FloodWarning{" +
                "id='" + id + '\'' +
                ", severity='" + severity + '\'' +
                ", severityLevel=" + severityLevel +
                ", description='" + description + '\'' +
                ", message='" + message + '\'' +
                ", floodAreaID='" + floodAreaID + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

}