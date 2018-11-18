package com.sysco.qe_assignment_dasun.tests;


import com.sysco.qe_assignment_dasun.functions.Home;
import com.sysco.qe_assignment_dasun.functions.Login;
import com.sysco.qe_assignment_dasun.functions.MyAccount;
import com.sysco.qe_assignment_dasun.testdata.LoginTestData;
import com.sysco.qe_assignment_dasun.utils.TestBase;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static java.lang.Thread.sleep;


public class LoginTest extends TestBase {



    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Online Shopping - Login");
    }

    @AfterClass
    public void closeDriver()
    {
        MyAccount.quiteDriver();
    }


    @Test(description = " | TestCase 001 | Verify Availability of Login Button")
    public void verifyAvailabilityofLoginButton() {

        // Sample way to retrive data from excel
       // LoginData loginData = ExcelUtil.getLoginData("$as238l");

        Home.loadHomePage();
        Home.navigateToLoginScreen();
        Assert.assertTrue(Login.isLoginButtonDisplayed(),"Login button not displayed");


    }

    @Test(description = "| TestCase 002 | Verify Login Validations",dependsOnMethods = "verifyAvailabilityofLoginButton")
    public void verifyLoginValidations()
    {
         softAssert =  new SoftAssert();
         Login.clickLoginButton();
         softAssert.assertTrue(Login.isEmailValidationDisplayed(),"Email Validation not displayed");
         softAssert.assertTrue(Login.isPasswordValidationDisplayed(),"Password validation not displayed");
         softAssert.assertAll();
    }

    @Test(description = "| TestCase 003 | Verify Valid Login",dependsOnMethods = "verifyLoginValidations")
    public void  verifyValidLogin()
    {
        Login.validLogin(LoginTestData.EMAIL,LoginTestData.PASSWORD);
        Assert.assertEquals(MyAccount.getLoggedInName(),LoginTestData.LOGGED_IN_NAME);
    }


}