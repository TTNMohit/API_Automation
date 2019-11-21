package models.ott_frontend.request.continueWatching;

import utils.Utility;

import java.util.HashMap;

public class UnitTestCaseClass {

    static String testRequestParam = "subscriberId:3000943856,profileId:2f6176b8-d347,abc:123#@";

    public static void main(String[] args) {

        testRequestParamMethod(testRequestParam);
    }

    public static boolean testRequestParamMethod(String str) {

        boolean result = false;
        HashMap<String, String> hm = Utility.getRequestParams(str);
        System.out.println(hm.get("abc"));
        return result;
    }
}
