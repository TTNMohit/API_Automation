package utils;

import com.jayway.restassured.RestAssured;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseClass extends DataReader {

    /*public static String environment;*/

    public HashMap<String, HashMap<String, String>> data;
    public static String test;
    public static String url;
    public static File directory = new File(".");
    public static Properties ENV = null;
    public static ExtentReports extent;
    public static ExtentTest testReport;
    public final static Logger log = Logger.getLogger(BaseClass.class);
    //public Properties property = null;
    public static Properties property = null;
    static String reportPath = "";

    @BeforeSuite
    public void beforeSuite(ITestContext context) throws IOException {


        String suite = System.getProperty("suiteName");
        System.out.println("testing---- " + suite);
        property = initPropFromFile("config.properties");
        if (context.getCurrentXmlTest().getSuite().getName().toLowerCase().contains("default")) {
            setupLocalEnvironment(context);
        }

        // set the suite file name
        else {
            if (System.getProperty("env") == null) {
                // if user runs a single suite via testng.xml
                setEnvironment(property.getProperty("LOCAL_ENV"));
            } else {
                setEnvironment(System.getProperty("env"));
                environment = getEnvironment();
            }

            setSuiteFileName(getSuiteFileName(context));
        }

        // setting up the base URI and report path
        RestAssured.baseURI = EnvironmentHandler.getBaseUrl(currentSuiteName, environment);
        reportPath = EnvironmentHandler.getReportPath(currentSuiteName, environment);

        // reading the entire test data from excel sheets
        initiateData(property);

        //PropertyConfigurator.configure(".//properties/log4j.properties");

        PropertyConfigurator.configure("properties" +
                File.separator + "log4j.properties");

        /*if (!currentSuiteName.toLowerCase().equals("all")
                || runCycle == 1) {
            extent = new ExtentReports(reportPath, true);

            try {

                String extentConfigPath = directory.getCanonicalPath()
                        + File.separator + "extent-config.xml";
                extent.loadConfig(new File(extentConfigPath));
                runCycle++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        extent = new ExtentReports(reportPath, true);

        try {

            String extentConfigPath = directory.getCanonicalPath()
                    + File.separator + "extent-config.xml";

            extent.loadConfig(new File(extentConfigPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method, ITestContext context) {
        System.out.println("Testing........  " + method.getName());
        //System.out.println("Testing........  " + context.getClass().getMeth);
        testReport = extent.startTest(
                (this.getClass().getSimpleName() + " :: " + method.getName()),
                method.getName());

    }

    @AfterMethod(alwaysRun = true)
    protected void afterMethod(ITestResult result, Method method)
            throws IOException {

        //System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>afterMethod");
        if (result.getStatus() == ITestResult.FAILURE) {

            testReport.log(LogStatus.FAIL, DataSetter.getTestMessage() + result.getThrowable());

            System.out.println("testing" + result.getThrowable());

        } else if (result.getStatus() == ITestResult.SKIP) {

            testReport.log(LogStatus.SKIP,
                    "Test skipped " + result.getThrowable());
        } else

        {
            testReport.log(LogStatus.PASS, "Test passed");

        }
        extent.endTest(testReport);
        // extent.flush();
    }


    @AfterSuite(alwaysRun = true)
    protected void afterSuite() {
        // extent.endTest(testReport);
        extent.flush();
    }


    public Properties initPropFromFile(String filename) {
        // if (ENV == null) {

        Properties temp = new Properties();
        try {
            FileInputStream fs = new FileInputStream(
                    System.getProperty("user.dir") + File.separator + "properties"
                            + File.separator //properties//"
                            + filename);
            temp.load(fs);

        } catch (Exception e) {
        }

        return temp;
    }

    public static String getSuiteFileName(ITestContext context) {
        // get the suite file name at run time and print it.
        String filePath = context.getCurrentXmlTest().getSuite().getFileName();
        System.out.println("File path is" + filePath);
        String[] strArr = filePath.split("/");
        System.out.println("getSuiteMethod - suite name : " + strArr[strArr.length - 1]);
        return strArr[strArr.length - 1];
    }

    public static void setSuiteFileName(String suiteFileName) {

        currentSuiteName = suiteFileName;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setupLocalEnvironment(ITestContext context) {

        List<ITestNGMethod> allMethods = context.getSuite().getAllMethods();

        for (ITestNGMethod method : allMethods) {

            String qualifiedPackageName = method.getQualifiedName().toLowerCase();
            if (qualifiedPackageName.contains("atv_api")) {
                currentSuiteName = "atv.xml";
            } else if (qualifiedPackageName.contains("ott_frontend")) {
                currentSuiteName = "ott.xml";
            }
            else if (qualifiedPackageName.contains("ta"))
            {
                currentSuiteName = "ta.xml";
            }
            setEnvironment(property.getProperty("LOCAL_ENV"));
        }
    }

}

