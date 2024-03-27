package com.myApp.testData;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter @Data
public class TestData {
    private Object payload;
    private String url;
    private long thresholdTime;
    private String schemaFile;
    private String  testCaseName;
}
