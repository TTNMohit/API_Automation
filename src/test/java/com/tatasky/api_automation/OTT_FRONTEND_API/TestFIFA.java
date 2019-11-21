package com.tatasky.api_automation.OTT_FRONTEND_API;

import com.google.gson.Gson;
import com.jayway.restassured.response.Response;
import com.relevantcodes.extentreports.LogStatus;
import models.ott_frontend.response.Fifa_Pojo.FIFA_Config_pojo.FifaMainResponseModel;
import models.ott_frontend.response.Fifa_Pojo.FIFA_Homescreen_pojo.FifaHomescreenResponseModel;
import models.ott_frontend.response.Fifa_Pojo.FIFA_Schedule_pojo.FifaScheduleResponseModel;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.DataSetter;
import utils.Utility;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;

import static com.jayway.restassured.RestAssured.given;

public class TestFIFA extends BaseClass {

    public HashMap<String, HashMap<String, String>> data;
    boolean testResultStatus = false;
    static String accessToken = "";
    HashMap<String, String> params = null;
    boolean testResult = false;
    String apiResponse = null;

    /**
     * @author - Abhishek Sharma
     * @purpose - Sets the test data and access token for using in test methods
     */
    @BeforeClass
    public void dataSetup() {
        data = testData.get(this.getClass().getSimpleName());
    }

    @Test
    public void testConfigApi(Method method) {
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));

        testReport.log(LogStatus.INFO, "API Endpoint: " + "\t" + params.get("ENDPOINT"));
        testReport.log(LogStatus.INFO, "Expected API Keys: " + "\n"
                + data.get(method.getName()).get("API_KEYS"));

        Response responseConfigApi = given().log().all()
                .get(params.get("ENDPOINT"));

        apiResponse = responseConfigApi.getBody().asString();

        Gson gson = new Gson();
        FifaMainResponseModel ofifaMainResponseModel =
                gson.fromJson(apiResponse, FifaMainResponseModel.class);
        testReport.log(LogStatus.INFO, "The fifa start date is : "
                + Utility.dateFormatter(ofifaMainResponseModel.getData().getConfig().getFifa().getFifaStartDate()));
        testReport.log(LogStatus.INFO, "The fifa end date is : "
                + Utility.dateFormatter(ofifaMainResponseModel.getData().getConfig().getFifa().getFifaEndDate()));
        testReport.log(LogStatus.INFO, "The enabled feature is : "
                + ofifaMainResponseModel.getData().getConfig().getEnabledFeatures().toString());

        testResult = Utility.checkApiKeys(apiResponse,
                data.get(method.getName()).get("API_KEYS").toString());

        Assert.assertTrue(testResult);
    }

    @Test
    public void testHomeScreenApi(Method method) {
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));

        testReport.log(LogStatus.INFO, "API Endpoint: " + "\t" + params.get("ENDPOINT"));
        testReport.log(LogStatus.INFO, "Expected API Keys: " + "\n"
                + data.get(method.getName()).get("API_KEYS"));

        Response responseConfigApi = given()
                .log()
                .all()
                .queryParam("enabledFeatures", params.get("enabledFeatures"))
                .get(params.get("ENDPOINT"));

        apiResponse = responseConfigApi.getBody().asString();

        testResult = Utility.checkApiKeys(apiResponse,
                data.get(method.getName()).get("API_KEYS").toString());
        Gson gson = new Gson();
        FifaHomescreenResponseModel oFifaHomescreenResponseModel =
                gson.fromJson(apiResponse, FifaHomescreenResponseModel.class);

        testReport.log(LogStatus.INFO, "The content tye is : " + oFifaHomescreenResponseModel.getData()
                .getItems().get(0).getContentList().get(0).getContentType());

        Assert.assertTrue(testResult);
    }

    @Test
    public void testFifaSchedule(Method method) {
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        Response responseConfigApi = given().log().all()
                .queryParam("date",Utility.getNewDate(new Date()) )
                .get(params.get("ENDPOINT"));

        apiResponse = responseConfigApi.getBody().asString();

        testResult = Utility.checkApiKeys(apiResponse,
                data.get(method.getName()).get("API_KEYS").toString());

        Gson gson = new Gson();
        FifaScheduleResponseModel oFifaScheduleResponseModel =
                gson.fromJson(apiResponse, FifaScheduleResponseModel.class);
        testReport.log(LogStatus.INFO, "The match id is: " +
                oFifaScheduleResponseModel.getData().getSchedule().get(0).getMatchId());
        testReport.log(LogStatus.INFO, "Team 1 is: " +
                oFifaScheduleResponseModel.getData().getSchedule().get(0).getFifa().getTeam1Name());
        testReport.log(LogStatus.INFO, "Team 2 is : "
                + oFifaScheduleResponseModel.getData().getSchedule().get(0).getFifa().getTeam2Name());

        Assert.assertTrue(testResult);
    }

    @AfterMethod
    public void tearDown() {

        testResult = false;
        params.clear();
        testReport.log(LogStatus.INFO, " KEY(S) PRESENT:  "
                + DataSetter.getPresentApiKeys());
        testReport.log(LogStatus.INFO, "KEY(S) NOT PRESENT:  " + "\n" +
                DataSetter.getNotPresentApiKeys().toString());
        DataSetter.clearNotPresentApiKeys();
        DataSetter.clearPresentApiKeys();
        testReport.log(LogStatus.INFO, "API Response : " + "\n" + apiResponse);
        apiResponse = null;
        System.out.println("Testing..... " + DataSetter.getPresentApiKeys()
                + DataSetter.getNotPresentApiKeys());
    }


}
