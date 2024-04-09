package com.company;

public class tag_info {
    int tag_id;
    String tag_name;
    int type;

    public tag_info(int tag_id, String tag_name, int type) {
        this.tag_id = tag_id;
        this.tag_name = tag_name;
        this.type = type;
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
