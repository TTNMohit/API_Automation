package com.tatasky.api_automation.OTT_FRONTEND_API;

import static com.jayway.restassured.RestAssured.given;
import static utils.Utility.deleteAllProfiles;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.jayway.restassured.RestAssured;
import com.relevantcodes.extentreports.LogStatus;
import models.ott_frontend.request.continueWatching.*;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.BaseClass;
import utils.DataSetter;
import utils.Utility;

import com.jayway.restassured.response.Response;

public class TestContinueWatching extends BaseClass {

    public HashMap<String, HashMap<String, String>> data;
    boolean testResultStatus = false;
    static String accessToken = "";
    HashMap<String, String> params = null;
    String apiResponse = null;

    /**
     * @author - Abhishek Sharma
     * @purpose - Sets the test data and access token for using in test methods
     */
    @BeforeClass
    public void dataSetup() {
        data = testData.get(this.getClass().getSimpleName());
        params = Utility.getRequestParams(data.get("dataSetup").get("PARAMS"));
        accessToken = Utility.getLoginAccessToken(
                params.get("SID"),
                params.get("PASSWORD"),
                RestAssured.baseURI.toString());

    }

    /**
     * @param method
     * @author - Abhishek Sharma
     * @purpose - Tests the viewing history api
     */

    @Test(alwaysRun = true)
    public void testViewingHistory(Method method) {

        //initalizing data for test method
        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        int profileCount = -1;

        // checking the run status
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        testReport.log(LogStatus.INFO, "API Endpoint: " + "\t" + params.get("ENDPOINT"));
        testReport.log(LogStatus.INFO, "Expected API Keys: " + "\n"
                + data.get(method.getName()).get("API_KEYS"));


        profileCount = Utility.getProfileCount(
                accessToken,
                params.get("SID"), RestAssured.baseURI.toString());

        if (profileCount > 1) {
            deleteAllProfiles(
                    Utility.getListOfProfileIds(accessToken,
                            params.get("SID"), RestAssured.baseURI.toString()),
                    params.get("SID"), accessToken, RestAssured.baseURI.toString());
        }

        // add profile, get that profileid
        // viewing history ************
        // profile id, sid, conettn-type, platform, authtoken

        ContinueWatchingRequestModel oContinueWatchingRequestModel = new ContinueWatchingRequestModel();
        oContinueWatchingRequestModel.setProfileId(Utility.getListOfProfileIds(
                accessToken,
                params.get("SID"), RestAssured.baseURI.toString()).get(0));
        oContinueWatchingRequestModel.setSubscriberId(params.get("SID"));
        Response resViewingHistory = given()
                .log()
                .all()
                .header("Authorization", "bearer " + accessToken)
                .header("platform",
                        params.get("PLATFORM"))
                .header("Content-Type", "application/json")
                .body(oContinueWatchingRequestModel)
                .when()
                .post(params.get("ENDPOINT"));

        apiResponse = resViewingHistory.getBody().asString();
        System.out
                .println("Response body for viewing history api is : " + apiResponse);
        testResultStatus = Utility.checkApiKeys(
                apiResponse,
                data.get(method.getName()).get("API_KEYS"));
        Assert.assertTrue(testResultStatus);

    }

