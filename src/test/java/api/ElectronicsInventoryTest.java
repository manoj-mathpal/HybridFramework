package api;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.myApp.service.ElectronicsInventoryService;
import com.myApp.testData.TestData;
import com.myApp.dataProviders.CustomDataProvider;

public class ElectronicsInventoryTest {

    private ElectronicsInventoryService service;
    public ElectronicsInventoryTest() {service = new ElectronicsInventoryService();}

    @Test(dataProvider = "dataProvider" , dataProviderClass = CustomDataProvider.class)
    @Parameters(value = "postElectronicsInventory.json")
    public void addInventoryTest(TestData testdata){
        service.verifyPositiveCaseForAddInventory(testdata);
    }

//    @Test(dataProvider = "dataProvider", dataProviderClass = CustomDataProvider.class)
//    @Parameters(value = "getElectronicsInventory.json")
//    public void verifyGetAllItemsTest(TestData testdata){
//        service.verifyPositiveCaseForAddInventory(testdata);
//    }


}
