package utils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentHandler {

    public static Properties property = null;
    static String baseUrl = null;
    static String reportPath = null;
    static File directory = new File(".");

    public static String getBaseUrl() {
        BaseClass oBaseClass = new BaseClass();
        property = oBaseClass.initPropFromFile("config.properties");

        System.out.println("Inside getBaseurl method");
        System.out.println("The suite file name is ------------: " + System.getProperty("suiteName"));

        // can be uat+ta
        if (System.getProperty("suiteName").toLowerCase().equals("ta.xml")) {
            // get the usecases
        } else if (System.getProperty("suiteName").toLowerCase().equals("atv")) {
            // set url according to environements
            if (System.getProperty("env").toLowerCase().equals("uat")) {
                baseUrl = property.getProperty("ATV_UAT_BASE_URL");
                System.out.println("Following the desired flow");
                System.out.println("maven params is : " + System.getProperty("env"));
            } else if (System.getProperty("env").toLowerCase().equals("prod")) {
                baseUrl = property.getProperty("ATV_PROD_BASE_URL");
            }
        } else if (System.getProperty("suiteName").toLowerCase().equals("ott.xml")) {
            if (System.getProperty("env").toLowerCase().equals("uat")) {
                baseUrl = property.getProperty("OTT_UAT_BASE_URL");
            } else if (System.getProperty("env").toLowerCase().equals("prod")) {
                baseUrl = property.getProperty("OTT_PROD_BASE_URL");
            } else if (System.getProperty("env").toLowerCase().equals("ecs-qa")) {
                baseUrl = property.getProperty("OTT_ECS_QA_BASE_URL");
            }
        }
        return baseUrl;
    }

    public static String getReportPath() throws IOException {
        // TA + UAT
        String[] strArr = System.getProperty("suiteName").replace(".", "-").split("-");
        String folderName = strArr[0];
        if (System.getProperty("suiteName").toLowerCase().equals("atv")) {
            System.out.println("Following the desired report flow");
            reportPath = directory.getCanonicalPath() + File.separator
                    + "AutomationReport"
                    + File.separator
                    + folderName
                    + File.separator
                    + "AutomationReport_"
                    + System.getProperty("env") + ".html";
        }
        if (System.getProperty("suiteName").toLowerCase().equals("ott.xml")) {
            reportPath = directory.getCanonicalPath() + File.separator
                    + "AutomationReport"
                    + File.separator
                    + folderName
                    + File.separator
                    + "AutomationReport_"
                    + System.getProperty("env") + ".html";
        }
        return reportPath;
    }

    public static String getBaseUrl(String suiteName, String environment) {

        BaseClass oBaseClass = new BaseClass();
        property = oBaseClass.initPropFromFile("config.properties");

        System.out.println("Environement handler - suite name : " + suiteName);

        // can be uat+ta
        if (suiteName.toLowerCase().equals("atv.xml")) {
            // set url according to environements
            if (environment.toLowerCase().equals("uat")) {
                baseUrl = property.getProperty("ATV_UAT_BASE_URL");
            } else if (environment.toLowerCase().equals("prod")) {
                baseUrl = property.getProperty("ATV_PROD_BASE_URL");
            }
        } else if (suiteName.toLowerCase().equals("ott.xml")
                || suiteName.toLowerCase().equals("ta.xml")) {
            if (environment.toLowerCase().equals("uat")) {
                baseUrl = property.getProperty("OTT_UAT_BASE_URL");
            } else if (environment.toLowerCase().equals("prod")) {
                baseUrl = property.getProperty("OTT_PROD_BASE_URL");
            } else if (environment.toLowerCase().equals("ecs-qa")) {
                baseUrl = property.getProperty("OTT_ECS_QA_BASE_URL");
            }
        }
        return baseUrl;
    }

    public static String getReportPath(String suiteName, String environment) throws IOException {
        // TA + UAT
        String folderName = null;
        if (System.getProperty("suiteName") == null) {
            folderName = "local_run";

        } else {
            String[] strArr = System.getProperty("suiteName").replace(".", "-").split("-");
            folderName = strArr[0];
            //folderName.toUpperCase();
        }


        if (suiteName.toLowerCase().equals("atv.xml")) {
            System.out.println("Following the desired report flow");
            reportPath = directory.getCanonicalPath() + File.separator
                    + "AutomationReport"
                    + File.separator
                    + folderName
                    + File.separator
                    + "atv_Report_"
                    + environment + ".html";
        } else if (suiteName.toLowerCase().equals("ott.xml")) {
            reportPath = directory.getCanonicalPath() + File.separator
                    + "AutomationReport"
                    + File.separator
                    + folderName
                    + File.separator
                    + "ott_Report_"
                    + environment + ".html";
        } else if (suiteName.toLowerCase().equals("ta.xml")) {
            reportPath = directory.getCanonicalPath() + File.separator
                    + "AutomationReport"
                    + File.separator
                    + folderName
                    + File.separator
                    + "ta_Report_"
                    + environment + ".html";
        }
        return reportPath;
    }

}
