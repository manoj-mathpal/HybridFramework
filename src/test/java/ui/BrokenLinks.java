package ui;

import com.myApp.core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class BrokenLinks extends BaseTest {


    public void findBrokenLinks(){
        String pageURL = "http://www.interviewbit.com";
        HttpURLConnection huc = null;
        int responseCode = 200;
        List<WebElement> links = driver.findElements(By.tagName("a"));

        Iterator<WebElement> it = links.iterator();
        while(it.hasNext()){
            String url = it.next().getAttribute("href");
            System.out.println(url);
            if(url == null || url.isEmpty()){
                System.out.println("The linked element has invalid href url.");
                continue;
            }
            if(!url.startsWith(pageURL)){
                System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }
            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());
                huc.setRequestMethod("HEAD");
                huc.connect();
                responseCode = huc.getResponseCode();
                if(responseCode >= 400){
                    System.out.println(url+" is a broken link");
                }
                else{
                    System.out.println(url+" is a valid link");
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        driver.quit();
    }
}
