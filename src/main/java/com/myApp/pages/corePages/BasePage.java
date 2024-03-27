package com.myApp.pages.corePages;

import com.myApp.core.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.Set;

public class BasePage extends BaseTest {

    /****CLASS***
     This is the Base Page class, it will contain all the helper methods that can be used
     to interact with different type of web elements in any page
     */

    public void maximizeWindow(){
        driver.manage().window().maximize();
    }

    public void switchTo(String str){
        driver.switchTo().frame(str);

    }

    public BasePage goToWebPage(String url){
        driver.get(url);
        return this;
    }

    public void deleteCookies(){
        driver.manage().deleteAllCookies();
    }

    public void implicitWait(int unitValue){
        driver.manage().timeouts().implicitlyWait(Duration.of(unitValue, ChronoUnit.SECONDS));
    }

    public void explicitWait(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void actionClassExecutor(){
        WebElement element = driver.findElement(By.xpath(""));
        Actions builder = new Actions(driver);
        Action seriesOfActions = builder
                .moveToElement(element)
                .click()
                .contextClick().build();
        seriesOfActions.perform();
    }

    public void javaScriptExecutor(){
        WebElement element = driver.findElement(By.xpath(""));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void switchWindow(){
        String parent=driver.getWindowHandle();
        Set<String> s = driver.getWindowHandles();
        Iterator<String> I1= s.iterator();
        while(I1.hasNext())
        {
            String child_window=I1.next();
            if(!parent.equals(child_window))
            {
                driver.switchTo().window(child_window);
                System.out.println(driver.switchTo().window(child_window).getTitle());
                driver.close();
            }
        }
        driver.switchTo().window(parent);
    }

    public void switchFrame(){
        WebElement fr = driver.findElement(By.xpath(""));
        driver.switchTo().frame(fr);
        driver.switchTo().defaultContent();
    }

    public void handleAlert(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
        alert.accept();
        driver.switchTo().alert().dismiss();
    }

}
