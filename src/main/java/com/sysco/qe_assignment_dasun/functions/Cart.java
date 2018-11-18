package com.sysco.qe_assignment_dasun.functions;

import com.sysco.qe_assignment_dasun.pages.CartPage;
import com.sysco.qe_assignment_dasun.pages.alerts.RemoveItemConfirmationAlert;
import com.sysco.qe_assignment_dasun.pages.panels.CartPanel;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.Thread.sleep;

public class Cart {

    public  static CartPanel cartPanel = new CartPanel();
    public static CartPage cartPage =  new CartPage();
    public  static RemoveItemConfirmationAlert removeAlert = new RemoveItemConfirmationAlert();

    public static  void removeItemsFromCartIfExists() throws InterruptedException {

        while (MyAccount.isCartCounterDisplayed())
        {
            MyAccount.clickCartIcon();
            sleep(3000);
            List<WebElement> items = cartPanel.getRemoveIcons();
            for (WebElement item : items)
            {
                item.click();
                sleep(5000);
                removeAlert.clickOk();
                break;
            }
        }
    }

   public static String getProductPrice()
   {
       return  cartPanel.getProductPrice();
   }

    public static  String getProductName()
    {
        return  cartPanel.getProductname();
    }

    public static void clickProceedTocheckout()
    {
        cartPanel.clickProceedtoCheckout();
    }
}
