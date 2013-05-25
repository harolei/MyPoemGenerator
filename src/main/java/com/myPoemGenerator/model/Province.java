package com.myPoemGenerator.model;

public class Province {
    private String proName;
    private String proID;

    public Province(String proID, String proName){
        this.proID = proID;
        this.proName = proName;
    }

    public String getProName() {
        return proName;
    }

    public String getProID() {
        return proID;
    }
}