    /**
     * @param method
     * @author - Abhishek Sharma
     * @purpose - Tests the is favourite check api
     */
    @Test(alwaysRun = true)
    public void testIsFavoriteCheckApi(Method method) {

        String profileId = null;
        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));

        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());


        testReport.log(LogStatus.INFO, "API Endpoint: " + "\t" + params.get("ENDPOINT"));
        testReport.log(LogStatus.INFO, "Expected API Keys: " + "\n"
                + data.get(method.getName()).get("API_KEYS"));

        profileId = Utility.getListOfProfileIds(
                accessToken,
                params.get("SID"), RestAssured.baseURI.toString()).get(0);

        IsFavoriteCheckRequestModel oIsFavoriteCheckRequestModel = new IsFavoriteCheckRequestModel();
        oIsFavoriteCheckRequestModel.setContentId(params.get("CONTENT_ID"));
        oIsFavoriteCheckRequestModel.setContentType(params.get("CONTENT_TYPE"));
        Response resIsFavCheck = given()
                .header("Authorization", "bearer " + accessToken)
                .header("profileId", profileId)
                .header("Content-Type", "application/json")
                .body(oIsFavoriteCheckRequestModel)
                .when()
                .post(params.get("ENDPOINT"));

        apiResponse = resIsFavCheck.getBody().asString();
        testResultStatus = Utility.checkApiKeys(
                apiResponse,
                data.get(method.getName()).get("API_KEYS"));
        Assert.assertTrue(testResultStatus);


    }

    /**
     * @param method
     * @author - Abhishek Sharma
     * @purpose - Tests the Watch History API
     */
    @Test(alwaysRun = true)
    public void testWatchHistoryApi(Method method) {

        String profileId = "";
        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));

        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());


        testReport.log(LogStatus.INFO, "API Endpoint: " + "\t" + params.get("ENDPOINT"));
        testReport.log(LogStatus.INFO, "Expected API Keys: " + "\n"
                + data.get(method.getName()).get("API_KEYS"));

        profileId = Utility.getListOfProfileIds(
                accessToken,
                params.get("SID"), RestAssured.baseURI.toString()).get(0);

        // first set values in the Event class
        // Then make a list of events object and set value of WatchHistoryRequestModalClass
        // then send object of "WatchHistoryRequestModalClass" to request body

        List<Event> listEvent = new LinkedList<Event>();

        // creating a object to add to list of objects
        Event oEvent = new Event();

        oEvent.setSubscriberId(params.get("subscriberId"));
        oEvent.setContentType(params.get("contentType"));
        oEvent.setId(Integer.parseInt(params.get("id")));
        oEvent.setProfileId(profileId);
        oEvent.setTotalDuration(Integer.parseInt(params.get("totalDuration")));
        oEvent.setVodId(Integer.parseInt(params.get("vodId")));
        oEvent.setWatchDuration(Integer.parseInt(params.get("watchDuration")));

        listEvent.add(oEvent);

        // create object of WatchHistoryRequestModalClass  and set event
        WatchHistoryRequestModalClass oWatchHistoryRequestModalClass = new WatchHistoryRequestModalClass();
        oWatchHistoryRequestModalClass.setEvents(listEvent);

        // create a request and and send WatchHistoryRequestModalClass  object as body
        Response responseWatchHistory = given()
                .header("Authorization", "bearer " + accessToken)
                .header("Content-Type", "application/json")
                .body(oWatchHistoryRequestModalClass)
                .when()
                .post(params.get("ENDPOINT"));

        apiResponse = responseWatchHistory.getBody().asString();

        testResultStatus = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));

        Assert.assertTrue(testResultStatus);
    }

    /**
     * @param method
     * @author - Abhishek Sharma
     * @purpose - Tests the Delete Viewing History API
     */
    @Test(alwaysRun = true)
    public void testDeleteViewingHistory(Method method) {
        // header - auth token, content_type

        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        // body - make pojo class and set profile id from code
        // and set sid, content type, content id  from excel
        //String authToken = "";
        String profileId = "";

        // check skip condition
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());


        testReport.log(LogStatus.INFO, "API Endpoint: " + "\t" + params.get("ENDPOINT"));
        testReport.log(LogStatus.INFO, "Expected API Keys: " + "\n"
                + data.get(method.getName()).get("API_KEYS"));

        profileId = Utility.getListOfProfileIds(accessToken,
                params.get("SID"), RestAssured.baseURI).get(0);

        // setting the data on request modal classes

        ContentList oContentList = new ContentList();
        oContentList.setContentId(Integer.parseInt(params.get("contentId")));
        oContentList.setContentType(params.get("contentType"));

        List<ContentList> listOfContentObjects = new LinkedList<ContentList>();
        listOfContentObjects.add(oContentList);

        DeleteViewingHistoryRequestModal oDeleteViewingHistoryRequestModal
                = new DeleteViewingHistoryRequestModal();

        oDeleteViewingHistoryRequestModal.setContentList(listOfContentObjects);
        oDeleteViewingHistoryRequestModal.setProfileId(profileId);
        oDeleteViewingHistoryRequestModal.setSubscriberId(params.get("SID"));

        Response responseDeleteViewingHistoryApi = given()
                .header("authorization", "bearer " + accessToken)
                .header("Content-Type", "application/json")
                .body(oDeleteViewingHistoryRequestModal)
                .post(params.get("ENDPOINT"));

        apiResponse = responseDeleteViewingHistoryApi.getBody().asString();

        testResultStatus = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));

        Assert.assertTrue(testResultStatus);

    }

    /**
     * @author - Abhishek Sharma
     * @purpose - Tears down the test data after every test method.
     */
    @AfterMethod(alwaysRun = true)
    public void tearDownTest() {
        testResultStatus = false;
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


