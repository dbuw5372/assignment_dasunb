package com.sysco.qe_assignment_dasun.functions;

import com.sysco.qe_assignment_dasun.common.Constants;
import com.sysco.qe_assignment_dasun.pages.LoginPage;
import com.sysco.qe_assignment_dasun.utils.DriverSetUpUtil;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Rifad on 5/21/18.
 */
public class Login  {

    public static LoginPage loginPage = new LoginPage();


    public static void loadLoginPage() {

        if (Constants.RUN_LOCALLY) {
            DriverSetUpUtil.setToRunLocally();
            DesiredCapabilities capabilities = null;
            loginPage.loadLoginPage(capabilities, Constants.APP_URL);
        } else {
            loginPage.loadLoginPage(DriverSetUpUtil.setToRunRemotely(Constants.APP_OS), Constants.APP_URL);
        }
    }

    public static  boolean isLoginButtonDisplayed()
    {
        return loginPage.isLoginButtonDisplayed();
    }

    public static void  clickLoginButton()
    {
         loginPage.clickLoginButton();
    }

    public static void validLogin(String email, String password)
    {
        loginPage.typeInEmail(email);
        loginPage.typeInPassword(password);
        loginPage.clickLoginButton();
    }


    public  static  boolean isEmailValidationDisplayed()
    {
        return  loginPage.isEmailValidationDisplayed();
    }

    public  static  boolean isPasswordValidationDisplayed()
    {
        return  loginPage.isPasswordValidationDisplayed();
    }




    public static void quiteDriver() {
        loginPage.quitDriver();
    }

}
