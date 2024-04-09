package com.company.bean;

public class channel_info {
    String source_id;
    String soure_area_id;
    int is_used;
    String p_type_2;

    public channel_info(String source_id, String soure_area_id, int is_used, String p_type_2) {
        this.source_id = source_id;
        this.soure_area_id = soure_area_id;
        this.is_used = is_used;
        this.p_type_2 = p_type_2;
    }

    public String getSource_id() {
        return source_id;
    }

    public void setSource_id(String source_id) {
        this.source_id = source_id;
    }

    public String getSoure_area_id() {
        return soure_area_id;
    }

    public void setSoure_area_id(String soure_area_id) {
        this.soure_area_id = soure_area_id;
    }

    public int getIs_used() {
        return is_used;
    }

    public void setIs_used(int is_used) {
        this.is_used = is_used;
    }

    public String getP_type_2() {
        return p_type_2;
    }

    public void setP_type_2(String p_type_2) {
        this.p_type_2 = p_type_2;
    }
}
