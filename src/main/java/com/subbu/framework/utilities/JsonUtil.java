package com.subbu.framework.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;

public class JsonUtil {
    static final Logger logger = LogManager.getLogger("com.subbu.framework.utilities.JsonUtil.class");
    @DataProvider(name="JsonDataProvider")
    public static Object[][] JsonDataProvider() {
        Object[] data;
        JSONParser parser = new JSONParser();
        JSONObject jsonobj = null;
        try {
            Object obj = parser.parse(new FileReader("C:\\Users\\Subramaniam\\IdeaProjects\\Automation\\src\\main\\resources\\data.json"));
            jsonobj = (JSONObject) obj;
        }
        catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        if (jsonobj!=null) {
            data = new Object[jsonobj.keySet().toArray().length];
            /*for (int i=0;i < keys.length;i++ ) {
                data[i] =jsonobj.get(keys[i]);
                System.out.println(data[i]);
            }*/
            data[0] = jsonobj.get("strInput");
            data[1] = jsonobj.get("strCheckbox");
            data[2] = jsonobj.get("strRadio");
            data[3] = jsonobj.get("strDropdown");
            data[4] = jsonobj.get("strEmail");
            data[5] = jsonobj.get("strMessage");
            return new Object[][]{data};
        }
        else {
            logger.error("Error retrieving JSON data");
            throw new RuntimeException();
        }
    }

   /* public static void main(String[] args) {
        JsonUtil x = new JsonUtil();
        for (int i=0; i < x.JsonDataProvider().length;i++)
            System.out.println(x.JsonDataProvider()[i][i]);
    }*/
}
