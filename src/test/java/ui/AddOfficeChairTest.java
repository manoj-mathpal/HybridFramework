package ui;

import org.testng.annotations.Test;
import com.myApp.pages.buisnessLayer.ChairBL;

public class AddOfficeChairTest {

    /****CLASS***
     Main Test Class
     */

    @Test(threadPoolSize = 1, invocationCount = 1)
    public void addChairToCartInFlipkart(){
        new ChairBL()
                    .openFlipKartAndAddOfficeChairToCart("")
                    .verifyOfficeChairIsAddedToCart();
    }
}
