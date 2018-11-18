package com.sysco.qe_assignment_dasun.pages;

import org.openqa.selenium.By;

public class MyAccountPage extends PageBase {

    private By lblLoggedInName =  By.xpath("//li[@class='greet welcome']");

    private By lblCartCounter = By.xpath("//span[@class='counter qty']");

    private By  btnCart  = By.xpath("//div[@class='minicart-wrapper']");


    public String getLoggenInName()
    {
      return   syscoLabUIOgm.getText(lblLoggedInName);
    }

    /** Cart counter does not display when number of items in cartPanel is zero **/
    public boolean isCartCounterDisplayed()
    {

       return syscoLabUIOgm.isDisplayed(lblCartCounter);
    }

    public  void clickCartIcon()
    {
        syscoLabUIOgm.click(btnCart);
    }
}
