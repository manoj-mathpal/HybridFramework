package com.myApp.controller;

import com.google.api.client.http.HttpStatusCodes;
import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;
import com.myApp.core.RestHelper;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.json.JSONObject;
import com.myApp.testData.TestData;

import java.io.File;
import java.util.HashMap;

import static org.apache.commons.exec.CommandLine.parse;


public class ElectronicsInventoryController {
    private Response response;
    private HashMap<String, String> headers =  new HashMap<>();
    private HashMap<String, String> queryParams =  new HashMap<>();
    private HashMap<String, String> pathParams =  new HashMap<>();
    private RestHelper helper = new RestHelper();;
    private Gson gson= new Gson();

    public void validatePositiveFlowsForGetAllInventory(TestData testData) {
        headers.put("Content-Type","application/json");
        headers.put("User-Agent", "Mozilla/5.0");
        helper.addHeaders(headers);
        Response response = helper.sendGetRequest(Method.GET.toString(), testData.getPayload(), testData.getUrl(), testData.getThresholdTime(), HttpStatusCodes.STATUS_CODE_OK, headers, queryParams, pathParams);
        System.out.println("RESPONSE::: " + response.prettyPrint());
    }

    public void validatePositiveFlowsForAddInventory(TestData testData) {
        headers.put("Content-Type","application/json");
        headers.put("User-Agent", "Mozilla/5.0");
        helper.addHeaders(headers);
        //Object payload= gson.toJson(testData.getPayload()).replace("Apple MacBook Pro 16","MAKKKK");
        String json = JsonPath.parse(testData.getPayload()).set("name", "MyM")
                .set("data.year", "2025")
                .set("data.price", "999999.00").jsonString();
        Object payload = JSONObject.stringToValue(json);


        helper.sendRequest(Method.POST.toString(), payload, testData.getUrl(), testData.getThresholdTime(), HttpStatusCodes.STATUS_CODE_OK, headers, queryParams, pathParams, new File(testData.getSchemaFile()));
    }
}
