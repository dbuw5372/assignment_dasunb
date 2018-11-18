package com.sysco.qe_assignment_dasun.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductDetailPage extends PageBase {

    private By lblItemPrice = By.xpath("//span[@class='price-container price-final_price tax weee']");

    private By lblItemName = By.xpath("//div/h1");

    private By btnAddToCart = By.xpath("//button[@title='Add to Cart']");

    private String xpathSize = "//div[ text()='_SIZE']";


    public String getItemPrice()
    {
        return syscoLabUIOgm.getText(lblItemPrice);
    }

    public String getItemName()
    {
        return  syscoLabUIOgm.getText(lblItemName);
    }

    public List<WebElement> getSizes(String size)
    {
        return  syscoLabUIOgm.findElements(By.xpath(xpathSize.replace("_SIZE",size)));
    }

    public void clickAddtoCart()
    {
        syscoLabUIOgm.click(btnAddToCart);
    }

}
