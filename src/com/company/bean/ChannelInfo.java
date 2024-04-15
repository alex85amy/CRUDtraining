package com.company.bean;

import com.google.gson.annotations.SerializedName;

public class ChannelInfo {
    @SerializedName("source_id")
    String sourceId;

    @SerializedName("source_area_id")
    String sourceAreaId;

    @SerializedName("is_used")
    int isUsed;

    @SerializedName("p_type_2")
    String pType2;

    public ChannelInfo(String sourceId, String sourceAreaId, int isUsed, String pType2) {
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceAreaId() {
        return sourceAreaId;
    }

    public void setSourceAreaId(String sourceAreaId) {
        this.sourceAreaId = sourceAreaId;
    }

    public int getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(int isUsed) {
        this.isUsed = isUsed;
    }

    public String getPType2() {
        return pType2;
    }

    public void setPType2(String pType2) {
        this.pType2 = pType2;
    }
}
