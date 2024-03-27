package com.myApp.pages.corePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChairPage extends BasePage {

    /****CLASS***
     This is the Page class, there can be different pages in an application,this class will
     extend the BasePage class. This class will contain all the required web elements of this
     page and methods to automate end to end flows.
    */

    /****MULTIPLE WAYS TO USE LOCATORS***
     Other ways to initialize locators
    * 1.By using page factory more specific way
    * 2.Using By locator : can be useful for doing multiple actions on a web element
     *
    @FindBy(how = How.XPATH, using = "//*[text()='Home & Furniture']")
    private WebElement homeAndFurnitureLocator;
    Syntax written downside in the defined methods.
    *********************************************************************************
    private By homeAndFurnitureLocator = By.xpath("//*[text()='Home & Furniture']");
    or By.id(), By.cssSelector(), By.linkText();
    Syntax when using By:
    driver.findElement(homeAndFurnitureLocator).click(); and to get location of element,
    position, take screenshots, check element is present, displayed, waits, get attribute...
    */

    @FindBy(xpath = "//*[text()='Home & Furniture']")
    private WebElement homeAndFurnitureLocator;
    @FindBy(xpath = "//*[text()='Bedroom Furniture']")
    private WebElement bedroomFurnitureLocator;
    @FindBy(xpath = "//*[text()='Office Chairs']")
    private WebElement officeChairLocator;
    @FindBy(linkText = "SAVYA HOME Apollo HBCB Mesh Office Executive Chair")
    private WebElement chairLocator;
    @FindBy(xpath = "//*[text()='Office Chairs']")
    private WebElement cartButtonLocator;
    @FindBy(xpath = "//*[text()='Office Chairs']")
    private WebElement chairOnCartLocator;

    public ChairPage(){
        PageFactory.initElements(driver, ChairPage.class);
    }

    @Override
    public ChairPage goToWebPage(String url) {
        super.goToWebPage(url);
        return this;
    }

    public ChairPage navigateToOfficeChairs(){
        homeAndFurnitureLocator.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(bedroomFurnitureLocator).build().perform();
        return this;
    }

    public ChairPage addOfficeChairToCart(){
        officeChairLocator.click();
        chairLocator.click();
        return this;
    }

    public ChairPage navigateToCart(){
        cartButtonLocator.click();
        return this;
    }

    public String verifyOfficeChairIsAddedToCart(){
        return chairOnCartLocator.getText();
    }

    public boolean verifyOfficeChairIsDisplayedInCart(){
        return chairOnCartLocator.isDisplayed();
    }
}
