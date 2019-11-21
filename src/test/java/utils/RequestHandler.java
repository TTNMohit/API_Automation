package utils;

import com.jayway.restassured.response.Response;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import models.ATV.EPGDvbTripletRequestModel;

import java.util.*;

import static com.jayway.restassured.RestAssured.given;

public class RequestHandler extends BaseClass {

    public static String post(String endpoint,
                              HashMap<String, String> headers,
                              Object bodyObject,
                              ExtentTest testObject) {

        String apiResponse = null;
        Response response = given()
                .log()
                .all()
                .headers(headers)
                .body(bodyObject)
                .post(endpoint);
        apiResponse = response.getBody().asString();
        logApiParameters(endpoint, headers, null, testObject);
        return apiResponse;
    }

    public static String post(String endpoint,
                              HashMap<String, String> headers,
                              HashMap<String, String> params,
                              Object bodyObject,
                              ExtentTest testObject) {

        String apiResponse = null;
        Response response = given()
                .log()
                .all()
                .headers(headers)
                .queryParameters(params)
                .body(bodyObject)
                .post(endpoint);
        apiResponse = response.getBody().asString();
        logApiParameters(endpoint, headers, null, testObject);
        return apiResponse;
    }

    public static String post(String endpoint,
                              HashMap<String, String> headers,
                              ExtentTest testObject) {

        String apiResponse = null;
        Response response = given()
                .log()
                .all()
                .headers(headers)
                .post(endpoint);
        apiResponse = response.getBody().asString();
        logApiParameters(endpoint, headers, null, testObject);
        return apiResponse;
    }

    public static String get(String endpoint,
                             HashMap<String, String> headers,
                             HashMap<String, String> params,
                             ExtentTest testObject) {

        String apiResponse = null;
        Response response = given()
                .log()
                .all()
                .headers(headers)
                .params(params)
                .get(endpoint);
        apiResponse = response.getBody().asString();
        logApiParameters(endpoint, headers, params, testObject);
        return apiResponse;
    }

    public static void logApiParameters(String endpoint,
                                        HashMap<String, String> headers,
                                        HashMap<String, String> params,
                                        ExtentTest testObject) {

        StringBuilder header = new StringBuilder();
        StringBuilder param = new StringBuilder();

        testObject.log(LogStatus.INFO, "ENDPOINT : " + endpoint);
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                header.append(entry.getKey() + "--" + entry.getValue() + ",  ");
            }
        }

        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                param.append(entry.getKey() + "--" + entry.getValue() + ",  ");
            }
        }
        testObject.log(LogStatus.INFO, "Headers:- " + header);
        testObject.log(LogStatus.INFO, "Params:- " + param);
    }

    public static void setBody(Object object) {

    }
}
