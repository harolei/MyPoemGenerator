package com.myPoemGenerator.controllerHelper;

import com.myPoemGenerator.model.City;
import com.myPoemGenerator.model.Province;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class WeatherSearchControllerHelper {
    private String provQueryURL;
    private String cityQueryURL;
    private String serviceHost;
    private String weatherQueryURL;



    public WeatherSearchControllerHelper() throws IOException {
        provQueryURL = getProperties().getProperty("PROVINCE_CODE_URL");
        cityQueryURL = getProperties().getProperty("CITY_CODE_URL");
        serviceHost = getProperties().getProperty("SERVICES_HOST");
        weatherQueryURL = getProperties().getProperty("WEATHER_QUERY_URL");

    }

    public List<Province> getSupportProvince() throws IOException {
        List<Province> provinces = new ArrayList<Province>();
        Document document;
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            InputStream inputStream = getSoapInputStream(provQueryURL);
            document = documentBuilder.parse(inputStream);
            NodeList nodeList = document.getElementsByTagName("string");
            int len = nodeList.getLength();
            for(int i=0; i<len;i++){
                Node n = nodeList.item(i);
                String result = n.getFirstChild().getNodeValue();
                String[] nodeValue = result.split(",");
                String provName = nodeValue[0];
                String provID = nodeValue[1];
                Province pro = new Province(provID,provName);
                provinces.add(pro);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return provinces;
    }

    public List<City> getSupportCity(String provinceCode) throws IOException {
        List<City> cities = new ArrayList<City>();
        Document doc;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        try{
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputStream is = getSoapInputStream(cityQueryURL + provinceCode);
            doc = db.parse(is);
            NodeList nl = doc.getElementsByTagName("string");
            int len = nl.getLength();
            for(int i = 0; i < len; i++){
                Node n = nl.item(i);
                String result = n.getFirstChild().getNodeValue();
                String[] address = result.split(",");
                String cName = address[0];
                String cID = address[1];
                City city = new City(cName,cID);
                cities.add(city);
            }
            is.close();
        }catch(DOMException e){
            e.printStackTrace();
        }catch(ParserConfigurationException e){
            e.printStackTrace();
        }catch (SAXException e){
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }
        return cities;
    }

    private InputStream getSoapInputStream(String url) throws IOException {
        InputStream inputStream = null;
        try{
            URL urlObj = new URL(url);
            URLConnection urlConn = urlObj.openConnection();
            urlConn.setRequestProperty("Host", serviceHost);
            urlConn.connect();
            inputStream = urlConn.getInputStream();
        }catch(MalformedURLException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return inputStream;
    }

    public List<String> getWeather(String cityCode) throws IOException {
        List<String> weatherList = new ArrayList<String>();
        Document document;
        DocumentBuilderFactory documentBF = DocumentBuilderFactory.newInstance();
        documentBF.setNamespaceAware(true);
        try{
            DocumentBuilder documentB = documentBF.newDocumentBuilder();
            InputStream inputStream = getSoapInputStream(weatherQueryURL + cityCode);
            document = documentB.parse(inputStream);
            NodeList nl = document.getElementsByTagName("string");
            int len = nl.getLength();
            for(int i = 0; i < len-2; i++){
                Node n = nl.item(i);
                String weather = n.getFirstChild().getNodeValue();
                if(i!=2 && i!=10 && i!=11 && i!=15 && i!=16 && i!=20 && i!=21 && i!=25 && i!=26)
                    weatherList.add(weather);
            }
            inputStream.close();
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }catch (DOMException e){
            e.printStackTrace();
        }catch (ParserConfigurationException e){
            e.printStackTrace();
        }catch(SAXException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return weatherList;
    }

    private Properties getProperties() throws IOException {
        Properties properties = new Properties();
        File f = new File("webServiceURL.properties");
        properties.load(new FileInputStream(f));
        return properties;
    }

}
