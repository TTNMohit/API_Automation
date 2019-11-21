package com.tatasky.api_automation.OTT_FRONTEND_API;

import com.gargoylesoftware.htmlunit.html.HtmlButtonInput;
import com.google.gson.Gson;
import com.jayway.restassured.response.Response;
import com.relevantcodes.extentreports.LogStatus;
import models.ott_frontend.response.Homescreen_pojo.AllChannelList.AllChannelListResponseModel;
import models.ott_frontend.response.Homescreen_pojo.ChannelSchedule.ChannelScheduleResponseModel;
import models.ott_frontend.response.Homescreen_pojo.Homescreen.HomeScreenApiResponseData;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

import com.jayway.restassured.RestAssured;
import utils.BaseClass;
import utils.DataSetter;
import utils.Utility;

import static com.jayway.restassured.RestAssured.given;

public class TestRecommendation extends BaseClass {


    // create all channel list pojos and get the channel id for zee tv hd
    // pojo for channel schedule api is already present,
    // get the id for show with epgstate = REVERSE and caathcup = true
    // hit the recommendation api with the info
    public HashMap<String, HashMap<String, String>> data;
    HashMap<String, String> params = new HashMap<String, String>();
    Gson gson = new Gson();
    boolean testResult = false;
    String apiResponse;

    @BeforeClass
    public void testSetup() {
        data = testData.get(this.getClass().getSimpleName());
    }

    @Test
    public void testCatchupRecommendations(Method method) {


        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());
        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));

        // getting the channel id from the ALlChannelList API
        Response allChannelListApi = given().log().all()
                .queryParam("offset", params.get("offset"))
                .queryParam("limit", params.get("limit"))
                .get(params.get("ENDPOINT_ALL_CHANNEL_API"));

        String allChannelString = allChannelListApi.getBody().asString();
        AllChannelListResponseModel oAllChannelListResponseModel =
                gson.fromJson(allChannelString, AllChannelListResponseModel.class);

        int count = 0;
        System.out.println("The size of list is : " + oAllChannelListResponseModel.getData().getList().size());
        while (!oAllChannelListResponseModel.getData().getList().get(count)
                .getTitle().equalsIgnoreCase(params.get("CHANNEL_NAME"))) {
            count++;
        }
        int channelId = -1;
        channelId = oAllChannelListResponseModel.getData().getList().get(count).getId();

        // Hitting the channel schedule API

        Response channelScheduleApi = given().log().all()
                .get(params.get("CHANNEL_SCHEDULE_ENDPOINT")
                        + channelId
                        + params.get("CHANNEL_SCHEDULE_ENDPOINT_1"));

        String channelScheduleStringResponse = channelScheduleApi.getBody().asString();
        long catchupId = -1;
        ChannelScheduleResponseModel oChannelScheduleResponseModel =
                new Gson().fromJson(channelScheduleStringResponse, ChannelScheduleResponseModel.class);
        for (int i = 0; i < oChannelScheduleResponseModel.getData().getEpg().size(); i++) {
            System.out.println("The count is :- " + i + " ,The epg state is : " + oChannelScheduleResponseModel.getData().getEpg()
                    .get(i).getEpgState() + " And the catchup state is :- " + oChannelScheduleResponseModel.getData().getEpg()
                    .get(i).getCatchup());
            if (oChannelScheduleResponseModel.getData().getEpg()
                    .get(i).getEpgState().equalsIgnoreCase("REVERSE")
                    && oChannelScheduleResponseModel.getData().getEpg()
                    .get(i).getCatchup() == true) {
                catchupId = oChannelScheduleResponseModel.getData().getEpg()
                        .get(i).getId();
                break;
            } else {
                testReport.log(LogStatus.FAIL, "Could not find any catch up, Test Failed!");
            }
        }

        // hitting the recommendation api for catch up with catch up id
        testReport.log(LogStatus.INFO, "API ENDPOINT is :- " + params.get("RECOMMENDATION_ENDPOINT")
                + catchupId + params.get("RECOMMENDATION_ENDPOINT_1"));
        Response recommendationResponse = given().log().all()
                .get(params.get("RECOMMENDATION_ENDPOINT")
                        + catchupId
                        + params.get("RECOMMENDATION_ENDPOINT_1"));

        apiResponse = recommendationResponse.getBody().asString();

        testResult = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));

        Assert.assertTrue(testResult);

    }

    @AfterMethod
    public void tearDown(ITestResult result, Method method) {
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
    }

}
