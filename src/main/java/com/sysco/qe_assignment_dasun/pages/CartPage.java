package com.sysco.qe_assignment_dasun.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import sun.jvm.hotspot.debugger.Page;

import java.util.List;

public class CartPage extends PageBase {

    private By btnremoveItem = By.xpath("//a[@title='Remove item']");

    public List<WebElement> getRemoveIcons()
    {
        return syscoLabUIOgm.findElements(btnremoveItem);
    }
}
