package com.company.bean;


import com.google.gson.annotations.SerializedName;

public class TagInfo {
    @SerializedName("tag_id")
    int tagId;

    @SerializedName("tag_name")
    String tagName;

    @SerializedName("type")
    int type;

    public TagInfo(int tagId, String tagName, int type) {
        this.tagId = tagId;
        this.tagName = tagName;
        this.type = type;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}