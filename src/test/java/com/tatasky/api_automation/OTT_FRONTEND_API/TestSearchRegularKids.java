package com.tatasky.api_automation.OTT_FRONTEND_API;

import com.google.gson.Gson;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import com.relevantcodes.extentreports.LogStatus;
import models.ott_frontend.response.Search.GlobalV1Search.GlobalSearchV1ResponseMain;
import models.ott_frontend.response.Search.GlobalV1Search.GlobalV1SearchContentResult1;
import models.ott_frontend.response.Search.GlobalV1Search.GlobalV1SearchData;
import models.ott_frontend.response.Search.GlobalV1Search.GlobalV1SearchLiveContentResults;
import models.ott_frontend.response.Search.GlobalV2Search.GlobalSearchV2ResponseContentResult;
import models.ott_frontend.response.Search.GlobalV2Search.GlobalSearchV2ResponseItem;
import models.ott_frontend.response.Search.GlobalV2Search.GlobalSearchV2ResponseMain;
import models.ott_frontend.response.Search.KidsCatchUpSearh.KidsCatchUp;
import models.ott_frontend.response.Search.KidsCatchUpSearh.KidsCatchUpSearchContentResult;
import models.ott_frontend.response.Search.KidsChannelSearch.KidsChannel;
import models.ott_frontend.response.Search.KidsChannelSearch.KidsChannelSearchContentResult;
import models.ott_frontend.response.Search.KidsVodSearch.KidsVod;
import models.ott_frontend.response.Search.KidsVodSearch.KidsVodSearchContentResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.DataSetter;
import utils.Utility;

import java.lang.reflect.Method;
import java.util.*;
import java.util.logging.Logger;

import org.testng.Assert;

import static com.jayway.restassured.RestAssured.given;

public class TestSearchRegularKids extends BaseClass {

    Gson gson = new Gson();
    public boolean testResult = false;
    public HashMap<String, HashMap<String, String>> data;
    HashMap<String, String> params = new HashMap<String, String>();
    boolean testSearchChannel = false;
    boolean testResultSearchV2 = false;
    boolean testSearchVod = false;
    boolean testresultSearchV1 = false;
    boolean testSearchCatchUp = false;
    boolean testSearchSeeAllId1 = false;
    boolean testSearchSeeAllId2 = false;
    boolean testSearchSeeAllId3 = false;
    boolean testSearchSeeAllId4 = false;
    boolean testAutoCompleteV1 = false;
    boolean testAutoCompleteV2 = false;
    boolean testKidsAutoCompleteV1 = false;
    boolean testFetchKidsContentType = false;
    boolean testregularRecommendation = false;
    //  boolean testResult = false;
    String apiResponse = null;

    Properties property = initPropFromFile("config.properties");


    /**
     * @author : Sahil Sachdeva
     * @Description: Data setup Class
     */

    @BeforeClass
    public void DataSetup() {
        data = testData.get(this.getClass().getSimpleName());
        Properties property = initPropFromFile("config.properties");

    }

    /**
     * @Author: Sahil Sachdeva
     * Description: Global Search V2 version with Show different showtype
     */
    @Test(dataProvider = "typeSection")
    public void globalV2Search(String typeName, Method method) {

        testReport.log(LogStatus.INFO, "Global V2 Search for showType All,Movies,Tv Shows, Shorts");
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());
        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        testReport.log(LogStatus.INFO, "API Path and Parameters - " + params);
        Response search = given().log().all()
                .header("content-Type", "application/json")
                .queryParam("queryString", params.get("queryString"))
                .queryParam("showType", typeName)
                .when()
                .get(params.get("ENDPOINT"));

