package com.myApp.core;

import com.google.api.client.http.HttpStatusCodes;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class RestHelper {
    Response response = null;

    public Response sendRequest(String httpRequest, Object payload, String uri, Long thresholdTime, int statusCode, HashMap<String, String> headers, HashMap<String, String> queryParam, HashMap<String, String> pathParam,File schemaFile) {

        switch (httpRequest) {
            case "GET":
                response = RestAssured.given().headers(headers)
                        .baseUri(uri)
                        .pathParams(pathParam)
                        .queryParams(queryParam)
                        .log().all()
                        .when()
                        .get()
                        .then()
                        .body(JsonSchemaValidator.matchesJsonSchema(schemaFile))
                        .time(Matchers.lessThan(thresholdTime))
                        .log()
                        .all()
                        .assertThat()
                        .statusCode(statusCode)
                        .extract()
                        .response();
                return response;

            case "POST":
                response = RestAssured.given()
                        .headers(headers)
                        .baseUri(uri).log().all()
                        //.pathParams(pathParam)
                        //.queryParams(queryParam)
                        .body(payload)
                        .log().all()
                        .when()
                        .post()
                        .then()
                        //.body(JsonSchemaValidator.matchesJsonSchema(schemaFile))
                        .time(Matchers.lessThan(thresholdTime))
                        .log()
                        .all()
                        .assertThat()
                        .statusCode(statusCode)
                        .extract()
                        .response();
                return response;


            case "PUT":
                response = RestAssured.given()
                        .headers(headers)
                        .baseUri(uri)
                        .pathParams(pathParam)
                        .queryParams(queryParam)
                        .body(payload)
                        .log().all()
                        .when()
                        .put()
                        .then()
                        .body(JsonSchemaValidator.matchesJsonSchema(schemaFile))
                        .time(Matchers.lessThan(thresholdTime))
                        .log()
                        .all()
                        .assertThat()
                        .statusCode(HttpStatusCodes.STATUS_CODE_CREATED)
                        .extract()
                        .response();
                return response;


            case "PATCH":
                response = RestAssured.given()
                        .headers(headers)
                        .baseUri(uri)
                        .pathParams(pathParam)
                        .queryParams(queryParam)
                        .body(payload)
                        .log().all()
                        .when()
                        .patch()
                        .then()
                        .body(JsonSchemaValidator.matchesJsonSchema(schemaFile))
                        .time(Matchers.lessThan(thresholdTime))
                        .log()
                        .all()
                        .assertThat()
                        .statusCode(HttpStatusCodes.STATUS_CODE_CREATED)
                        .extract()
                        .response();
                return response;


            case "DELETE":
                response = RestAssured.given()
                        .headers(headers)
                        .baseUri(uri)
                        .pathParams(pathParam)
                        .queryParams(queryParam)
                        .body(payload)
                        .log().all()
                        .when()
                        .delete()
                        .then()
                        .body(JsonSchemaValidator.matchesJsonSchema(schemaFile))
                        .time(Matchers.lessThan(thresholdTime))
                        .log()
                        .all()
                        .assertThat()
                        .statusCode(HttpStatusCodes.STATUS_CODE_CREATED)
                        .extract()
                        .response();
                return response;

        }
        return response;
    }

    public Response sentPostRequestWithFormData(File payload, String uri, Long thresholdTime, File schema, HashMap<String, String> headers, HashMap<String, String> queryParam, HashMap<String, String> pathParam) {
        return RestAssured.given()
                .headers(headers)
                .baseUri(uri).multiPart("", "")
                .multiPart("", new File(""))
                .pathParams(queryParam)
                .queryParams(queryParam)
                .body(payload)
                .log().all()
                .when()
                .post()
                .then()
                .body(JsonSchemaValidator.matchesJsonSchema(schema))
                .time(Matchers.lessThan(thresholdTime))
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatusCodes.STATUS_CODE_OK)
                .extract()
                .response();
    }


    public HashMap<String, String> addHeaders(HashMap<String, String> map) {
        if (map.size() == 0 || map.equals(null)) return null;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }

    public HashMap<String, String> addQueryParam(HashMap<String, String> map) {
        if (map.size() == 0 || map.equals(null)) return null;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }

    public HashMap<String, String> addPathParam(HashMap<String, String> map) {
        if (map.size() == 0 || map.equals(null)) return null;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }


    public Response sentPostSchema(Object payload, String uri, Long thresholdTime, File schemaFile,HashMap<String, String> headers) throws IOException {
            response = RestAssured.given()
                    .headers(headers)
                    .baseUri(uri)
                    .body(payload)
                    .log().all()
                    .when()
                    .post()
                    .then()
                    .body(JsonSchemaValidator.matchesJsonSchema(schemaFile))
                    .time(Matchers.lessThan(thresholdTime))
                    .log()
                    .all()
                    .assertThat()
                    .statusCode(HttpStatusCodes.STATUS_CODE_CREATED)
                    .extract()
                    .response();
        return response;
    }


    public Response sentPost(Object payload, String uri, Long thresholdTime, File schema, int statusCode, HashMap<String, String> headers) throws IOException {
        response = RestAssured.given()
                .headers(headers)
                .baseUri(uri)
                .body(payload)
                .log().all()
                .when()
                .post()
                .then()
                .time(Matchers.lessThan(thresholdTime))
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatusCodes.STATUS_CODE_CREATED)
                .extract()
                .response();
        return response;
    }

    public Response sendGetRequest(String httpRequest, Object payload, String uri, Long thresholdTime, int statusCode, HashMap<String, String> headers, HashMap<String, String> queryParam, HashMap<String, String> pathParam) {
                response = RestAssured.given().headers(headers)
                        .baseUri(uri)
                        .pathParams(pathParam)
                        .queryParams(queryParam)
                        .log().all()
                        .when()
                        .get()
                        .then()
                        .time(Matchers.lessThan(thresholdTime))
                        .log()
                        .all()
                        .extract()
                        .response();
                return response;
        }


}