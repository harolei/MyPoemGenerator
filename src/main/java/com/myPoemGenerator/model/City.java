package com.myPoemGenerator.model;

public class City {
    private String cityName;
    private String cityID;

    public City(String cityName, String cityID) {
        this.cityName = cityName;
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCityID() {
        return cityID;
    }

   public String toJSON() {
       String JsonStr = "";
       JsonStr = "{\"cityID\":\"" + cityID +"\",\"cityName\":\"" + cityName + "\"}";
       return JsonStr;
   }
}
