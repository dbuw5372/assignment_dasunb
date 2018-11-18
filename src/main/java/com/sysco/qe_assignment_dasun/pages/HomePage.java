package com.sysco.qe_assignment_dasun.pages;

import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

public class HomePage extends PageBase {

    private By lnkLogin = By.xpath("//a[text()='Login']");

    public  void loadHomePage(Capabilities capabilities, String url) {
        syscoLabUIOgm = new SyscoLabWUI(capabilities);
        syscoLabUIOgm.navigateTo(url);
        syscoLabUIOgm.driver.manage().window().maximize();

    }

    public LoginPage navigateToLoginScreen()
    {
        syscoLabUIOgm.click(lnkLogin);
        return  new LoginPage();
    }
}
