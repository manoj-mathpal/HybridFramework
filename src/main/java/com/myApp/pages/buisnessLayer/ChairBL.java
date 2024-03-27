package com.myApp.pages.buisnessLayer;

import com.myApp.pages.corePages.ChairPage;
import org.testng.Assert;

public class ChairBL {

    /***
     This is the Business layer class, where we will verify the Business logic.
     Meaning will be doing all the assertions here rather than in test class which will make
     our code look more modular, reusable and understandable.
     ***/

    private ChairPage chairPageObject = new ChairPage();

    public ChairBL openFlipKartAndAddOfficeChairToCart(String url){
        chairPageObject
                .goToWebPage(url)
                .navigateToOfficeChairs()
                .addOfficeChairToCart();
        return this;
    }

    public void verifyOfficeChairIsAddedToCart(){
        boolean isOfficeChairAddedInCart = chairPageObject
                .navigateToCart()
                .verifyOfficeChairIsDisplayedInCart();
        Assert.assertEquals(isOfficeChairAddedInCart, true);
        if(isOfficeChairAddedInCart){
            String getOfficeChairText = chairPageObject
                    .verifyOfficeChairIsAddedToCart();
            Assert.assertEquals(getOfficeChairText,"");
        }
    }
}
