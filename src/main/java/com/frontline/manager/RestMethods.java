package com.frontline.manager;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.Map;
import net.minidev.json.JSONObject;

public class RestMethods {
    public static Response res = null;

    public static String requestURL = null;

    public static Response getCall(String URL2) {
        requestURL = URL2;
        res = RestAssured.get(URL2, new Object[0]);
        return res;
    }

    public static Response getWithPathParam(Map<String, String> params, String URL2, String contentType) {
        String pathparam = null;
        requestURL = URL2;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            pathparam = key + value;
        }
        res = (Response)RestAssured.given().contentType(contentType).pathParam("pageID", pathparam).get(URL2 + "{pageID}", new Object[0]);
        return res;
    }

    public static Response getWithHeaderParam(Map<String, String> headers, String URL2, String contentType) {
        requestURL = URL2;
        res = (Response)RestAssured.given().relaxedHTTPSValidation().headers(headers).contentType(getContentType(contentType)).request().when().get(URL2, new Object[0]);
        return res;
    }

    public static Response postWithFormParam(JSONObject jsonObject, String URL2, String contentType) {
        requestURL = URL2;
        res = (Response)RestAssured.given().relaxedHTTPSValidation().formParams((Map)jsonObject).contentType(getContentType(contentType)).request().when().post(URL2, new Object[0]);
        return res;
    }

    public static Response postWithHeaderAndFormParam(Map<String, String> headers, JSONObject jsonObject, String URL2, String contentType) {
        requestURL = URL2;
        res = (Response)RestAssured.given().relaxedHTTPSValidation().headers(headers).formParams((Map)jsonObject).contentType(getContentType(contentType)).request().when().post(URL2, new Object[0]);
        return res;
    }

    public static Response postWithJsonBodyParam(String jsonObject, String URL2, String contentType) {
        requestURL = URL2;
        res = (Response)RestAssured.given().relaxedHTTPSValidation().contentType(getContentType(contentType)).request().body(jsonObject).when().post(URL2, new Object[0]);
        return res;
    }

    public static Response postWithJsonBodyParam(JSONObject jsonObject, String URL2, String contentType) {
        requestURL = URL2;
        res = (Response)RestAssured.given().relaxedHTTPSValidation().contentType(getContentType(contentType)).request().body(jsonObject).when().post(URL2, new Object[0]);
        return res;
    }

    public static Response postWithHeaderAndJsonBodyParam(Map<String, String> headers, String jsonObject, String URL2, String contentType) {
        requestURL = URL2;
        res = (Response)RestAssured.given().relaxedHTTPSValidation().headers(headers).contentType(getContentType(contentType)).request().body(jsonObject).when().post(URL2, new Object[0]);
        return res;
    }

    public static Response postWithHeaderAndBodyParam(Map<String, String> headers, JSONObject jsonObject, String URL2, String contentType) {
        requestURL = URL2;
        res = (Response)RestAssured.given().relaxedHTTPSValidation().headers(headers).contentType(getContentType(contentType)).request().body(jsonObject).when().post(URL2, new Object[0]);
        return res;
    }

    public static Response postWithHeaderParam(Map<String, String> headers, String URL2, String contentType) {
        requestURL = URL2;
        res = (Response)RestAssured.given().relaxedHTTPSValidation().headers(headers).contentType(getContentType(contentType)).request().when().post(URL2, new Object[0]);
        return res;
    }

    public static Response deleteWithHeaderAndPathParam(Map<String, String> headers, JSONObject jsonObject, String URL2, String contentType) {
        requestURL = URL2;
        res = (Response)RestAssured.given().relaxedHTTPSValidation().headers(headers).contentType(getContentType(contentType)).request().body(jsonObject).when().delete(URL2, new Object[0]);
        return res;
    }

    public static Response deleteWithPathParam(String URL2, String contentType) {
        requestURL = URL2;
        res = (Response)RestAssured.given().relaxedHTTPSValidation().contentType(getContentType(contentType)).request().when().delete(URL2, new Object[0]);
        return res;
    }

    public static Response deleteWithHeaderAndPathParamWithoutRequestBody(Map<String, String> headers, String URL2, String contentType) throws Exception {
        requestURL = URL2;
        res = (Response)RestAssured.given().relaxedHTTPSValidation().headers(headers).contentType(getContentType(contentType)).request().when().delete(URL2, new Object[0]);
        return res;
    }

    public static Response putWithHeaderAndJsonParam(Map<String, String> headers, JSONObject jsonObject, String URL2, String contentType) {
        requestURL = URL2;
        res = (Response)RestAssured.given().relaxedHTTPSValidation().headers(headers).contentType(getContentType(contentType)).request().body(jsonObject).when().put(URL2, new Object[0]);
        return res;
    }

    public static Response putWithHeaderAndBodyParam(Map<String, String> headers, String jsonObject, String URL2, String contentType) {
        requestURL = URL2;
        res = (Response)RestAssured.given().relaxedHTTPSValidation().headers(headers).contentType(getContentType(contentType)).request().body(jsonObject).when().put(URL2, new Object[0]);
        return res;
    }

    public static Response putWithJsonBodyParam(JSONObject jsonObject, String URL2, String contentType) {
        requestURL = URL2;
        res = (Response)RestAssured.given().relaxedHTTPSValidation().contentType(getContentType(contentType)).request().body(jsonObject).when().put(URL2, new Object[0]);
        return res;
    }

    private static ContentType getContentType(String contentType) {
        if (contentType.equalsIgnoreCase("JSON"))
            return ContentType.JSON;
        if (contentType.equalsIgnoreCase("URLENC"))
            return ContentType.URLENC;
        if (contentType.equalsIgnoreCase("TEXT"))
            return ContentType.TEXT;
        if (contentType.equalsIgnoreCase("HTML"))
            return ContentType.HTML;
        if (contentType.equalsIgnoreCase("BINARY"))
            return ContentType.BINARY;
        if (contentType.equalsIgnoreCase("XML"))
            return ContentType.XML;
        if (contentType.equalsIgnoreCase(""))
            return ContentType.JSON;
        throw new RestException("Please set the valid Content Type");
    }
}

