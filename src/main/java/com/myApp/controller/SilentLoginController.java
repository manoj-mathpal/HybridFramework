package com.myApp.controller;

import com.google.api.client.http.HttpStatusCodes;
import com.google.gson.Gson;
import com.myApp.core.RestHelper;
import io.restassured.response.Response;

import java.io.File;
import java.util.HashMap;

public class SilentLoginController {

    private RestHelper helper;
    private HashMap<String, String> headers;
    private HashMap<String, String> queryParams;
    private HashMap<String, String> pathParams;
    private Gson gson;

    public SilentLoginController(){helper = new RestHelper();headers = new HashMap<>();gson=new Gson();queryParams=new HashMap<>();}

        public Response validatePositiveFlowForSilentLogin(String httpRequest, Object payload, String uri, Long thresholdTime, String schemaFilePath) {
            headers.put("contentType","application/json");
            headers.put("SecretKey","0d27047477046a86f2830c0a535b0977");
            headers.put("ClientId","acko");
            File schemaFile =new File(schemaFilePath);
            return helper.sendRequest(httpRequest,payload,uri,thresholdTime, HttpStatusCodes.STATUS_CODE_OK,headers,queryParams,pathParams,schemaFile);
        }

    public Response validatePositiveFlowForVerifyToken(String httpRequest, Object payload, String uri, Long thresholdTime,String schemaFilePath,String tokenValue) {
        headers.put("contentType","application/json");
        File schemaFile =new File(schemaFilePath);
        payload= gson.toJson(payload).replace("value",tokenValue.toString());
        return helper.sendRequest(httpRequest,payload,uri,thresholdTime, HttpStatusCodes.STATUS_CODE_OK,headers,queryParams,pathParams,schemaFile);
    }
}
