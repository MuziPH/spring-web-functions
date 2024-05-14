package io.glitchtech.model;

public class TollRecord {
    private String stationId;
    private String licensePlate;
    private String timestamp;


    public TollRecord(String stationId, String licensePlate, String timestamp) {
        this.stationId = stationId;
        this.licensePlate = licensePlate;
        this.timestamp = timestamp;
    }

    public String getStationId() {
        return this.stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getLicensePlate() {
        return this.licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }


}
