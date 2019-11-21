package com.tatasky.api_automation.OTT_FRONTEND_API;

import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.relevantcodes.extentreports.LogStatus;
import models.ott_frontend.request.LoginManagement.LoginRequestModel;
import models.ott_frontend.response.LoginManagement.LoginWithPassword.LoginWithPasswordMainResponseModel;
import models.ott_frontend.response.LoginManagement.Logout.LogoutMainResponseModel;
import models.ott_frontend.response.LoginManagement.OTPWithRmn.OtpWithRmnMainResponseModel;
import models.ott_frontend.response.LoginManagement.OTPWithSid.OtpWithSidMainResponseModel;
import models.ott_frontend.response.LoginManagement.SubscriberLookupWithRmn.SubscriberLookupWithRmnMainResponseModel;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.DataSetter;
import utils.Utility;

import javax.rmi.CORBA.Util;
import java.lang.reflect.Method;
import java.util.HashMap;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;

public class TestLoginManagement extends BaseClass {

    public HashMap<String, HashMap<String, String>> data;
    public static boolean testResult = false;
    HashMap<String, String> params = new HashMap<String, String>();
    String apiResponse = null;

    /**
     * @author - Abhishek Sharma
     * description - Sets up data for test cases
     */
    @BeforeClass
    public void dataSetup() {
        data = testData.get(this.getClass().getSimpleName());
    }

    /**
     * @param method
     * @author - Abhishek Sharma
     * description - Tests the login with password API
     */
    @Test(alwaysRun = true)
    public void testLoginWithPassword(Method method) {
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        HashMap<String, String> params = new HashMap<String, String>();
        params = Utility.
                getRequestParams(data.get(method.getName()).get("PARAMS"));

        testReport.log(LogStatus.INFO, "API Endpoint: " + "\t" + params.get("ENDPOINT"));
        testReport.log(LogStatus.INFO, "Expected API Keys: " + "\n"
                + data.get(method.getName()).get("API_KEYS"));


        LoginRequestModel oLoginRequestModel = new LoginRequestModel(params.get("SID")
                , params.get("PASSWORD"));

        Response responseLoginPasswordApi = given()
                .log()
                .all()
                .header("Content-Type", "application/json")
                .body(oLoginRequestModel)
                .when()
                .post(params.get("ENDPOINT"));

        apiResponse = responseLoginPasswordApi.getBody().asString();

        // check for api keys

        testResult = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));

        // Asserting the test result
        Assert.assertTrue(testResult);
    }


    /**
     * @param method
     * @author - Abhishek Sharma
     * description - Tests the login with sid otp API
     */
    @Test(alwaysRun = true)
    public void testLoginWithSidOTP(Method method) {

        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());
        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));

        testReport.log(LogStatus.INFO, "API Endpoint: " + "\t" + params.get("ENDPOINT"));
        testReport.log(LogStatus.INFO, "Expected API Keys: " + "\n"
                + data.get(method.getName()).get("API_KEYS"));

        Response responseForApi = given()
                .header("Content-Type", "application/json")
                .get(params.get("ENDPOINT"));

        apiResponse = responseForApi.getBody().asString();

        testResult = Utility.checkApiKeys(apiResponse,
                data.get(method.getName()).get("API_KEYS"));

        Gson gson = new Gson();
        OtpWithSidMainResponseModel oOtpWithSidMainResponseModel = gson
                .fromJson(apiResponse, OtpWithSidMainResponseModel.class);

        Assert.assertTrue(testResult);
    }

    /**
     * @param method
     * @author - Abhishek Sharma
     * description - Tests the otp with rmn API
     */
    @Test(alwaysRun = true)
    public void testOtpWithRmn(Method method) {

        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));

        testReport.log(LogStatus.INFO, "API Endpoint: " + "\t" + params.get("ENDPOINT"));
        testReport.log(LogStatus.INFO, "Expected API Keys: " + "\n"
                + data.get(method.getName()).get("API_KEYS"));

        Response responseForApi = given()
                .header("Content-Type", "application/json")
                .get(params.get("ENDPOINT"));

        apiResponse = responseForApi.getBody().asString();

        testResult = Utility.checkApiKeys(apiResponse,
                data.get(method.getName()).get("API_KEYS"));

        Gson gson = new Gson();
        OtpWithRmnMainResponseModel oOtpWithRmnMainResponseModel = gson
                .fromJson(apiResponse, OtpWithRmnMainResponseModel.class);

        Assert.assertTrue(testResult);
    }

    /**
     * @param method
     * @author - Abhishek Sharma
     * description - Tests the logout API
     */
    @Test(alwaysRun = true)
    public void testLogout(Method method) {

        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        HashMap<String, String> params = new HashMap<String, String>();
        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS").toString());

        testReport.log(LogStatus.INFO, "API Endpoint: " + "\t" + params.get("ENDPOINT"));
        testReport.log(LogStatus.INFO, "Expected API Keys: " + "\n"
                + data.get(method.getName()).get("API_KEYS"));

        String accessToken = Utility.getLoginAccessToken(params.get("SID"), params.get("PASSWORD"), RestAssured.baseURI);

        Response responseLogoutApi = given()
                .header("authorization", "bearer " + accessToken)
                .post(params.get("ENDPOINT"));

        apiResponse = responseLogoutApi.getBody().asString();

        Gson gson = new Gson();
        LogoutMainResponseModel oLogoutMainResponseModel =
                gson.fromJson(apiResponse, LogoutMainResponseModel.class);

        String actualResponseMessage = params.get("message");

        testResult = oLogoutMainResponseModel.getMessage().toString().contains(actualResponseMessage);
        Assert.assertTrue(testResult);

        testResult = false;
        testResult = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));

        Assert.assertEquals(testResult, true);
    }

    /**
     * @param method
     * @author - Abhishek Sharma
     * description - Tests the subsriber lookup API
     */
    @Test(alwaysRun = true)
    public void testSubscriberLookupRMN(Method method) {
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));

        testReport.log(LogStatus.INFO, "API Endpoint: " + "\t" + params.get("ENDPOINT"));
        testReport.log(LogStatus.INFO, "Expected API Keys: " + "\n"
                + data.get(method.getName()).get("API_KEYS"));

        String accessToken = Utility.getLoginAccessToken(params.get("SID"),
                params.get("PASSWORD"), RestAssured.baseURI);

        Response responseSubscriberLookup = given()
                .header("Content-Type", "application/json")
                .header("authorization", "bearer " + accessToken)
                .get(params.get("ENDPOINT"));

        apiResponse = responseSubscriberLookup.getBody().asString();

        Gson gson = new Gson();
        SubscriberLookupWithRmnMainResponseModel oSubscriberLookupWithRmnMainResponseModel
                = gson.fromJson(apiResponse, SubscriberLookupWithRmnMainResponseModel.class);

        testResult = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));

        Assert.assertTrue(testResult);
    }

    /**
     * @author - Abhishek Sharma
     * description - tears down the test data
     */
    @AfterMethod(alwaysRun = true)
    public void tearDownTest() {
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
