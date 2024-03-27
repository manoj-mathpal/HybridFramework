package com.myApp.pages.corePages;

import com.myApp.pages.platforms.web.WebLandingPage;

public abstract class LandingPage extends BasePage {

    private  String Platform;
    public LandingPage() {

        switch (Platform) {

            case "ANDROID":
                System.out.println();

            case "iOS":
                System.out.println();

            case "Web":
               new WebLandingPage();

        }

    }

    public boolean login(String username, String password){
        return true;
    }


}
