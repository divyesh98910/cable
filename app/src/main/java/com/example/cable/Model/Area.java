package com.example.cable.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Area {
    @SerializedName("a_id")
    @Expose
    private String aId;
    @SerializedName("area_name")
    @Expose
    private String areaName;

    public Area(String aId, String areaName) {
        this.aId = aId;
        this.areaName = areaName;
    }

    public String getAId() {
        return aId;
    }

    public void setAId(String aId) {
        this.aId = aId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

}
