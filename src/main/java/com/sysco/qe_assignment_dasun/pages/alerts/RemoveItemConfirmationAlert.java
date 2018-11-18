package com.sysco.qe_assignment_dasun.pages.alerts;

import com.sysco.qe_assignment_dasun.pages.PageBase;
import org.openqa.selenium.By;


public class RemoveItemConfirmationAlert extends PageBase {

    private By btnOk = By.xpath("//button[@class='action-primary action-accept button -secondary']");


    public void clickOk()
    {
        syscoLabUIOgm.click(btnOk);
        syscoLabUIOgm.refreshBrowser();
    }
}
