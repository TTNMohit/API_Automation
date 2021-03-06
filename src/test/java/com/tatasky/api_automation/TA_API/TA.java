package com.tatasky.api_automation.TA_API;

import com.google.gson.Gson;
import com.relevantcodes.extentreports.LogStatus;
import models.TA.request.EmptyBody;
import models.TA.response.HeroBannerColdStartResponseModel;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.BaseClass;
import utils.DataSetter;
import utils.RequestHandler;
import utils.Utility;

import java.lang.reflect.Method;
import java.sql.SQLOutput;
import java.util.HashMap;

public class TA extends BaseClass {

    public static String profileId = "";
    public static String accessToken = "";
    String sid = "";
    String passsword = "";
    boolean testResultStatus = false;
    HashMap<String, String> params = null;
    HashMap<String, String> headers = null;
    HashMap<String, String> body = null;
    String apiResponse = null;
    String endpoint = null;
    Gson gson = null;
    String taKeys;
    String[][] hero_banner_dataprovider = null;
    String[][] ta_rail_dataprovider = null;

    @BeforeClass
    public void dataSetter() {
        sid = property.getProperty("sid");
        passsword = property.getProperty("password");
        accessToken = Utility.getLoginAccessToken(
                sid,
                passsword);
        profileId = Utility.getListOfProfileIds(accessToken, sid).get(0);
        data = testData.get(this.getClass().getSimpleName());

        // getting the ta-keys
        hero_banner_dataprovider =
                Utility.getTA_Keys(data.get("hero_banner_cold_start").get("TA-KEYS"));

        //test2DArray(hero_banner_dataprovider);
        ta_rail_dataprovider =
                Utility.getTA_Keys(data.get("ta_rail_cold_start").get("TA-KEYS"));
    }

    @BeforeMethod
    public void testSetup(Method method) {
        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        headers = Utility.getRequestParams(data.get(method.getName()).get("HEADERS"));
        endpoint = data.get(method.getName()).get("ENDPOINT");
        body = Utility.getRequestParams(data.get(method.getName()).get("BODY"));
    }

    @Test(dataProvider = "hero_banner_cold_start")
    public void hero_banner_cold_start(String key, Method method) {

        endpoint += "/" + key;
        headers.put("profileId", profileId);
        headers.put("authorization", "bearer " + accessToken);
        EmptyBody oEmptyBody = new EmptyBody();
        oEmptyBody.setEmptyString(null);
        apiResponse = RequestHandler.post(endpoint,
                headers,
                oEmptyBody,
                testReport);
        System.out.println("Response " + apiResponse);

        Gson gson = new Gson();
        HeroBannerColdStartResponseModel oHeroBannerColdStartResponseModel
                = gson.fromJson(apiResponse, HeroBannerColdStartResponseModel.class);
        if (oHeroBannerColdStartResponseModel.getData().getContentList().size() == 0) {
            Assert.assertTrue(false, "The content list is empty for cold start, Test case Failed!!");
        }

        testResultStatus = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));

        Assert.assertTrue(testResultStatus);
    }

    @Test(dataProvider = "ta_rail_cold_start")
    public void ta_rail_cold_start(String key, Method method) {

        endpoint += "/" + key;
        headers.put("profileId", profileId);
        headers.put("authorization", "bearer " + accessToken);
        EmptyBody oEmptyBody = new EmptyBody();
        oEmptyBody.setEmptyString(null);
        apiResponse = RequestHandler.post(endpoint,
                headers,
                oEmptyBody,
                testReport);
        System.out.println("Response " + apiResponse);

        Gson gson = new Gson();
        HeroBannerColdStartResponseModel oHeroBannerColdStartResponseModel
                = gson.fromJson(apiResponse, HeroBannerColdStartResponseModel.class);
        if (oHeroBannerColdStartResponseModel.getData().getContentList().size() == 0) {
            Assert.assertTrue(false, "The content list is empty for cold start, Test case Failed!!");
        }

        testResultStatus = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));

        Assert.assertTrue(testResultStatus);

    }

    @Test(enabled = false)
    public void content_detail_epg(Method method) {

        params.put("id", "3860991");
        headers.put("profileId", profileId);
        headers.put("Authorization", "bearer " + accessToken);
        apiResponse = RequestHandler.post(endpoint,
                headers,
                params,
                new EmptyBody(),
                testReport);
        System.out.println("Response " + apiResponse);

        Gson gson = new Gson();

        testResultStatus = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));

        Assert.assertTrue(testResultStatus);
    }

    /*@DataProvider(name = "hero_banner_cold_start")
    public Object[][] hero_banner_cold_start_data() {

        return new String[][]{{"HOME_UC_HERO_BANNER"},
                {"LIVE_TV_UC_HERO_BANNER"},
                {"ON_DEMAND_MOVIES_UC_HERO_BANNER"},
                {"ON_DEMAND_TVSHOWS_UC_HERO_BANNER"},
                {"ON_DEMAND_SHORTS_UC_HERO_BANNER"}};
    }*/

    @DataProvider(name = "hero_banner_cold_start")
    public Object[][] hero_banner_cold_start_data() {
        return hero_banner_dataprovider;
    }

    /*@DataProvider(name = "ta_rail_cold_start")
    public Object[][] ta_rail_cold_start_data() {

        return new Object[][]{{"HOME_UC_LIVE_NOW_MOVIES"},
                {"HOME_UC_LIVE_NOW"},
                {"HOME_UC_COMING_UP_NEXT"},
                {"HOME_UC_MOVIES_FOR_YOU"},
                {"HOME_UC_SHOWS_FOR_YOU"}};
    }*/

    @DataProvider(name = "ta_rail_cold_start")
    public Object[][] ta_rail_cold_start_data() {

        return ta_rail_dataprovider;
    }

    @AfterMethod
    public void testDown() {
        testResultStatus = false;
        params.clear();
        headers.clear();
        body.clear();
        endpoint = "";
        testReport.log(LogStatus.INFO, " KEY(S) PRESENT:  "
                + DataSetter.getPresentApiKeys());
        testReport.log(LogStatus.INFO, "KEY(S) NOT PRESENT:  " + "\n" +
                DataSetter.getNotPresentApiKeys().toString());
        DataSetter.clearNotPresentApiKeys();
        DataSetter.clearPresentApiKeys();
        testReport.log(LogStatus.INFO, "API Response : " + "\n" + apiResponse);
        apiResponse = null;
    }

/*    public void test2DArray(String[][] test) {
        System.out.println("rows = " + test[0].length);
        System.out.println("columns = " + test.length);
        for (int i = 0; i <= test[0].length; i++) {
            for (int j = 0; j <= test.length; j++) {
                System.out.println(test[i][j]);
            }
        }
    }*/
}