        apiResponse = search.getBody().asString();
        testResultSearchV2 = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));

        GlobalSearchV2ResponseMain globalSearchV2ResponseMain = gson.fromJson(apiResponse, GlobalSearchV2ResponseMain.class);
        List<GlobalSearchV2ResponseItem> items = globalSearchV2ResponseMain.getData().getItems();
        int sizeOfAvailableShowtype = globalSearchV2ResponseMain.getData().getItems().size();
        System.out.println("Number of Show Type " + sizeOfAvailableShowtype);
        ListIterator<GlobalSearchV2ResponseItem> listing = items.listIterator();
        while (listing.hasNext()) {
            GlobalSearchV2ResponseItem globalSearchV2ResponseItem = listing.next();
            System.out.println("Title is >>>> " + globalSearchV2ResponseItem.getTitle());
            List<GlobalSearchV2ResponseContentResult> contents = globalSearchV2ResponseItem.getContentResults();
            int sizeOfContentPresent = globalSearchV2ResponseItem.getTotalCount();
            System.out.println("Number of events present " + sizeOfContentPresent);
            ListIterator<GlobalSearchV2ResponseContentResult> contentListing = contents.listIterator();
            while (contentListing.hasNext()) {
                GlobalSearchV2ResponseContentResult globalSearchV2ResponseContentResult = contentListing.next();
                System.out.println("Title is +++++ " + globalSearchV2ResponseContentResult.getTitle());
                System.out.println("Provider is +++" + globalSearchV2ResponseContentResult.getProvider());
            }

        }
        Assert.assertEquals(testResultSearchV2, true);
    }

    @Test(dataProvider = "typeSection")
    public void globalV1Search(String typeName, Method method) {
        testReport.log(LogStatus.INFO, "Global V1 Search for showType All,Movies,Tv Shows, Shorts");
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());
        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        testReport.log(LogStatus.INFO, "API Path and Parameters - " + params);


        Response searchV1 = given().log().all()
                .header("content-type", "application/json")
                .queryParam("queryString", params.get("queryString"))
                .queryParam("showType", typeName)
                .when()
                .get(params.get("ENDPOINT"));

        apiResponse = searchV1.getBody().asString();

        testReport.log(LogStatus.INFO, "API Response - " + apiResponse);
        testReport.log(LogStatus.INFO, "Expected Keys - " + data.get(method.getName()).get("API_KEYS"));
        GlobalSearchV1ResponseMain globalSearchV1ResponseMain = gson.fromJson(apiResponse, GlobalSearchV1ResponseMain.class);
        GlobalV1SearchLiveContentResults liveContent = globalSearchV1ResponseMain.getData().getLiveContentResults();
        List<GlobalV1SearchContentResult1> liveContentResult = liveContent.getContentResults();
        int sizeOf = liveContentResult.size();
        ListIterator<GlobalV1SearchContentResult1> liveContentIterator = liveContentResult.listIterator();
        while (liveContentIterator.hasNext()) {
            GlobalV1SearchContentResult1 ite = liveContentIterator.next();
            System.out.println(ite.getContentType());
            System.out.println(ite.getTitle());

        }

        System.out.println("Size is" + sizeOf);
        testresultSearchV1 = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));
        Assert.assertEquals(testresultSearchV1, true);
    }


    /**
     * @Author= Sahil Sachdeva
     * @Description= Kids Channel Search
     */
    @Test
    public void kidsChannelSearch(Method method) {

        testReport.log(LogStatus.INFO, "Kids Search for Channels");
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());
        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        testReport.log(LogStatus.INFO, "API Path and Parameters - " + params);

        Response search = given().log().all()
                .header("content/type", "application/json")
                .queryParam("queryString", params.get("queryString"))
                .queryParam("contentType", "Channel")
                .when()
                .get(params.get("ENDPOINT"));

        apiResponse = search.getBody().asString();
        System.out.println(apiResponse);
        testReport.log(LogStatus.INFO, "Expected Keys - " + data.get(method.getName()).get("API_KEYS"));

        testSearchChannel = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));

        KidsChannel kidsChannel = gson.fromJson(apiResponse, KidsChannel.class);
        List<KidsChannelSearchContentResult> kidsSearchChannel = kidsChannel.getData().getContentResults();
        ListIterator<KidsChannelSearchContentResult> kidsIterator = kidsSearchChannel.listIterator();
        while (kidsIterator.hasNext()) {
            KidsChannelSearchContentResult kidsChannelSearchContentResult = kidsIterator.next();


            boolean checkType = kidsChannelSearchContentResult.getContentType().equalsIgnoreCase("LIVE") && kidsChannelSearchContentResult.getContractName().equalsIgnoreCase("SUBSCRIPTION");
            if (checkType == true) {
                System.out.println("Value match");

            } else if (checkType == false) {
                testReport.log(LogStatus.INFO, "Expected ContentType=LIVE" + "'\t'Found is =" + kidsChannelSearchContentResult.getContentType());
                testReport.log(LogStatus.INFO, "Expected ContractName=SUBSCRIPTION" + "'\t' Found is=" + kidsChannelSearchContentResult.getContractName());
                Assert.assertEquals(checkType, true);
            }
            List<String> genreDetail = kidsChannelSearchContentResult.getGenres();
            System.out.println(genreDetail);
            String kids = property.getProperty("KIDS_Channel_Genre");
            String data[] = kids.split(",");
            List<String> channelKids = Arrays.asList(data);
            for (String genre : genreDetail) {
                System.out.println(channelKids);
                if (channelKids.contains(genre))
                    testReport.log(LogStatus.INFO, genre + "=====" + "match");
                else
                    testReport.log(LogStatus.INFO, genre + "=====" + "Not match");
            }
        }
    }

    /**
     * @Author= Sahil Sachdeva
     * @Description= Kids Vod Search
     */
    @Test
    public void kidsVodSearch(Method method) {
        testReport.log(LogStatus.INFO, "Kids Search for Channels");
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        testReport.log(LogStatus.INFO, "API Path and Parameters - " + params);

        Response search = given().log().all()
                .header("content/type", "application/json")
                .queryParam("queryString", params.get("queryString"))
                .queryParam("contentType", "Vod")
                .when()
                .get(params.get("ENDPOINT"));

        apiResponse = search.getBody().asString();
        System.out.println(apiResponse);
        testReport.log(LogStatus.INFO, "Expected Keys - " + data.get(method.getName()).get("API_KEYS"));

        testSearchVod = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));

        KidsVod kidsVod = gson.fromJson(apiResponse, KidsVod.class);
        List<KidsVodSearchContentResult> kidsSearchVod = kidsVod.getData().getContentResults();
        ListIterator<KidsVodSearchContentResult> kidsIterator = kidsSearchVod.listIterator();
        while (kidsIterator.hasNext()) {
            KidsVodSearchContentResult kidsVodSearchContentResult = kidsIterator.next();
           /* boolean checkType = kidsVodSearchContentResult.getContentType().equalsIgnoreCase("LIVE") && kidsVodSearchContentResult.getContractName().equalsIgnoreCase("SUBSCRIPTION");
            if (checkType ==true) {
                System.out.println("Value match");

            }
            else if (checkType ==false)
            {
                testReport.log(LogStatus.INFO,"Expected ContentType=LIVE" + "'\t'Found is =" + kidsVodSearchContentResult.getContentType());
                testReport.log(LogStatus.INFO,"Expected ContractName=SUBSCRIPTION" + "'\t' Found is=" + kidsVodSearchContentResult.getContractName() );
                Assert.assertEquals(checkType,true);
            }
           */
            List<String> genreDetail = kidsVodSearchContentResult.getGenres();
            System.out.println(genreDetail);
            String kids = property.getProperty("KIDS_VOD_GENRE");
            String data[] = kids.split(",");
            List<String> vodKids = Arrays.asList(data);
            for (String genre : genreDetail) {
                System.out.println(vodKids);
                if (vodKids.contains(genre))
                    testReport.log(LogStatus.INFO, genre + "=====" + "match");
                else
                    testReport.log(LogStatus.INFO, genre + "=====" + "Not match");
            }
        }
        testSearchVod = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));
        Assert.assertEquals(testSearchVod, true);
    }


    /**
     * @Author = Sahil Sachdeva
     * @Description =  Kids Catch up search
     */

    @Test
    public void kidsCatchUp(Method method) {
        testReport.log(LogStatus.INFO, "Kids Search for Channels");
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        testReport.log(LogStatus.INFO, "API Path and Parameters - " + params);

        Response search = given().log().all()
                .header("content/type", "application/json")
                .queryParam("queryString", params.get("queryString"))
                .queryParam("contentType", "Catch UP")
                .when()
                .get(params.get("ENDPOINT"));

        apiResponse = search.getBody().asString();
        System.out.println(apiResponse);
        testReport.log(LogStatus.INFO, "Expected Keys - " + data.get(method.getName()).get("API_KEYS"));

        testSearchCatchUp = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));

        KidsCatchUp kidsCatchUp = gson.fromJson(apiResponse, KidsCatchUp.class);
        List<KidsCatchUpSearchContentResult> kidsSearchCatchup = kidsCatchUp.getData().getContentResults();
        ListIterator<KidsCatchUpSearchContentResult> kidsIterator = kidsSearchCatchup.listIterator();
        while (kidsIterator.hasNext()) {
            KidsCatchUpSearchContentResult kidsCatchUpSearchContentResult = kidsIterator.next();
            boolean checkType = kidsCatchUpSearchContentResult.getContentType().equalsIgnoreCase("CATCH_UP") && kidsCatchUpSearchContentResult.getContractName().equalsIgnoreCase("SUBSCRIPTION");
            if (checkType == true) {
                System.out.println("Value match");

            } else if (checkType == false) {
                testReport.log(LogStatus.INFO, "Expected ContentType=CATCH_UP" + "'\t'Found is =" + kidsCatchUpSearchContentResult.getContentType());
                testReport.log(LogStatus.INFO, "Expected ContractName=SUBSCRIPTION" + "'\t' Found is=" + kidsCatchUpSearchContentResult.getContractName());
                Assert.assertEquals(checkType, true);
            }

            List<String> genreDetail = kidsCatchUpSearchContentResult.getGenres();
            System.out.println(genreDetail);
                /*String kids=property.getProperty("KIDS_VOD_GENRE");
                String data[]=kids.split(",");
                Channel_List<String> vodKids = Arrays.asList(data);
                for(String genre:genreDetail){
                    System.out.println(vodKids);
                    if(vodKids.contains(genre))
                        testReport.log(LogStatus.INFO,genre+"====="+"match");
                    else
                        testReport.log(LogStatus.INFO,genre+"====="+"Not match");
                }*/
        }
        testSearchCatchUp = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));
        Assert.assertEquals(testSearchCatchUp, true);
    }

    /**
     * @Author Sahil Sachdeva
     * @Description: See all
     */

    @Test(dataProvider = "typeSection", enabled = false)
    public void searchV2SeeAllId1(String typeName, Method method) {
        testReport.log(LogStatus.INFO, "Global V2 Search see all for showType All,Movies,Tv Shows, Shorts");
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        testReport.log(LogStatus.INFO, "API Path and Parameters - " + params);
        Response res = given().log().all()
                .header("content-type", "application/json")
                .queryParam("queryString", params.get("queryString"))
                .queryParam("showType", typeName)
                .queryParam("max", 3000)
                .when()
                .get(params.get("ENDPOINT"));

        apiResponse = res.getBody().asString();
        testSearchSeeAllId1 = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));
        Assert.assertEquals(testSearchSeeAllId1, true);


    }

    @Test(dataProvider = "typeSection", enabled = false)
    public void searchV2SeeAllId2(String typeName, Method method) {
        testReport.log(LogStatus.INFO, "Global V2 Search seeAll for showType All,Movies,Tv Shows, Shorts");
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        testReport.log(LogStatus.INFO, "API Path and Parameters - " + params);
        Response res = given().log().all()
                .header("content-type", "application/json")
                .queryParam("queryString", params.get("queryString"))
                .queryParam("showType", typeName)
                .queryParam("max", 3000)
                .when()
                .get(params.get("ENDPOINT"));

        apiResponse = res.getBody().asString();
        testSearchSeeAllId2 = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));
        Assert.assertEquals(testSearchSeeAllId2, true);

    }

    @Test(dataProvider = "typeSection", enabled = false)
    public void searchV2SeeAllId3(String typeName, Method method) {
        testReport.log(LogStatus.INFO, "Global V2 Search see all for showType All,Movies,Tv Shows, Shorts");
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        testReport.log(LogStatus.INFO, "API Path and Parameters - " + params);
        Response res = given().log().all()
                .header("content-type", "application/json")
                .queryParam("queryString", params.get("queryString"))
                .queryParam("showType", typeName)
                .queryParam("max", 3000)
                .when()
                .get(params.get("ENDPOINT"));

        apiResponse = res.getBody().asString();
        testSearchSeeAllId3 = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));
        Assert.assertEquals(testSearchSeeAllId3, true);

    }

    @Test(dataProvider = "typeSection", enabled = false)
    public void searchV2SeeAllId4(String typeName, Method method) {
        testReport.log(LogStatus.INFO, "Global V2 Search see all for showType All,Movies,Tv Shows, Shorts");
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        testReport.log(LogStatus.INFO, "API Path and Parameters - " + params);
        Response res = given().log().all()
                .header("content-type", "application/json")
                .queryParam("queryString", params.get("queryString"))
                .queryParam("showType", typeName)
                .queryParam("max", 3000)
                .when()
                .get(params.get("ENDPOINT"));

        apiResponse = res.getBody().asString();
        testSearchSeeAllId4 = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));
        Assert.assertEquals(testSearchSeeAllId4, true);
    }

    @Test
    public void autoCompleteV1(Method method) {
        testReport.log(LogStatus.INFO, "Global V2 Search see all for showType All,Movies,Tv Shows, Shorts");
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        Response res = given().log().all()
                .header("content-type", "application/json")
                .queryParam("queryString", params.get("queryString"))
                .when()
                .get(params.get("ENDPOINT"));

        apiResponse = res.getBody().asString();
        testAutoCompleteV1 = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));
        Assert.assertEquals(testAutoCompleteV1, true);

    }

    @Test
    public void autoCompleteV2(Method method) {
        testReport.log(LogStatus.INFO, "Global V2 Search see all for showType All,Movies,Tv Shows, Shorts");
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        Response res = given().log().all()
                .header("content-type", "application/json")
                .queryParam("queryString", params.get("queryString"))
                .when()
                .get(params.get("ENDPOINT"));

        apiResponse = res.getBody().asString();
        testAutoCompleteV2 = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));
        Assert.assertEquals(testAutoCompleteV2, true);

    }

    @Test
    public void kidsAutoComplete(Method method) {
        testReport.log(LogStatus.INFO, "Global V2 Search see all for showType All,Movies,Tv Shows, Shorts");
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        Response res = given().log().all()
                .header("content-type", "application/json")
                .queryParam("queryString", params.get("queryString"))
                .when()
                .get(params.get("ENDPOINT"));

        apiResponse = res.getBody().asString();
        testKidsAutoCompleteV1 = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));
        Assert.assertEquals(testKidsAutoCompleteV1, true);
    }

    @Test
    public void fetchKidsContentType(Method method) {
        testReport.log(LogStatus.INFO, "Global V2 Search see all for showType All,Movies,Tv Shows, Shorts");
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());

        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        Response res = given().log().all()
                .header("content-type", "application/json")
                .when()
                .get(params.get("ENDPOINT") + params.get("queryString"));

        apiResponse = res.getBody().asString();
        System.out.println(apiResponse);
        testFetchKidsContentType = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));
        Assert.assertEquals(testFetchKidsContentType, true);
    }

    @Test(dataProvider = "typeSectionNew")
    public void regularRecommendation(String typeNameNew, Method method) {
        testReport.log(LogStatus.INFO, "Global V2 Search see all for showType All,Movies,Tv Shows, Shorts");
        if (Utility.checkRunStatus(testData, this, method) == false)
            throw new SkipException("skipping the test case : "
                    + method.getName().toString());
        params = Utility.getRequestParams(data.get(method.getName()).get("PARAMS"));
        Response responseGetId = given().log().all()
                .header("content/type", "application/json")
                .when()
                .get("/homescreen/pub/api/v1/page/" + Utility.getTypeNameNew(typeNameNew))
                .then()
                .extract().response();
        String newId = responseGetId.getBody().asString();
        JsonPath js = new JsonPath(newId);
        Integer getValue = js.get("data.items[0].contentList[0].id");
        System.out.println(getValue);

        Response res = given().log().all()
                .header("content/type", "application/json")
                .when()
                .get(params.get("ENDPOINT") + getValue + "/" + typeNameNew);
        apiResponse = res.getBody().asString();
        testregularRecommendation = Utility.checkApiKeys(apiResponse, data.get(method.getName()).get("API_KEYS"));
        System.out.println(apiResponse);

    }

    @DataProvider(name = "typeSection")
    public Object[][] typeSection() {
        Object[][] typeName = {{"All"}
                , {"Movies"},
                {"TV Shows"},
                {"Shorts"}};
        return typeName;
    }

    @DataProvider(name = "typeSectionNew")
    public Object[][] typeSectionNew() {
        Object[][] typeNameNew = {{"MOVIES"}, {"WEB_SHORTS"}, {"TV_SHOWS"}, {"LIVE"}};
        return typeNameNew;
    }


    @AfterMethod
    public void tearDown() {

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
        System.out.println("Testing..... " + DataSetter.getPresentApiKeys()
                + DataSetter.getNotPresentApiKeys());
    }
}

