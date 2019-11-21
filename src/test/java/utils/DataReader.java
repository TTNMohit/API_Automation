package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import com.jayway.restassured.RestAssured;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {

    public static int runCycle = 1;
    public static String environment = null;
    public static String currentSuiteName = null;
    public static HashMap<String, HashMap<String, String>> testSheetData = new HashMap<String, HashMap<String, String>>();
    public static HashMap<String, HashMap<String, HashMap<String, String>>> testData = new HashMap<String, HashMap<String, HashMap<String, String>>>();

    DataFormatter formatter = new DataFormatter();

    public void initiateData(Properties property) throws IOException {
        int numberOfSheets;

        File file = null;
        // changes to handle different environment data sheets

        if (environment == null) {
            file = new File("testdata" + File.separator + property.getProperty("ECS_QA_DATASHEET"));
        } else if (environment.equalsIgnoreCase("PROD")) {
            file = new File("testdata" +
                    File.separator + property.getProperty("PROD_DATASHEET"));
        } else if (environment.equalsIgnoreCase("UAT")) {
            file = new File("testdata" +
                    File.separator + property.getProperty("UAT_DATASHEET"));
        } else if (environment.equalsIgnoreCase("STAGING")) {
            file = new File("testdata" +
                    File.separator + property.getProperty("STAGING_DATASHEET"));
        } else if (environment.equalsIgnoreCase("ECS_QA")) {
            file = new File("testdata" +
                    File.separator + property.getProperty("ECS_QA_DATASHEET"));
        }

        FileInputStream inputStr = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStr);
        numberOfSheets = workbook.getNumberOfSheets();
        for (int i = 0; i < numberOfSheets; i++) {
            XSSFSheet sheet = workbook.getSheetAt(i);
            testSheetData = readDataSheet(sheet);
            testData.put(workbook.getSheetName(i), testSheetData);
        }
        workbook.close();

    }

    public HashMap<String, HashMap<String, String>> readDataSheet(Sheet sheet) {
        HashMap<String, HashMap<String, String>> data = new HashMap<String, HashMap<String, String>>();

        for (int rowNumber = 1; rowNumber <= sheet.getLastRowNum(); rowNumber++) {
            data.put(formatter.formatCellValue(sheet.getRow(rowNumber).getCell(0)),
                    getRowData(sheet, rowNumber));
        }
        return data;
    }

    public HashMap<String, String> getRowData(Sheet sheet, int rowNumber) {
        Row headerRow = sheet.getRow(0);
        HashMap<String, String> rowData = new HashMap<String, String>();
        for (int columnNumber = 1; columnNumber < sheet.getRow(rowNumber)
                .getLastCellNum(); columnNumber++) {
            rowData.put(formatter.formatCellValue(headerRow.getCell(columnNumber)), formatter.formatCellValue(sheet
                    .getRow(rowNumber).getCell(columnNumber)));
        }
        return rowData;
    }
}
