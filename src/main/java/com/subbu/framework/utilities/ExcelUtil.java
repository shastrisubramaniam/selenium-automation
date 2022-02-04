package com.subbu.framework.utilities;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ExcelUtil {
    static final String inputFile = "C:\\Users\\Subramaniam\\IdeaProjects\\Automation\\Automation_TestData.xlsx";
    static String emailaddress;
public ExcelUtil()
{

}
public String read() throws IOException {
    XSSFWorkbook w;
    try {
        w = new XSSFWorkbook(new File(inputFile));
        // Get the first sheet
        XSSFSheet sheet = w.getSheet("Sheet1");
        Iterator rowIterator = sheet.iterator();

        // Traversing over each row of XLSX file
        while (rowIterator.hasNext()) {
            Row row = (Row)rowIterator.next();

            // For each row, iterate through each columns
            Iterator cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {

                Cell cell = (Cell)cellIterator.next();
                emailaddress = cell.toString();

            }

        }
    }
    catch (Exception e) {
        e.printStackTrace();
    }

        return emailaddress;

                    }


}

