package com.sysco.qe_assignment_dasun.pages.panels;

import com.sysco.qe_assignment_dasun.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CategoryPanel extends PageBase {

    private String xpathCategory = "//a[@title='_CATEGORY']";

    public void clickGivenCategory(String category)
    {
        syscoLabUIOgm.click(By.xpath(xpathCategory.replace("_CATEGORY",category)));
    }

    public List<WebElement> getSubcategroies(String category)
    {
       return syscoLabUIOgm.findElements(By.xpath(xpathCategory.replace("_CATEGORY",category)));
    }
}
