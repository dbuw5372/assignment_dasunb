package com.sysco.qe_assignment_dasun.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends PageBase {

    private By productListing =  By.xpath("//div/img[@class='product-image-photo']");

    public List<WebElement> getProducts()
    {
       return   syscoLabUIOgm.findElements(productListing);
    }
}
