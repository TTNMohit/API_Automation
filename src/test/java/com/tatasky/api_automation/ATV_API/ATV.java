package com.tatasky.api_automation.ATV_API;

import com.relevantcodes.extentreports.LogStatus;
import models.ATV.AtvLoginRequestModel;
import models.ATV.EPGSlotIdRequestModel;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.DataSetter;
import utils.RequestHandler;
import utils.Utility;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ATV extends BaseClass {

    public HashMap<String, HashMap<String, String>> data;
    boolean testResultStatus = false;
    HashMap<String, String> params = null;
    HashMap<String, String> headers = null;
    HashMap<String, String> body = null;
    String apiResponse = null;
    String endpoint = null;


    /**
     * @author - Abhishek Sharma
     * @purpose - Sets the test data and access token for using in test methods
     */
    @BeforeClass
    public void dataSetup(ITestContext context) {
        data = testData.get(this.getClass().getSimpleName());
    }

    @BeforeMethod
    public void testSetup(Method method) {
        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        headers = Utility.getRequestParams(data.get(method.getName()).get("HEADERS"));
        endpoint = data.get(method.getName()).get("ENDPOINT");
        body = Utility.getRequestParams(data.get(method.getName()).get("BODY"));
    }

    @Test
    public void channel_Detail_Dvb_Triplet(Method method) {

        // check skip condition
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName());

        apiResponse = RequestHandler.get(endpoint, headers, params, testReport);

        testResultStatus = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));

        Assert.assertTrue(testResultStatus);

    }

    @Test
    public void catchup_details_with_date(Method method) {

        // check skip condition
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName());

        apiResponse = RequestHandler.get(endpoint, headers, params, testReport);

        testResultStatus = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));

        Assert.assertTrue(testResultStatus);
    }

    @Test
    public void atv_web_shorts_home(Method method) {
        // check skip condition
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName());

        apiResponse = RequestHandler.get(endpoint, headers, params, testReport);

        testResultStatus = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));

        Assert.assertTrue(testResultStatus);

    }

    @Test
    public void atv_tv_shows_home(Method method) {
        // check skip condition
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName());

        apiResponse = RequestHandler.get(endpoint, headers, params, testReport);

        testResultStatus = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));

        Assert.assertTrue(testResultStatus);
    }

    @Test
    public void atv_homepage(Method method) {
        // check skip condition
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName());

        apiResponse = RequestHandler.get(endpoint, headers, params, testReport);

        testResultStatus = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));

        Assert.assertTrue(testResultStatus);
    }

    @Test
    public void atv_movies_home(Method method) {
        // check skip condition
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName());

        apiResponse = RequestHandler.get(endpoint, headers, params, testReport);

        testResultStatus = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));

        Assert.assertTrue(testResultStatus);
    }

/*    @Test
    public void epg_details_by_dvbTriplet(Method method) {
        // check skip condition
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName());

        apiResponse = RequestHandler.post(endpoint, headers, body, testReport);

        testResultStatus = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));

        Assert.assertTrue(testResultStatus);

    }*/

    @Test
    public void epg_by_slot_id(Method method) {
        // check skip condition
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName());

        // setting the body data
        EPGSlotIdRequestModel oEPGSlotIdRequestModel
                = new EPGSlotIdRequestModel();

        List<String> epgSlots = new LinkedList<String>();
        String[] epgSlotsArray = Utility.splitString(body.get("EpgSlotIdList"), ";");
        for (String epgSlot : epgSlotsArray) {
            epgSlots.add(epgSlot);
        }
        oEPGSlotIdRequestModel.setEpgSlotIdList(epgSlots);
        apiResponse = RequestHandler.post(endpoint, headers, oEPGSlotIdRequestModel, testReport);

        testResultStatus = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));

        Assert.assertTrue(testResultStatus);
    }

    @Test
    public void atv_login(Method method) {
        // check skip condition
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName());

        AtvLoginRequestModel oAtvLoginRequestModel
                = new AtvLoginRequestModel();
        oAtvLoginRequestModel.setSid(body.get("sid"));
        oAtvLoginRequestModel.setHash(property.getProperty("hash-key"));
        apiResponse = RequestHandler
                .post(endpoint, headers, oAtvLoginRequestModel, testReport);

        testResultStatus = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));

        Assert.assertTrue(testResultStatus);


    }

    @Test
    public void catchup_epg_by_slot_id(Method method) {
        // check skip condition
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName());
        apiResponse = RequestHandler
                .get(endpoint, headers, params, testReport);

        testResultStatus = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));

        Assert.assertTrue(testResultStatus);
    }

    @Test
    public void atv_more(Method method) {
        // check skip condition
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName());

        apiResponse = RequestHandler
                .get(endpoint, headers, params, testReport);

        testResultStatus = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));

        Assert.assertTrue(testResultStatus);
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
}
