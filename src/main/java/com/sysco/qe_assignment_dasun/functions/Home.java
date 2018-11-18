package com.sysco.qe_assignment_dasun.functions;

import com.sysco.qe_assignment_dasun.common.Constants;
import com.sysco.qe_assignment_dasun.pages.HomePage;
import com.sysco.qe_assignment_dasun.pages.LoginPage;
import com.sysco.qe_assignment_dasun.pages.panels.CategoryPanel;
import com.sysco.qe_assignment_dasun.utils.DriverSetUpUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;

public class Home {

    public static HomePage homePage =  new HomePage();
    public static CategoryPanel categoryPanel  =  new CategoryPanel();

    public static void loadHomePage()
    {
        if (Constants.RUN_LOCALLY) {
            DriverSetUpUtil.setToRunLocally();
            DesiredCapabilities capabilities = null;
            homePage.loadHomePage(capabilities, Constants.APP_URL);
        } else {
            homePage.loadHomePage(DriverSetUpUtil.setToRunRemotely(Constants.APP_OS), Constants.APP_URL);
        }
    }

    public  static LoginPage navigateToLoginScreen()
    {
        return homePage.navigateToLoginScreen();
    }



    public static void quiteDriver()
    {
        homePage.quitDriver();
    }

    public static  void navigateToGivenCategory(String category)
    {
        categoryPanel.clickGivenCategory(category);
    }

    public static  void navigateToSubcategory(String category)
    {
        List<WebElement> categories = categoryPanel.getSubcategroies(category);
        for (WebElement categorylink: categories)
        {
            try {
                categorylink.click();
                break;
            }
            catch (Exception e){}
        }
    }
}
