package com.sysco.qe_assignment_dasun.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static java.lang.Thread.sleep;

public class CheckoutPage  extends  PageBase{

    private By lblCityValidationMsg =  By.xpath
            ("//input[@name='city']/following-sibling::div/span[contains(text(),'This is a required field.')]");

    private By lblPostCodeValidationMsg =  By.xpath
            ("//input[@name='postcode']/following-sibling::div/span[contains(text(),'This is a required field.')]");

    private By txtStreetOne = By.name("street[0]");
    private By txtPostCode = By.name("postcode");

    private By txtPhoneNumber = By.name("telephone");

    private String xpathPostcode = "//input[@name='postcode']/following-sibling::ul/li[_INDEX]/a";

    private By lblPhoneValidationMsg =  By.xpath
            ("//input[@name='telephone']/following-sibling::div/span[contains(text(),'This is a required field.')]");

    private By lblRegionValidationMsg =  By.xpath
            ("//select[@name='region_id']/following-sibling::div/span[contains(text(),'This is a required field.')]");

    private By txtFirstName = By.name("firstname");
    private By txtLastName = By.name("lastname");

    private By btnContinue = By.xpath("//div[@class='opc-submit-step']/button");

    public boolean isCityValidationMessageDisplayed()
    {

        return syscoLabUIOgm.isDisplayed(lblCityValidationMsg);
    }

    public boolean isPhoneValidationMessageDisplayed()
    {

        return syscoLabUIOgm.isDisplayed(lblPhoneValidationMsg);
    }

    public void typeInStreetOne(String street)
    {
        syscoLabUIOgm.sendKeys(txtStreetOne,street);
    }

    public boolean isPostCodeValidationMessageDisplayed()
    {

        return syscoLabUIOgm.isDisplayed(lblPostCodeValidationMsg);
    }

    public boolean isRegionValidationMessageDisplayed()
    {

        return syscoLabUIOgm.isDisplayed(lblRegionValidationMsg);
    }

    public void typeAndSelectPostCode(String postcode,String index) throws InterruptedException
    {

        syscoLabUIOgm.sendKeys(txtPostCode,postcode);
        syscoLabUIOgm.waitTillElementLoaded(By.xpath(xpathPostcode.replace("_INDEX", index)));
        syscoLabUIOgm.click(By.xpath(xpathPostcode.replace("_INDEX", index)));

        sleep(5000);
    }

    public void typeInPhoneNumber (String phonenumber)
    {
        syscoLabUIOgm.sendKeys(txtPhoneNumber,phonenumber);
    }


    public String getFirstName()
    {

      return   syscoLabUIOgm.getAttribute(txtFirstName,"value");

    }

    public String getLastName()
    {
       return   syscoLabUIOgm.getAttribute(txtLastName,"value");
    }

    public void clickContinue()
    {
         syscoLabUIOgm.click(btnContinue);
    }
}
