package com.sysco.qe_assignment_dasun.pages.panels;


import com.sysco.qe_assignment_dasun.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPanel extends PageBase {

    private By btnremoveItem = By.xpath("//a[@title='Remove item']");

    private By btnViewCart = By.xpath("//div[@class='minicart-bottom']/div/a");

    private By lblProductName = By.xpath("//div[@class='minicart-product-details']/strong/a");

    private By lblProductPrice = By.xpath("//span[@class='price-including-tax']");

    private By btnProceedToCheckout = By.xpath("//div[@class='minicart-bottom']/div/button");

    public List<WebElement> getRemoveIcons()
    {
       return syscoLabUIOgm.findElements(btnremoveItem);
    }


    public String getProductname()
    {
        return syscoLabUIOgm.getText(lblProductName);
    }

    public String getProductPrice()
    {
        return  syscoLabUIOgm.getText(lblProductPrice);
    }

    public void clickProceedtoCheckout()
    {
        syscoLabUIOgm.click(btnProceedToCheckout);
    }
}
