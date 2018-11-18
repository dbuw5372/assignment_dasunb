package com.sysco.qe_assignment_dasun.pages;

import org.openqa.selenium.By;

public class PaymentsPage extends  PageBase {

    private By lblPaymentInfo = By.xpath("//form/fieldset/legend");

    private By rdioBtnPayment = By.xpath("//div[@class='payment-method-title field choice']/label/ul");

    private By checkboxAddress = By.xpath("//div[@class='billing-address-same-as-shipping-block field choice']/label");

    private By txtCreditCard = By.id("credit-card-number");

    private By btnPlaceOrder = By.xpath("//div[@class='opc-submit-step']/button");

    private By lblCreditCardValidationMessage =
            By.xpath("//div[@class='hosted-error']/span[contains(text(),'Please, enter valid Credit Card Number')]");

    public boolean isPaymentinforDisplayed()
    {
       return syscoLabUIOgm.isDisplayed(lblPaymentInfo);
    }

    public void selectCardPaymentType()
    {
        syscoLabUIOgm.click(rdioBtnPayment);


    }

    public void typeInCreditcardNumber(String creditcardNumber)
    {
        syscoLabUIOgm.switchToFrame(By.id("braintree-hosted-field-number"));
        syscoLabUIOgm.sendKeys(txtCreditCard,creditcardNumber);
    }

    public void clickPlaceOrderbutton()
    {
        syscoLabUIOgm.switchToDefaultFrame();
        syscoLabUIOgm.click(btnPlaceOrder);
    }

    public boolean isCreditcardValidationMessageDisplayed()
    {
        //syscoLabUIOgm.switchToDefaultFrame();
      return    syscoLabUIOgm.isDisplayed(lblCreditCardValidationMessage);
    }

}
