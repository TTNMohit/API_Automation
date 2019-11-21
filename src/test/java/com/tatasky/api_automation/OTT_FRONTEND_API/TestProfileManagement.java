package com.tatasky.api_automation.OTT_FRONTEND_API;

import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
//import com.jayway.restassured.http.Method;
import com.jayway.restassured.response.Response;
import com.relevantcodes.extentreports.LogStatus;
import models.ott_frontend.request.ProfileManagement.AddProfileRequestModel;
import models.ott_frontend.request.ProfileManagement.EditProfileRequestModel;
import models.ott_frontend.request.ProfileManagement.ParentalLockRequestModel;
import models.ott_frontend.request.ProfileManagement.SwitchProfileRequestModal;
import models.ott_frontend.response.ProfileManagement.AddProfile.AddProfileMainResponseModel;
import models.ott_frontend.response.ProfileManagement.ListOfProfiles.ListOfProfilesMainResponseModel;
import models.ott_frontend.response.ProfileManagement.ListOfProfiles.ListOfProfilesResponseModel;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.DataSetter;
import utils.Utility;

import java.lang.reflect.Method;

import java.util.*;

import static com.jayway.restassured.RestAssured.baseURI;
import static com.jayway.restassured.RestAssured.given;
import static utils.Utility.deleteAllProfiles;
import static utils.Utility.getListOfProfileIds;

public class TestProfileManagement extends BaseClass {

    public final static Logger LOGGER = Logger.getLogger(TestProfileManagement.class);

    public HashMap <String, HashMap <String, String>> data;
    boolean testResultStatus = false;

    Gson gson = new Gson();
    String accessToken = null;
    int profileCount = -1;
    String profileId =null;
    HashMap <String, String> profileMap = new HashMap <String, String>();
    HashMap<String, String> params = null;

    boolean testResultAddProfile = false;
    boolean testResultEditProfile = false;
    boolean testResultListProfiles = false;
    boolean testRemoveProfileTest = false;
    boolean testSwitchProfileTest = false;
    boolean testProfileLockTest = false;
    boolean testCategoryListingTest = false;
    boolean testPrefrenceListing = false;
    boolean testResult = false;
    String apiResponse = null;

    /**
     * @Author = Sahil Sachdeva
     * @Description= Get the User Access token and Parameters from the DataSheet
     */
    @BeforeClass
    public void dataSetup() {


        data = testData.get(this.getClass().getSimpleName());
       // RestAssured.baseURI = "https://tatasky-uat-kong.videoready.tv";

        profileMap = Utility.getRequestParams(data.get("dataSetup").get("PARAMS"));

        accessToken = Utility.getLoginAccessToken(
                profileMap.get("SID"),
                profileMap.get("PASSWORD"),
                RestAssured.baseURI.toString());

        profileCount = Utility.getProfileCount(
                accessToken,
                profileMap.get("SID"), RestAssured.baseURI.toString());

        if (profileCount > 1) {
            deleteAllProfiles(
                    Utility.getListOfProfileIds(accessToken,
                            profileMap.get("SID"), RestAssured.baseURI.toString()),
                    profileMap.get("SID"), accessToken, RestAssured.baseURI.toString());
        }


    }

    /**
     * @Author =Sahil Sachdeva
     * @Description= Add the User profile
     */

    @Test
    public void addProfileTest(Method method) {
        testReport.log(LogStatus.INFO, "Add Profile");
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());


        profileMap = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        testReport.log(LogStatus.INFO, "API Path and Parameters - " + profileMap);
        AddProfileRequestModel addProfileRequestModel = new AddProfileRequestModel();
        String generatedString = RandomStringUtils.randomAlphanumeric(8);
        System.out.println("generated string" + generatedString);
        addProfileRequestModel.setProfileName(generatedString);
        addProfileRequestModel.setAgeGroup("13-18");
        addProfileRequestModel.setGender("Male");
        addProfileRequestModel.setProfilePic("HM 2LTE-IN");
        addProfileRequestModel.setIsDefaultProfile(false);
        addProfileRequestModel.setIsKidsProfile(false);
        addProfileRequestModel.setCategoryIds(null);
        addProfileRequestModel.setLanguageIds(null);


            Response resAddProfile = given().log().all()
                    .header("Content-Type", "application/json")
                    .header("Authorization", "bearer " + accessToken)
                    .body(addProfileRequestModel)
                    .when()
                    .post(profileMap.get("ENDPOINT"));


        apiResponse = resAddProfile.getBody().asString();
        testReport.log(LogStatus.INFO, "API Response - " + apiResponse);
        testReport.log(LogStatus.INFO, "Expected Keys - " + data.get(method.getName()).get("API_KEYS"));
        AddProfileMainResponseModel addProfileMainResponseModel = gson
                .fromJson(apiResponse, AddProfileMainResponseModel.class);

