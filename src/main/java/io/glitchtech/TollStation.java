package io.glitchtech;

public class TollStation {
    private String stationId;
    private Float mileStone;
    private Integer stallCount;
    
    public TollStation(String stationId, Float mileStone, Integer stallCount) {
        this.stationId = stationId;
        this.mileStone = mileStone;
        this.stallCount = stallCount;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public Float getMileStone() {
        return mileStone;
    }

    public void setMileStone(Float mileStone) {
        this.mileStone = mileStone;
    }

    public Integer getStallCount() {
        return stallCount;
    }

    public void setStallCount(Integer stallCount) {
        this.stallCount = stallCount;
    }
    
}
