package com.myApp.core;

import java.io.File;

public class JsonFilePath {

    public static File[] params;


    public static String silentLoginJson = "src/test/resources/jsonFiles/collections/silentLogin.json";
    public static String getElectronicsInventory = "src/test/resources/jsonFiles/collections/getElectronicsInventory.json";

    public static String postElectronicsInventory = "src/test/resources/jsonFiles/collections/postElectronicsInventory.json";
    public static String fileName;

    public static String getFilePath(){
        System.out.println("FILEPATHIS >>>> " + fileName);
        return JsonFilePath.fileName.toString();
    }

}


