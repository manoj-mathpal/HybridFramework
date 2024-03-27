package com.myApp.service;

import com.myApp.controller.ElectronicsInventoryController;
import com.myApp.testData.TestData;

public class ElectronicsInventoryService {
    private ElectronicsInventoryController controller;
    public ElectronicsInventoryService() {controller = new ElectronicsInventoryController();}




    public ElectronicsInventoryService verifyPositiveCaseForAddInventory(TestData testdata){
        controller.validatePositiveFlowsForAddInventory(testdata);
        return this;

    }


    public ElectronicsInventoryService verifyPositiveCaseForGetElectronicsInventory(TestData testdata) {
        controller.validatePositiveFlowsForGetAllInventory(testdata);
        return this;
    }
}
