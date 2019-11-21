package utils;

import static com.jayway.restassured.RestAssured.baseURI;
import static com.jayway.restassured.RestAssured.given;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.jayway.restassured.RestAssured;
import models.ott_frontend.request.ProfileManagement.AddProfileRequestModel;
import models.ott_frontend.response.ProfileManagement.AddProfile.AddProfileMainResponseModel;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.ITestContext;
import org.testng.SkipException;

import models.ott_frontend.request.LoginManagement.LoginRequestModel;
import models.ott_frontend.response.Homescreen_pojo.ChannelSchedule.ChannelScheduleResponseModel;
import models.ott_frontend.response.Homescreen_pojo.ChannelSchedule.Epg;
import models.ott_frontend.response.LoginManagement.LoginWithPassword.LoginWithPasswordMainResponseModel;
import models.ott_frontend.response.NewFavorite.Get_Subscriber.GetSubscriberResponseModel;
import models.ott_frontend.response.ProfileManagement.ListOfProfiles.ListOfProfilesMainResponseModel;

import com.google.gson.Gson;
import com.jayway.restassured.response.Response;
import com.relevantcodes.extentreports.LogStatus;

public class Utility extends BaseClass {

    public static Gson gson = new Gson();

    public static String getLoginAccessToken(String username, String password, String baseUri) {

        String accessToken = null;

        LoginRequestModel loginReq = new LoginRequestModel(username, password);

        Response res = given()
                .log()
                .all()
                .header("Content-Type", "application/json")
                .body(loginReq)
                .when()
                .post(baseUri
                        + "/rest-api/pub/api/v1/pwdLogin");

        String body = res.getBody().asString();
        LoginWithPasswordMainResponseModel loginWithPasswordMainResponseModel = gson
                .fromJson(body, LoginWithPasswordMainResponseModel.class);
        if (loginWithPasswordMainResponseModel.getCode() == 0)
            accessToken = loginWithPasswordMainResponseModel.getData()
                    .getAccessToken();

        return accessToken;
    }

    public static String getLoginAccessToken(String username, String password) {

        String accessToken = null;

        LoginRequestModel loginReq = new LoginRequestModel(username, password);

        Response res = given()
                .header("Content-Type", "application/json")
                .body(loginReq)
                .when()
                .post("/rest-api/pub/api/v1/pwdLogin");

        String body = res.getBody().asString();
        LoginWithPasswordMainResponseModel loginWithPasswordMainResponseModel = gson
                .fromJson(body, LoginWithPasswordMainResponseModel.class);
        if (loginWithPasswordMainResponseModel.getCode() == 0)
            accessToken = loginWithPasswordMainResponseModel.getData()
                    .getAccessToken();

        return accessToken;
    }

    public static int getProfileCount(String accessToken, String SID, String baseUri) {

        int profileCount = -1;
        String localAccessToken = accessToken;
        Response resListOfProfile = given()
                .header("Authorization", "bearer " + localAccessToken)
                .when()
                .get(baseUri
                        + "/rest-api/api/v1/subscribers/" + SID + "/profiles");

        String body = resListOfProfile.getBody().asString();
        System.out.println("Response body for House Request : " + body);

        ListOfProfilesMainResponseModel listOfProfilesMainResponseModel = gson
                .fromJson(body, ListOfProfilesMainResponseModel.class);
        profileCount = listOfProfilesMainResponseModel.getData().getProfiles()
                .size();
        return profileCount;
    }

    public static LinkedList<String> getListOfProfileIds(String accessToken,
                                                         String SID, String baseUri) {

        LinkedList<String> profileIds = new LinkedList<String>();
        String localAccessToken = accessToken;
        Response resListOfProfile = given()
                .header("Authorization", "bearer " + localAccessToken)
                .when()
                .get(baseUri
                        + "/rest-api/api/v1/subscribers/" + SID + "/profiles");

        String body = resListOfProfile.getBody().asString();
        System.out.println("Response body for House Request : " + body);

        ListOfProfilesMainResponseModel listOfProfilesMainResponseModel = gson
                .fromJson(body, ListOfProfilesMainResponseModel.class);
        for (int i = 0; i < listOfProfilesMainResponseModel.getData()
                .getProfiles().size(); i++) {
            profileIds.add(listOfProfilesMainResponseModel.getData()
                    .getProfiles().get(i).getId().toString());
        }

        return profileIds;
    }

    public static LinkedList<String> getListOfProfileIds(String accessToken,
                                                         String SID) {

        LinkedList<String> profileIds = new LinkedList<String>();
        String localAccessToken = accessToken;
        Response resListOfProfile = given()
                .header("Authorization", "bearer " + localAccessToken)
                .when()
                .get("/rest-api/api/v1/subscribers/" + SID + "/profiles");

        String body = resListOfProfile.getBody().asString();
        System.out.println("Response body for House Request : " + body);

        ListOfProfilesMainResponseModel listOfProfilesMainResponseModel = gson
                .fromJson(body, ListOfProfilesMainResponseModel.class);
        for (int i = 0; i < listOfProfilesMainResponseModel.getData()
                .getProfiles().size(); i++) {
            profileIds.add(listOfProfilesMainResponseModel.getData()
                    .getProfiles().get(i).getId().toString());
        }

        return profileIds;
    }

