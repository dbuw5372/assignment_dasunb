package com.sysco.qe_assignment_dasun.pages;

import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

/**
 * Created by Rifad on 5/21/18.failed to change window state to maximize
 */
public class LoginPage extends PageBase{

    private By btnLogin = By.id("send2");

    private By lblEmailValidation = By.id("email-error");

    private By lblPassWordValidation = By.id("pass-error");

    private By txtEmail = By.id("email");

    private By txtPassword = By.id("pass");


    public static void loadLoginPage(Capabilities capabilities, String url) {
        syscoLabUIOgm = new SyscoLabWUI(capabilities);
        syscoLabUIOgm.navigateTo(url);
        syscoLabUIOgm.driver.manage().window().maximize();
    }

    public boolean isLoginButtonDisplayed()
    {
       return  syscoLabUIOgm.isDisplayed(btnLogin);
    }

    public void clickLoginButton()
    {
        syscoLabUIOgm.click(btnLogin);

    }



    public void typeInEmail(String email)
    {
        syscoLabUIOgm.sendKeys(txtEmail,email);
    }

    public void typeInPassword(String password)
    {
        syscoLabUIOgm.sendKeys(txtPassword,password);
    }

    public boolean isEmailValidationDisplayed()
    {
        return  syscoLabUIOgm.isDisplayed(lblEmailValidation);
    }

    public boolean isPasswordValidationDisplayed()
    {
        return  syscoLabUIOgm.isDisplayed(lblPassWordValidation);
    }



}
