package com.tatasky.api_automation.OTT_FRONTEND_API;

import static com.jayway.restassured.RestAssured.given;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import com.relevantcodes.extentreports.LogStatus;

import models.ott_frontend.response.LoginManagement.LoginWithPassword.LoginWithPasswordMainResponseModel;
import utils.BaseClass;
import utils.Utility;

//Created By Tushar Singhal
public class TestFilterAPI extends BaseClass {

    Gson gson = new Gson();
    boolean testResultStatus = false;
    public HashMap<String, HashMap<String, String>> data;
    public HashMap<String, String> params;

    @BeforeClass
    public void beforeClass() {
        data = testData.get(this.getClass().getSimpleName());
        params = new HashMap<String, String>();
    }

    //Date: 22th May 2018
    //Created By Tushar Singhal
    //API Name: All_Channel_Filter API
    //API Type: Get
    //Verify Point: "languageFilters", "genreFilters"
    @Test
    public void allChannelsFilter(Method method) {
        params = null;

        testReport.log(LogStatus.INFO, "Initiate API - All Channels Filter");

        if (testData
                .get(this.getClass().getSimpleName()).get(method.getName())
                .get("RUN_STATUS").toString().toLowerCase()
                .equalsIgnoreCase("no")) {
            System.out.println("Insde skip condition and skipping test case "
                    + method.getName().toString());
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());
        }

        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());


        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));

        testReport.log(LogStatus.INFO, "API Path and Parameters - " + params);

        Response res = given()
                .header("Content-Type", "application/json")
                .when()
                .get(params.get("ENDPOINT"));


        System.out.println("Params Data" + data.get(method.getName()).get("API_KEYS"));

        String body = res.getBody().asString();
        System.out.println("Response body for House Request : " + body);

        testReport.log(LogStatus.INFO, "Expected Keys - " + data.get(method.getName()).get("API_KEYS"));

        testResultStatus = Utility.checkApiKeys(
                body,
                data.get(method.getName()).get("API_KEYS"));


        Assert.assertEquals(testResultStatus, true);
        testReport.log(LogStatus.INFO, "API Response - " + body);
    }

    //Date: 22th May 2018
    //Created By Tushar Singhal
    //API Name: All_Channel API
    //API Type: Get
	/*Verify Point: "total","offset","limit","list","id","title","boxCoverImage",
	"posterImage","thumbnailImage","contentType","subTitles","contractName",
	"entitlements","genres","channelNumber"*/
    @Test
    public void allChannel(Method method) {


        params = null;

        testReport.log(LogStatus.INFO, "Initiate API - All Channels");

        if (testData
                .get(this.getClass().getSimpleName()).get(method.getName())
                .get("RUN_STATUS").toString().toLowerCase()
                .equalsIgnoreCase("no")) {
            System.out.println("Insde skip condition and skipping test case "
                    + method.getName().toString());
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());
        }

        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());


        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));

        testReport.log(LogStatus.INFO, "API Path and Parameters - " + params);

        Response res = given()
                .header("Content-Type", "application/json")
                .queryParam("limit", params.get("limit"))
                .queryParam("languageFilters", params.get("languageFilters"))
                .queryParam("ott", params.get("ott"))
                .when()
                .get(params.get("ENDPOINT"));


        String body = res.getBody().asString();
        System.out.println("Response body for House Request : " + body);

        testReport.log(LogStatus.INFO, "Expected Keys - " + data.get(method.getName()).get("API_KEYS"));

        testResultStatus = Utility.checkApiKeys(
                body,
                data.get(method.getName()).get("API_KEYS"));

        Assert.assertEquals(testResultStatus, true);
        testReport.log(LogStatus.INFO, "API Response - " + body);
    }


    //Date: 22th May 2018
    //Created By Tushar Singhal
    //API Name: SeeAllRailFilter API
    //API Type: Get
    /*Verify Point: "code","message","data","languageFilters","genreFilters"*/
    @Test
    public void seeAllRailFilter(Method method) {
        params = null;

        testReport.log(LogStatus.INFO, "Initiate API - See All Rail Filter");

        if (testData
                .get(this.getClass().getSimpleName()).get(method.getName())
                .get("RUN_STATUS").toString().toLowerCase()
                .equalsIgnoreCase("no")) {
            System.out.println("Insde skip condition and skipping test case "
                    + method.getName().toString());
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());
        }

        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());


        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));

        testReport.log(LogStatus.INFO, "API Path and Parameters - " + params);

        Response res = given()
                .header("Content-Type", "application/json")
                .when()
                .get(params.get("ENDPOINT"));


        String body = res.getBody().asString();
        System.out.println("Response body for House Request : " + body);

        testResultStatus = Utility.checkApiKeys(
                body,
                data.get(method.getName()).get("API_KEYS"));

        Assert.assertEquals(testResultStatus, true);
        testReport.log(LogStatus.INFO, "API Response - " + body);
    }

    //Date: 22th May 2018
    //Created By Tushar Singhal
    //API Name: SeeAll API
    //API Type: Get
    /*Verify Point: "code","message","data","image","contentType","subTitles","position","contractName","entitlements"*/
    @Test
    public void seeAll(Method method) {
        params = null;

        testReport.log(LogStatus.INFO, "Initiate API - See ALL");

        if (testData
                .get(this.getClass().getSimpleName()).get(method.getName())
                .get("RUN_STATUS").toString().toLowerCase()
                .equalsIgnoreCase("no")) {
            System.out.println("Insde skip condition and skipping test case "
                    + method.getName().toString());
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());
        }

        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());


        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        testReport.log(LogStatus.INFO, "API Path and Parameters - " + params);
        System.out.println(params);

        Response res = given().log().all()
                .header("Content-Type", "application/json")
                .queryParam("id", params.get("id"))
                .queryParam("genreFilters", params.get("genreFilters"))
                .when()
                .get(params.get("ENDPOINT"));


        String body = res.getBody().asString();
        System.out.println("Response body for House Request : " + body);

        testResultStatus = Utility.checkApiKeys(
                body,
                data.get(method.getName()).get("API_KEYS"));

        Assert.assertEquals(testResultStatus, true);
        testReport.log(LogStatus.INFO, "API Response - " + body);
    }


    //Date: 22th May 2018
    //Created By Tushar Singhal
    //API Name: MyBox API
    //API Type: Get
  	/*Verify Point: "data","total","offset","limit","date","channelList","id","title","boxCoverImage","posterImage",
  	 "thumbnailImage","contentType","subTitles","contractName","entitlements","genres","channelNumber","epg","ott"*/
    @Test
    public void myBox(Method method) {
        params = null;
        testReport.log(LogStatus.INFO, "Initiate API - My Box");
        if (testData
                .get(this.getClass().getSimpleName()).get(method.getName())
                .get("RUN_STATUS").toString().toLowerCase()
                .equalsIgnoreCase("no")) {
            System.out.println("Insde skip condition and skipping test case "
                    + method.getName().toString());
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());
        }

        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());


        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        testReport.log(LogStatus.INFO, "API Path and Parameters - " + params);
        System.out.println(params);

        Response res = given()
                .header("Content-Type", "application/json")
                //.queryParam("date", params.get("date"))
                .queryParam("genreFilters", params.get("genreFilters"))
                .queryParam("limit", params.get("limit"))
                .when()
                .get(params.get("ENDPOINT"));

        String body = res.getBody().asString();

        System.out.println("Response body for House Request : " + body);

        testResultStatus = Utility.checkApiKeys(
                body,
                data.get(method.getName()).get("API_KEYS"));

        Assert.assertEquals(testResultStatus, true);
        testReport.log(LogStatus.INFO, "API Response - " + body);

    }


    //Date: 24th May 2018
    //Created By Tushar Singhal
    //API Name: MyBox_Detail API
    //API Type: Get
  	/*Verify Point: "data","total","offset","limit","date","channelList","id","title","boxCoverImage","posterImage",
  	 "thumbnailImage","contentType","subTitles","contractName","entitlements","genres","channelNumber","epg","ott"*/
    @Test
    public void myBox_Detail(Method method) {
        params = null;

        testReport.log(LogStatus.INFO, "Initiate API - My Box Detail");

        if (testData
                .get(this.getClass().getSimpleName()).get(method.getName())
                .get("RUN_STATUS").toString().toLowerCase()
                .equalsIgnoreCase("no")) {
            System.out.println("Insde skip condition and skipping test case "
                    + method.getName().toString());
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());
        }

        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        //Extract MTV ID Value from my_box API

        /*ValidatableResponse response_myBox = given()
                .header("Content-Type", "application/json").log().all()
                .queryParam("genreFilters", "Music & Audio")
                .queryParam("limit", "200")
                .when()
                .get("/portal-search/pub/api/v1/channels/schedule/").then();

        int my_boxId = response_myBox.extract().response().path("data.channelList.id[0]");

        //Extract Channel SubscriberList ID using myBox Id
        ValidatableResponse response_channelList = given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .get("/content-detail/pub/api/v1/channels/" + my_boxId + "/schedule").then();

        int channel_id = response_channelList.extract().response().path("data.epg.id[0]");*/

        //Main Method Implementation
        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        testReport.log(LogStatus.INFO, "API Path and Parameters - " + params);

        Response res = given()
                .header("Content-Type", "application/json")
                .when()
                .get(params.get("ENDPOINT") + params.get("epgId"));

        String body = res.getBody().asString();

        System.out.println("Response body for House Request : " + body);

        testResultStatus = Utility.checkApiKeys(
                body,
                data.get(method.getName()).get("API_KEYS"));

        Assert.assertEquals(testResultStatus, true);
        testReport.log(LogStatus.INFO, "API Response - " + body);

    }

}
