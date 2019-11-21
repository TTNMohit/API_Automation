package com.tatasky.api_automation.OTT_FRONTEND_API;

import models.ATV.EPGDvbTripletRequestModel;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.RequestHandler;
import utils.Utility;

import java.lang.reflect.Method;
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
    public void epg_details_by_dvbTriplet(Method method) {
        // check skip condition
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName());

        // setting the values in body object
        EPGDvbTripletRequestModel oEPGDvbTripletRequestModel
                = new EPGDvbTripletRequestModel();
        oEPGDvbTripletRequestModel.setDate(body.get("Date"));
        List<String> dvbTripletValues = new LinkedList<String>();
        String[] dvbTriplets = Utility.splitString(body.get("dvbTripletList"), ";");
        for (String dvbTriplet : dvbTriplets) {
            dvbTripletValues.add(dvbTriplet);
        }
        oEPGDvbTripletRequestModel.setDvbTripletList(dvbTripletValues);

        apiResponse = RequestHandler.post(endpoint, headers, oEPGDvbTripletRequestModel, testReport);

        testResultStatus = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));

        Assert.assertTrue(testResultStatus);

    }
}