        testResultAddProfile = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));

        Assert.assertEquals(testResultAddProfile, true);
        profileId = addProfileMainResponseModel.getData().getProfileId();
    }

    /**
     * @Author= Sahil Sachdeva
     * @Description = Edit the Newly Created Profile
     */
    @Test
    public void editProfileTest(Method method) {
        testReport.log(LogStatus.INFO, "Edit Profile");

        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());
        EditProfileRequestModel editProfileRequestModel = new EditProfileRequestModel();
        String generatedString = RandomStringUtils.randomAlphanumeric(8);
        System.out.println("generated string" + generatedString);
        editProfileRequestModel.setProfileName(generatedString);
        editProfileRequestModel.setAgeGroup("18-25");
        editProfileRequestModel.setGender("Female");
        editProfileRequestModel.setProfilePic("HM 2LTE-IN");
        editProfileRequestModel.setIsDefaultProfile(false);
        editProfileRequestModel.setIsKidsProfile(false);
        editProfileRequestModel.setCategoryIds(null);
        editProfileRequestModel.setLanguageIds(null);
        profileMap = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        testReport.log(LogStatus.INFO, "API Path and Parameters - " + profileMap);
        if (profileId == null || profileId.isEmpty()) {
            profileId= Utility.addProfileTest(accessToken,profileMap.get("SID"), RestAssured.baseURI.toString());
        }
        Response resEditProfile = given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization", "bearer " + accessToken)
                .body(editProfileRequestModel)
                .when()
                .put(profileMap.get("ENDPOINT") + profileId);
        apiResponse = resEditProfile.getBody().asString();
        testReport.log(LogStatus.INFO, "API Response - " + apiResponse);
        testReport.log(LogStatus.INFO, "Expected Keys - " + data.get(method.getName()).get("API_KEYS"));

        testResultEditProfile = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));
        Assert.assertEquals(testResultEditProfile, true);

    }

    /**
     * @Author= Sahil Sachdeva
     * @Description = Get the Channel_List of Profile
     */
    @Test
    public void listOfProfileTest(Method method) {
        testReport.log(LogStatus.INFO, "list of Profile");
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());
        profileMap = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        testReport.log(LogStatus.INFO, "API Path and Parameters - " + profileMap);

        Response fetchProfile = given().log().all()
                // .header("content-type", "application/json")
                .header("Authorization", "bearer " + accessToken)
                .when()
                .get(profileMap.get("ENDPOINT"));
        apiResponse = fetchProfile.getBody().asString();
        testReport.log(LogStatus.INFO, "API Response - " + apiResponse);
        testReport.log(LogStatus.INFO, "Expected Keys - " + data.get(method.getName()).get("API_KEYS"));
        testResultListProfiles = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));
        System.out.println(testResultListProfiles);
        ListOfProfilesMainResponseModel listOfProfilesMainResponseModel = gson.fromJson(apiResponse, ListOfProfilesMainResponseModel.class);
        System.out.println(fetchProfile.getStatusCode());
        System.out.println(listOfProfilesMainResponseModel.getData().getProfiles().size());
        System.out.println(listOfProfilesMainResponseModel.getData().getProfiles());
        List <ListOfProfilesResponseModel> profile = listOfProfilesMainResponseModel.getData().getProfiles();
        ListIterator <ListOfProfilesResponseModel> profileIterator = profile.listIterator();
        while (profileIterator.hasNext()) {
            System.out.println(profileIterator.next().getId());
        }

    }

    /**
     * @Author= Sahil Sachdeva
     * @Description = Remove the Newly created Profile
     */
    @Test(priority = 2)
    public void removeProfileTest(Method method) {
        testReport.log(LogStatus.INFO, "remove Profile");
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        profileMap = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        testReport.log(LogStatus.INFO, "API Path and Parameters - " + profileMap);
        if (profileId == null || profileId.isEmpty()) {
            profileId= Utility.addProfileTest(accessToken,profileMap.get("SID"), RestAssured.baseURI.toString());
        }

        Response deleteProfile = given().log().all()
                .header("Authorization", "bearer " + accessToken)
                .when()
                .delete(profileMap.get("ENDPOINT") + profileId);

        apiResponse = deleteProfile.getBody().asString();
        testReport.log(LogStatus.INFO, "API Response - " + apiResponse);
        testReport.log(LogStatus.INFO, "Expected Keys - " + data.get(method.getName()).get("API_KEYS"));
        testRemoveProfileTest = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));

        //System.out.println(testRemoveProfileTest);
        //System.out.println(deleteProfile.getStatusCode());
        //Assert.assertEquals(200,deleteProfile.getStatusCode());
        Assert.assertEquals(testRemoveProfileTest, true);

    }

    /**
     * @Author= Sahil Sachdeva
     * @Description = Switch the Default profile of the User
     */
    @Test(priority = 1)
    public void switchDefaultProfile(Method method) {
        System.out.println("Inside switchProfile env :"+System.getProperty("env")+" baseUrl : "+baseURI);

        testReport.log(LogStatus.INFO, "remove Profile");
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());
        profileMap = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        testReport.log(LogStatus.INFO, "API Path and Parameters - " + profileMap);

        profileId= Utility.addProfileTest(accessToken,profileMap.get("SID"), RestAssured.baseURI.toString());
        //profileId= Utility.addProfileTest(accessToken,profileMap.get("SID") ,);
        SwitchProfileRequestModal switchProfileRequestModal = new SwitchProfileRequestModal();
        switchProfileRequestModal.setIsDefaultProfile(true);

        Response switchProfile = given().log().all()
                .header("Authorization", "bearer " + accessToken)

                .header("content-type", "application/json")
                .body(switchProfileRequestModal)
                .when()
                .patch(profileMap.get("ENDPOINT") + profileId);

        apiResponse = switchProfile.getBody().asString();
        testReport.log(LogStatus.INFO, "API Response - " + apiResponse);
        testReport.log(LogStatus.INFO, "Expected Keys - " + data.get(method.getName()).get("API_KEYS"));
        testSwitchProfileTest = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));
        System.out.println(apiResponse);
        Assert.assertEquals(testSwitchProfileTest, true);
    }

    /**
     * @Author= Sahil Sachdeva
     * @Description = Set the Parental Lock
     */
    @Test
    public void parentalLock(Method method) {

        System.out.println("start parental lock env :"+System.getProperty("env")+" baseUrl : "+baseURI);

        testReport.log(LogStatus.INFO, "Parental Lock");

        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());
        profileMap = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        testReport.log(LogStatus.INFO, "API Path and Parameters - " + profileMap);

        ParentalLockRequestModel parentalLockRequestModel = new ParentalLockRequestModel();
        parentalLockRequestModel.setParentalLock(profileMap.get("ParentalLock"));

        Response lock = given().log().all()
                .header("content-type", "application/json")
                .header("authorization", "bearer " + accessToken)
                .body(parentalLockRequestModel)
                .when()
                .post(profileMap.get("ENDPOINT"));

        apiResponse = lock.getBody().asString();

        testReport.log(LogStatus.INFO, "API Response - " + apiResponse);
        testReport.log(LogStatus.INFO, "Expected Keys - " + data.get(method.getName()).get("API_KEYS"));
        testProfileLockTest = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));
        // System.out.println(profileLockForKids);
        //Assert.assertEquals(200,lock.getStatusCode());
        Assert.assertEquals(testProfileLockTest, true);
        System.out.println("start parental lock env :"+System.getProperty("env")+" baseUrl : "+baseURI);

    }

    /**
     * @Author= Sahil Sachdeva
     * @Description = Check the Channel_List of category of a Profile
     */
    @Test
    public void categoryList(Method method) {
        testReport.log(LogStatus.INFO, "Category Channel_List");
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        profileMap = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        testReport.log(LogStatus.INFO, "API Path and Parameters - " + profileMap);

          Response catList = given().log().all()
                .header("authorization", "bearer " + accessToken)
                .when()
                .get(profileMap.get("ENDPOINT"));

        apiResponse = catList.getBody().asString();

        testReport.log(LogStatus.INFO, "API Response - " + apiResponse);

        testReport.log(LogStatus.INFO, "Expected Keys - " + data.get(method.getName()).get("API_KEYS"));
        testCategoryListingTest = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));
        Assert.assertEquals(testCategoryListingTest, true);
    }

    /**
     * @Author= Sahil Sachdeva
     * @Description = Check the Channel_List of Languages of a Profile
     **/
    @Test
    public void languageList(Method method) {
        testReport.log(LogStatus.INFO, "Language Channel_List");
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());
        profileMap = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        testReport.log(LogStatus.INFO, "API Path and Parameters - " + profileMap);

        Response lanList = given()
                .header("authorization", "bearer " + accessToken)
                .when()
                .get(profileMap.get("ENDPOINT"));

        apiResponse = lanList.getBody().asString();
        testCategoryListingTest = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));
        testReport.log(LogStatus.INFO, "API Response - " + apiResponse);
        testReport.log(LogStatus.INFO, "Expected Keys - " + data.get(method.getName()).get("API_KEYS"));
        Assert.assertEquals(testCategoryListingTest, true);
    }

    /**
     * @Author= Sahil Sachdeva
     * @Description = Check the User Preference languages
     */
    @Test
    public void preferenceList(Method method) {
        testReport.log(LogStatus.INFO, "Preference  Channel_List");
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());
        profileMap = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        testReport.log(LogStatus.INFO, "API Path and Parameters - " + profileMap);

        Response prefList = given()
                //.header("content-type","application/json")
                .header("authorization", "bearer " + accessToken)
                .when()
                .get(profileMap.get("ENDPOINT"));

        apiResponse = prefList.getBody().asString();
        testReport.log(LogStatus.INFO, "API Response - " + apiResponse);
        testReport.log(LogStatus.INFO, "Expected Keys - " + data.get(method.getName()).get("API_KEYS"));

        testPrefrenceListing = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));
        Assert.assertEquals(testPrefrenceListing, true);
    }

    @AfterMethod
    public void tearDown() {

        testResult = false;
      //  params.clear();
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

