package com.tatasky.api_automation.OTT_FRONTEND_API;

import com.google.gson.Gson;
import com.jayway.restassured.response.Response;
import com.relevantcodes.extentreports.LogStatus;
import models.ott_frontend.request.NewFavorite.AddSubscriber.AddSubscriberRequestModel;
import models.ott_frontend.request.NewFavorite.IsFavorite.IsFavoriteRequestModel;
import models.ott_frontend.request.NewFavorites.ContentList;
import models.ott_frontend.request.NewFavorites.DeleteSubscriberRequestModel;
import models.ott_frontend.response.Homescreen_pojo.Homescreen.HomeScreenApiResponseData;
import models.ott_frontend.response.NewFavorite.Get_Subscriber.GetSubscriberResponseModel;
import models.ott_frontend.response.NewFavorite.IsFavorite.IsFavoriteResponseModel;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.DataSetter;
import utils.Utility;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;

public class TestNewFavorite extends BaseClass {

    public HashMap<String, HashMap<String, String>> data;
    HashMap<String, String> params = new HashMap<String, String>();
    String accessToken = "";
    String profileId = "";
    boolean testResult = false;
    Integer contentId;
    String id = "";
    String contentType = "";
    String apiResponse = null;

    @BeforeClass
    public void dataSetup() {
        data = testData.get(this.getClass().getSimpleName());
        params = Utility.getRequestParams(data.get("dataSetup").get("PARAMS"));

        Response homeScreenResponse = given().log().all()
                .get(params.get("ENDPOINT"));
        String apiResponse = homeScreenResponse.getBody().asString();
        Gson gson = new Gson();
        HomeScreenApiResponseData oHomeScreenApiResponseData =
                gson.fromJson(apiResponse, HomeScreenApiResponseData.class);
        int count = 0;
        for (int i = 0; i < oHomeScreenApiResponseData.getData().getItems().length; i++) {
            if (oHomeScreenApiResponseData.getData().getItems()[i]
                    .getSectionType().equalsIgnoreCase("ALL_CHANNELS")) {
                id = oHomeScreenApiResponseData.getData().getItems()[i].getContentList()[0].getId();
                contentType = oHomeScreenApiResponseData.getData().getItems()[i].getContentList()[0].getContentType();
                break;
            }
        }

        accessToken = Utility.getLoginAccessToken(params.get("SID"), params.get("PASSWORD"));
        profileId = Utility.getListOfProfileIds(accessToken, params.get("SID")).get(0);
    }


    @Test(priority = 4, alwaysRun = true)
    public void testGetSubscriberFavourite(Method method) {
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));

        testReport.log(LogStatus.INFO, "API Endpoint: " + "\t" + params.get("ENDPOINT"));
        testReport.log(LogStatus.INFO, "Expected API Keys: " + "\n"
                + data.get(method.getName()).get("API_KEYS"));

        //accessToken = Utility.getLoginAccessToken(params.get("SID"), params.get("PASSWORD"));
        //profileId = Utility.getListOfProfileIds(accessToken, params.get("SID")).get(0);
        Response getSubscriberResponse = given().log().all()
                .header("authorization", "bearer " + accessToken)
                .header("profileId", profileId)
                .get(params.get("ENDPOINT"));

        apiResponse = getSubscriberResponse.getBody().asString();

        testResult = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));
        Assert.assertTrue(testResult);
    }

    @Test(priority = 3, alwaysRun = true)
    public void testDeleteFavorites(Method method) {
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));

        testReport.log(LogStatus.INFO, "API Endpoint: " + "\t" + params.get("ENDPOINT"));
        testReport.log(LogStatus.INFO, "Expected API Keys: " + "\n"
                + data.get(method.getName()).get("API_KEYS"));

        contentId = Integer.parseInt(id);

        DeleteSubscriberRequestModel oDeleteSubscriberRequestModel =
                new DeleteSubscriberRequestModel();

        ContentList oContentList = new ContentList();
        List<ContentList> list = new LinkedList<ContentList>();
        oContentList.setContentId(contentId);
        oContentList.setContentType(contentType);
        list.add(oContentList);
        oDeleteSubscriberRequestModel.setContentList(list);

        Response getSubscriberResponse = given().log().all()
                .header("authorization", "bearer " + accessToken)
                .header("profileId", profileId)
                .header("Content-Type", "application/json")
                .body(oDeleteSubscriberRequestModel.getContentList().get(0))
                .post(params.get("ENDPOINT"));

        apiResponse = getSubscriberResponse.getBody().asString();

        testResult = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));

        Assert.assertTrue(testResult);
    }

    @Test(priority = 1, alwaysRun = true)
    public void testAddSubscriberFavorite(Method method) {
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));

        testReport.log(LogStatus.INFO, "API Endpoint: " + "\t" + params.get("ENDPOINT"));
        testReport.log(LogStatus.INFO, "Expected API Keys: " + "\n"
                + data.get(method.getName()).get("API_KEYS"));

        AddSubscriberRequestModel oAddSubscriberRequestModel =
                new AddSubscriberRequestModel();
        oAddSubscriberRequestModel.setContentId(id);
        oAddSubscriberRequestModel.setContentType(contentType);

        Response addSubscriberResponse = given().log().all()
                .header("authorization", "bearer " + accessToken)
                .header("profileId", profileId)
                .header("Content-Type", "application/json")
                .body(oAddSubscriberRequestModel)
                .post(params.get("ENDPOINT"));

        apiResponse = addSubscriberResponse.getBody().asString();

        testResult = Utility.checkApiKeys(apiResponse,
                data.get(method.getName()).get("API_KEYS"));

        Assert.assertTrue(testResult);
    }

    @Test(priority = 2, alwaysRun = true)
    public void testIsFavorite(Method method) {
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));

        testReport.log(LogStatus.INFO, "API Endpoint: " + "\t" + params.get("ENDPOINT"));
        testReport.log(LogStatus.INFO, "Expected API Keys: " + "\n"
                + data.get(method.getName()).get("API_KEYS"));

        IsFavoriteRequestModel oIsFavoriteRequestModel =
                new IsFavoriteRequestModel();
        oIsFavoriteRequestModel.setContentId(id);
        oIsFavoriteRequestModel.setContentType(contentType);

        Response addSubscriberResponse = given().log().all()
                .header("authorization", "bearer " + accessToken)
                .header("profileId", profileId)
                .header("Content-Type", "application/json")
                .body(oIsFavoriteRequestModel)
                .post(params.get("ENDPOINT"));

        apiResponse = addSubscriberResponse.getBody().asString();

        testResult = Utility.checkApiKeys(apiResponse,
                data.get(method.getName()).get("API_KEYS"));

        Gson gson = new Gson();
        IsFavoriteResponseModel oIsFavoriteResponseModel =
                gson.fromJson(apiResponse, IsFavoriteResponseModel.class);
        //testResult = oIsFavoriteResponseModel.getData().getIsFavourite();
        if (testResult == false) {
            testReport.log(LogStatus.FAIL, "The Content with " +
                    "content_id = " + oIsFavoriteRequestModel.getContentId() + " and content_type = " + contentType +
                    " is not marked as favorite. Hence test case has Failed!!");
        }

        Assert.assertTrue(testResult);
    }

    @AfterMethod
    public void tearDown(ITestResult result, Method method) {
        testResult = false;
        params.clear();

        // reporting
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
