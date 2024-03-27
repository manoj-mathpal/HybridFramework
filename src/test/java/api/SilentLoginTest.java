package api;


import com.myApp.core.EndPoints;
import org.testng.annotations.Test;
import com.myApp.testData.TestData;
import com.myApp.dataProviders.CustomDataProvider;

import java.io.IOException;
public class SilentLoginTest {

    private SilentLoginService silentLoginService;
    private String token;
    public SilentLoginTest(){silentLoginService=new SilentLoginService();}

    @Test(dataProvider = "dataProvider", dataProviderClass = CustomDataProvider.class)
    public void silentLogin(TestData testData) throws IOException {
       token=silentLoginService.verifySilentLogin(testData.getPayload() , EndPoints.silentLoginEndPoint,Long.valueOf(testData.getThresholdTime()),testData.getSchemaFile(),testData.getTestCaseName());
    }

    @Test(dataProvider = "dataProvider", dataProviderClass = CustomDataProvider.class,dependsOnMethods = "silentLogin")
    public void verifyToken(TestData testData) throws IOException {
        silentLoginService.verifyToken(testData.getPayload() , EndPoints.verifyTokenEndPoint,Long.valueOf(testData.getThresholdTime()),testData.getSchemaFile(),testData.getTestCaseName(),token);
    }
}
