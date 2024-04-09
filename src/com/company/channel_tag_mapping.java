package com.company;

public class channel_tag_mapping {
    String s_area_id;
    int tag_id;

    public channel_tag_mapping(String s_area_id, int tag_id) {
        this.s_area_id = s_area_id;
        this.tag_id = tag_id;
    }

    public String getS_area_id() {
        return s_area_id;
    }

    public void setS_area_id(String s_area_id) {
        this.s_area_id = s_area_id;
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }
}