    public static void deleteAllProfiles(List<String> profileId, String SID,
                                         String authToken, String baseUri) {
        Response resDeleteProfiles = null;
        for (int i = 0; i < profileId.size(); i++) {
            resDeleteProfiles = given()
                    .header("Authorization", "bearer " + authToken)
                    .when()
                    .delete(baseUri
                            + "/rest-api/api/v1/subscribers/" + SID
                            + "/profiles/" + profileId.get(i));
            String body = resDeleteProfiles.getBody().asString();
            System.out.println("Response body for House Request : " + body);
        }

    }

    public static boolean checkApiKeys(String apiBody, String keySet) {
        boolean keyStatus = true;
        String[] keyArray;
        keyArray = keySet.split(",");
        for (String keyValue : keyArray) {
            if (apiBody.toLowerCase().contains(keyValue.toLowerCase().trim())) {
                DataSetter.setPresentApiKeys(keyValue);
            } else {
                DataSetter.setNotPresentApiKeys(keyValue);
                //testReport.log(LogStatus.FAIL, "The KEY - >>>>>>" + keyValue +"<<<<<< is not present in the api response");
                keyStatus = false;
            }
        }
        return keyStatus;
    }

    public static boolean checkRunStatus(
            HashMap<String, HashMap<String, HashMap<String, String>>> testData,
            Object iObject, Method method) {
        if (testData.get(iObject.getClass().getSimpleName())
                .get(method.getName()).get("RUN_STATUS")
                .equalsIgnoreCase("skip")) {
            testReport.log(LogStatus.SKIP, "<<<<<<<<<<  Skipping the test case >>>>>>>>>");
            return false;
        }
        return true;
    }

    public static HashMap<String, String> getRequestParams(String requestParams) {
        HashMap<String, String> requestParamsMap = new HashMap<String, String>();
        String[] splitedString;
        splitedString = splitString(requestParams, ",");

        for (int i = 0; i < splitedString.length; i++) {
            String[] splitArray = splitString(splitedString[i].toString(), ":");
            requestParamsMap.put(splitArray[0].toString(), splitArray[1].toString());
            //requestParamsMap.put("key_"+i , "value");
        }
        return requestParamsMap;
    }


    public static String[] splitString(String stringToSplit, String splitChar) {
        String[] arrayString;
        arrayString = stringToSplit.trim().split(splitChar);
        return arrayString;

    }

    public static String[][] getTA_Keys(String taKeys) {
        taKeys = taKeys.replaceAll("\n", "");
        //String[][] taKeysDataProvider = new String[5][1];
        String[] taKeysArray = splitString(taKeys, ",");
        //
        List<String> keyList = new LinkedList<String>();
        for (String key : taKeysArray) {
            keyList.add(key);
        }
        String[][] taKeysDataProvider = new String[keyList.size()][1];
        //
        for (int i = 0; i < taKeysArray.length; i++) {
            taKeysDataProvider[i][0] = taKeysArray[i];
        }
        return taKeysDataProvider;
    }

    public static String dateFormatter(String idate) {
        Date date = new Date(Long.parseLong(idate));
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        //format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        format.setTimeZone(TimeZone.getTimeZone("IST"));
        String formatted = format.format(date);
        format.setTimeZone(TimeZone.getTimeZone("India"));
        formatted = format.format(date);
        return formatted;
    }

    public static void setEpgId(int channelId) {
        boolean epgStatus = false;

        Response responseHomeScreenApi = given()
                .log()
                .all()
                .get("content-detail/pub/api/v1/channels/" + channelId + "/schedule");
        Gson gson = new Gson();
        String apiResponse = responseHomeScreenApi.getBody().asString();
        ChannelScheduleResponseModel oChannelScheduleResponseModel =
                gson.fromJson(apiResponse, ChannelScheduleResponseModel.class);

        for (Epg oEpg : oChannelScheduleResponseModel.getData().getEpg()) {

            if (oEpg.getCatchup() == true) {
                DataSetter.setEpgId(oEpg.getId());
                epgStatus = true;
            }
            if (epgStatus == true)
                break;
        }
    }

    public static String addProfileTest(String accessToken, String SID, String baseUri) {
        HashMap<String, HashMap<String, String>> data;
        String localAccessToken = accessToken;
        String profileId = null;
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

        System.out.println("<<<<<<<<<<<<<<<<<<< produrlis" + baseUri);
        Response resAddProfileUtil = given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization", "bearer " + localAccessToken)
                .body(addProfileRequestModel)
                .when()
                .post(baseUri
                        + "/rest-api/api/v1/subscribers/" + SID + "/profiles");

        String bodyAddProfileResponse = resAddProfileUtil.getBody().asString();
        AddProfileMainResponseModel addProfileMainResponseModel = gson
                .fromJson(bodyAddProfileResponse, AddProfileMainResponseModel.class);
        profileId = addProfileMainResponseModel.getData().getProfileId();

        return profileId;


    }


    public static String getNewDate(Date date) {

        if (date == null) {
            date = new Date();
        }

        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String newDate = simpleDateFormat.format(date);
        return newDate;

    }

    public static String getTypeNameNew(String type) {
        if (type.equals("MOVIES")) {
            return "MOVIES_HOME";
        }

        if (type.equals("LIVE")) {
            return "LIVE_HOME";
        }

        if (type.equals("TV_SHOWS")) {
            return "TV_SHOWS_HOME";
        }

        if (type.equals("WEB_SHORTS")) {
            return "WEB_SHORTS_HOME";
        }


        return "getValue";
    }


}
