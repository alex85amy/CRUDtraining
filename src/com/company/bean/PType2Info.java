package com.company.bean;

import com.google.gson.annotations.SerializedName;

public class PType2Info {
    @SerializedName("category")
    String category;

    @SerializedName("name")
    String name;

    public PType2Info(String category, String name) {
        this.category = category;
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
