package com.myApp.utility;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonParser {

    JSONParser parser = new JSONParser();

    public void extractJson(String filePath) throws IOException, ParseException {
        Object obj = parser.parse(new FileReader(filePath));


       if(obj instanceof JSONObject){

       }
        if(obj instanceof JSONArray){
            JSONObject person = (JSONObject) obj;
            String name = (String) person.get("name");
            System.out.println(name);
            JSONArray cars = (JSONArray) person.get("cars");
            for (Object c : cars) System.out.println(c+"");
        }
    }
}
