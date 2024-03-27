package com.myApp.pages.platforms.web;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.myApp.pages.corePages.LandingPage;

public class WebLandingPage extends LandingPage {

    @FindBy(how = How.ID, using = "user1")
    String usernameField;
    @FindBy(how = How.ID, using = "pass")
    String passwordField;
    @FindBy(how = How.ID, using = "signin")
    String loginButton;


    @Override
    public boolean login(String username, String password) {

        return super.login(username, password);
    }
}
