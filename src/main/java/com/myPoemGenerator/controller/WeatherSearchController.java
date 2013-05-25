package com.myPoemGenerator.controller;

import com.myPoemGenerator.controllerHelper.WeatherSearchControllerHelper;
import com.myPoemGenerator.model.City;
import com.myPoemGenerator.model.Province;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/weather")
public class WeatherSearchController {
    private WeatherSearchControllerHelper helper = new WeatherSearchControllerHelper();

    @RequestMapping(method = RequestMethod.GET)
    public String getWeatherPage(HttpServletResponse response, ModelMap model){
        List<Province> provs = helper.getSupportProvince();
        model.addAttribute("provs",provs);
        return "searchWeather";
    }

    @RequestMapping(params = "prov",method = RequestMethod.GET)
    public void getCity(HttpServletRequest request,HttpServletResponse response){
        String provName = request.getParameter("prov");
        ArrayList<City> list= (ArrayList<City>) helper.getSupportCity(provName);
        try{
            JSONArray members = new JSONArray();
            for(int i=0;i<list.size();i++){
                City dto=list.get(i);
                JSONObject member = new JSONObject()
                        .put("cityName", dto.getCityName())
                        .put("cityID",dto.getCityID());
                members.put(i, member);

            }
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(members.toString());

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(params = "city",method = RequestMethod.GET)
    public void getWeather(HttpServletRequest request,HttpServletResponse response){
        String cityName = request.getParameter("city");
        ArrayList<String> list= (ArrayList<String>) helper.getWeather(cityName);
        try{
            JSONArray members = new JSONArray();
            for(int i=0;i<list.size();i++){
                JSONObject member = new JSONObject()
                        .put("weather", list.get(i));
                members.put(i, member);

            }
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(members.toString());

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

