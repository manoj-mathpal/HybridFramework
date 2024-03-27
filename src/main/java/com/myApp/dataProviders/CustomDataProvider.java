package com.myApp.dataProviders;


import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import com.myApp.testData.TestData;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class CustomDataProvider {

    @DataProvider(name = "dataProvider")
    public static Object[][] getTestData(Method method) throws IOException {
        List<TestData> testData;

        String[] params  = Arrays.toString(method.getAnnotationsByType(Parameters.class)).split(String.valueOf('"'));
        String filePath = System.getProperty("user.dir").concat("/src/test/resources/jsonFiles/collections/"+params[1]);
        Object[][] returnValue =null;
                testData = new Gson().fromJson(new JsonParser().parse(new FileReader(filePath)).getAsJsonObject().get("com/myApp/testData"), new TypeToken<List<TestData>>() {
                }.getType());
                returnValue = new Object[testData.size()][1];
                int index = 0;
                for (Object[] each : returnValue) {
                    each[0] = testData.get(index++);
                }
                return returnValue;
    }
}
