package utils;

import java.util.ArrayList;
import java.util.List;

public class DataSetter {

    static String testMessage = "";
    static long epgId = -1;
    static StringBuilder presentkeys = new StringBuilder();
    static StringBuilder notPresentApiKeys = new StringBuilder();


    // code for setting and getting the non present api keys
    public static void setNotPresentApiKeys(String key)
    {
        notPresentApiKeys.append(key + ",");
    }
    public static StringBuilder getNotPresentApiKeys()
    {
        return notPresentApiKeys;
    }
    public static void clearNotPresentApiKeys()
    {
        notPresentApiKeys = new StringBuilder();
    }

    // code for setting and getting the present api keys
    public static void setPresentApiKeys(String key)
    {
        presentkeys.append(key + ",");
    }
    public static StringBuilder getPresentApiKeys()
    {
        return presentkeys;
    }
    public static void clearPresentApiKeys()
    {
        presentkeys = new StringBuilder();
    }

    public static void setMessage(String message)
    {
        testMessage = message;
    }

    public static String getTestMessage()
    {
        return testMessage;
    }

/*    public void clearList(SubscriberList<String> list)
    {
        list.clear();
    }*/

    public static long getEpgId()
    {
        return epgId;
    }

    public static void setEpgId(long id)
    {
        epgId = id;
    }

}
