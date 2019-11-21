package com.tatasky.api_automation.OTT_FRONTEND_API;

import com.google.gson.Gson;
import com.jayway.restassured.response.Response;
import com.relevantcodes.extentreports.LogStatus;
import models.ott_frontend.response.Homescreen_pojo.ChannelSchedule.ChannelScheduleResponseModel;
import models.ott_frontend.response.Homescreen_pojo.ChannelSchedule.Epg;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.DataSetter;
import utils.Utility;

import java.lang.reflect.Method;
import java.util.HashMap;

import static com.jayway.restassured.RestAssured.given;

public class TestHomeScreen extends BaseClass {

    //String failureMessage = "";
    public boolean testResult = false;
    private long epgId = -1;
    String channelScheduleResponse = "";
    String accessToken = "";
    public HashMap<String, HashMap<String, String>> data;
    HashMap<String, String> params = new HashMap<String, String>();
    String apiResponse = "";
    /**
     * @author - Abhishek Sharma
     * @purpose - Set up data for test methods
     */
    @BeforeClass
    public void testSetup() {
        data = testData.get(this.getClass().getSimpleName());
    }

    /**
     * @param screenName
     * @param method
     * @author - Abhishek Sharma
     * @purpose - Test the home screen API
     */
    @Test(dataProvider = "dataFeeder")
    public void testHomeScreen(String screenName, Method method)    {

        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());
        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));

        testReport.log(LogStatus.INFO, "API Endpoint: " + "\t" + params.get("ENDPOINT"));
        testReport.log(LogStatus.INFO, "Expected API Keys: " + "\n"
                + data.get(method.getName()).get("API_KEYS"));

        Response responseHomeScreenApi = given().log().all()
                .get(params.get("ENDPOINT") + screenName);

        apiResponse = responseHomeScreenApi.getBody().asString();

        testResult = Utility.checkApiKeys(apiResponse,
                data.get(method.getName()).get("API_KEYS").toString());
        if(testResult == false)
        {
            testReport.log(LogStatus.FAIL, "The Home screen API for " + screenName + " has failed!!");
        }
        else if ( testResult == true)
        {
            testReport.log(LogStatus.PASS, "The Home screen API for " + screenName + " has Passed!!");
        }

        Assert.assertTrue(testResult);

    }

    /**
     * @param method
     * @author - Abhishek Sharma
     * @purpose - Test all channel list API
     */
    @Test
    public void testAllChannelList(Method method) {
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));

        testReport.log(LogStatus.INFO, "API Endpoint: " + "\t" + params.get("ENDPOINT"));
        testReport.log(LogStatus.INFO, "Expected API Keys: " + "\n"
                + data.get(method.getName()).get("API_KEYS"));

        Response responseHomeScreenApi = given()
                .queryParam("offset", params.get("offset"))
                .queryParam("limit", params.get("limit")).log().all()
                .get(params.get("ENDPOINT"));

        apiResponse = responseHomeScreenApi.getBody().asString();

        testResult = Utility.checkApiKeys(apiResponse,
                data.get(method.getName()).get("API_KEYS").toString());

        Assert.assertEquals(testResult, true);
    }

    /**
     * @param method
     * @author - Abhishek Sharma
     * @purpose - test brand content details API
     */
    @Test
    public void testBrandContent(Method method) {
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());
        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));

        testReport.log(LogStatus.INFO, "API Endpoint: " + "\t" + params.get("ENDPOINT"));
        testReport.log(LogStatus.INFO, "Expected API Keys: " + "\n"
                + data.get(method.getName()).get("API_KEYS"));

        Response responseHomeScreenApi = given().log().all()
                .get(params.get("ENDPOINT") + params.get("brandId"));

        apiResponse = responseHomeScreenApi.getBody().asString();

        testResult = Utility.checkApiKeys(apiResponse,
                data.get(method.getName()).get("API_KEYS").toString());

        Assert.assertEquals(testResult, true);
    }

    /**
     * @param method
     * @author - Abhishek Sharma
     * @purpose - Test the series Vod listing API
     */
    @Test
    public void testSeriesVodListing(Method method) {
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));

        testReport.log(LogStatus.INFO, "API Endpoint: " + "\t" + params.get("ENDPOINT"));
        testReport.log(LogStatus.INFO, "Expected API Keys: " + "\n"
                + data.get(method.getName()).get("API_KEYS"));

        Response responseHomeScreenApi = given().log().all()
                .queryParam("offset", params.get("offset"))
                .queryParam("limit", params.get("limit"))
                .queryParam("language", params.get("language"))
                .get(params.get("ENDPOINT"));

        apiResponse = responseHomeScreenApi.getBody().asString();

        testResult = Utility.checkApiKeys(apiResponse,
                data.get(method.getName()).get("API_KEYS").toString());

        Assert.assertEquals(testResult, true);
    }

    /**
     * @param method
     * @author - Abhishek Sharma
     * @purpose - Tests the catchup epg detail API
     */
    @Test
    public void testCatchupEpgDetail(Method method) {
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        testReport.log(LogStatus.INFO, "API Endpoint: " + "\t" + params.get("ENDPOINT"));
        testReport.log(LogStatus.INFO, "Expected API Keys: " + "\n"
                + data.get(method.getName()).get("API_KEYS"));

        if (DataSetter.getEpgId() == -1) {
            Utility.setEpgId(Integer.parseInt(params.get("channelId")));
        }
        Response responseHomeScreenApi = given().log().all()
                .get(params.get("ENDPOINT") + DataSetter.getEpgId());

        apiResponse = responseHomeScreenApi.getBody().asString();

        testResult = Utility.checkApiKeys(apiResponse,
                data.get(method.getName()).get("API_KEYS").toString());

        Assert.assertTrue(testResult);
    }

    /**
     * @param method
     * @author - Abhishek Sharma
     * @purpose - Test the live on now detail API
     */
    @Test
    public void testLiveOnNowDetail(Method method) {
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));

        testReport.log(LogStatus.INFO, "API Endpoint: " + "\t" + params.get("ENDPOINT"));
        testReport.log(LogStatus.INFO, "Expected API Keys: " + "\n"
                + data.get(method.getName()).get("API_KEYS"));

        Response responseHomeScreenApi = given().log().all()
                .get(params.get("ENDPOINT") + params.get("channelId"));

        apiResponse = responseHomeScreenApi.getBody().asString();

        testResult = Utility.checkApiKeys(apiResponse,
                data.get(method.getName()).get("API_KEYS").toString());

        Assert.assertTrue(testResult);
    }

    /**
     * @param method
     * @author - Abhishek Sharma
     * @purpose - Test the channel schedule API
     */
    @Test
    public void testChannelSchedule(Method method) {
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));

        testReport.log(LogStatus.INFO, "API Endpoint: " + "\t" + params.get("ENDPOINT"));
        testReport.log(LogStatus.INFO, "Expected API Keys: " + "\n"
                + data.get(method.getName()).get("API_KEYS"));

        Response responseHomeScreenApi = given().log().all()
                .get(params.get("ENDPOINT"));

        channelScheduleResponse = responseHomeScreenApi.getBody().asString();

        testResult = Utility.checkApiKeys(channelScheduleResponse,
                data.get(method.getName()).get("API_KEYS").toString());

        Assert.assertTrue(testResult);
    }

    /**
     * @param method
     * @author - Abhishek Sharma
     * @purpose - Test the forward epg detail API
     */
    @Test
    public void testForwardEpgDetail(Method method) {

        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));

        testReport.log(LogStatus.INFO, "API Endpoint: " + "\t" + params.get("ENDPOINT"));
        testReport.log(LogStatus.INFO, "Expected API Keys: " + "\n"
                + data.get(method.getName()).get("API_KEYS"));

        // getting the epgId
        if (DataSetter.getEpgId() == -1) {
            Utility.setEpgId(Integer.parseInt(params.get("channelId")));
        }
        //System.out.println("epg id is: " + DataSetter.getEpgId());
        Response resposeForwardEPG = given().log().all()
                .get(params.get("ENDPOINT") + DataSetter.getEpgId());
         apiResponse = resposeForwardEPG.getBody().asString();

        testResult = Utility.checkApiKeys(apiResponse,
                data.get(method.getName()).get("API_KEYS"));

        Assert.assertTrue(testResult);
    }

    /**
     * @param method
     * @author - Abhishek Sharma
     * @purpose - Tests the last aired show API
     */
    @Test
    public void testLastAiredShows(Method method) {
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));

        testReport.log(LogStatus.INFO, "API Endpoint: " + "\t" + params.get("ENDPOINT"));
        testReport.log(LogStatus.INFO, "Expected API Keys: " + "\n"
                + data.get(method.getName()).get("API_KEYS"));

        if (DataSetter.getEpgId() == -1) {
            Utility.setEpgId(Integer.parseInt(params.get("channelId")));
        }
        Response responseLastAiredShows = given().log().all()
                .get(params.get("ENDPOINT1") + DataSetter.getEpgId() + params.get("ENDPOINT2"));
        apiResponse = responseLastAiredShows.getBody().asString();

        testResult = Utility.checkApiKeys(apiResponse,
                data.get(method.getName()).get("API_KEYS"));

        Assert.assertTrue(testResult);
    }

    /**
     * @param method
     * @author - Abhishek Sharma
     * @purpose - Tests other episode API
     */
    @Test
    public void testOtherEpisodesApi(Method method) {
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));

        testReport.log(LogStatus.INFO, "API Endpoint: " + "\t" + params.get("ENDPOINT"));
        testReport.log(LogStatus.INFO, "Expected API Keys: " + "\n"
                + data.get(method.getName()).get("API_KEYS"));

        if (DataSetter.getEpgId() == -1) {
            Utility.setEpgId(Integer.parseInt(params.get("channelId")));
        }

        Response otherEpisodeResponse = given().log().all()
                .get(params.get("ENDPOINT1")
                        + DataSetter.getEpgId()
                        + params.get("ENDPOINT2"));
        apiResponse = otherEpisodeResponse.getBody().asString();

        testResult = Utility.checkApiKeys(apiResponse,
                data.get(method.getName()).get("API_KEYS"));

        Assert.assertTrue(testResult);
    }

    @Test
    public void testSeeAllRail(Method method) {
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));

        testReport.log(LogStatus.INFO, "API Endpoint: " + "\t" + params.get("ENDPOINT"));
        testReport.log(LogStatus.INFO, "Expected API Keys: " + "\n"
                + data.get(method.getName()).get("API_KEYS"));

        Response seeAllResponse = given().log().all()
                .get(params.get("ENDPOINT") + params.get("railId"));
        apiResponse = seeAllResponse.getBody().asString();

        testResult = Utility.checkApiKeys(apiResponse,
                data.get(method.getName()).get("API_KEYS"));

        Assert.assertTrue(testResult);
    }

    @Test
    public void testVodContentDetail(Method method) {
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));

        testReport.log(LogStatus.INFO, "API Endpoint: " + "\t" + params.get("ENDPOINT"));
        testReport.log(LogStatus.INFO, "Expected API Keys: " + "\n"
                + data.get(method.getName()).get("API_KEYS"));

        testReport.log(LogStatus.INFO, "test info");
        Response seeAllResponse = given().log().all()
                .get(params.get("ENDPOINT") + params.get("vodId"));
        apiResponse = seeAllResponse.getBody().asString();

        testResult = Utility.checkApiKeys(apiResponse,
                data.get(method.getName()).get("API_KEYS"));

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

    @DataProvider(name = "dataFeeder")
    public Object[][] dataFeeder() {
        Object[][] screenNames = {{"HOMEPAGE"}
                , {"LIVE_HOME"},
                {"WEB_SHORTS_HOME"},
                {"MOVIES_HOME"},
                {"TV_SHOWS_HOME"}};
        return screenNames;
    }

}
