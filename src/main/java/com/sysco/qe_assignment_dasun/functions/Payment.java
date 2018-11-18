package com.sysco.qe_assignment_dasun.functions;

import com.sysco.qe_assignment_dasun.pages.PaymentsPage;

public class Payment
{
    public static PaymentsPage payment  =  new PaymentsPage();

    public static boolean isPaymentinforDisplayed()
    {
        return  payment.isPaymentinforDisplayed();
    }

    public static  void selectPayementTypeCard()
    {
        payment.selectCardPaymentType();
    }

    public static void typeInCreditcardNumber(String creditcardNumber)
    {
        payment.typeInCreditcardNumber(creditcardNumber);
    }

    public static void clickPlaceOrderbutton()
    {
        payment.clickPlaceOrderbutton();
    }

    public static boolean isCreditcardValidationMessageDisplayed()
    {
        return  payment.isCreditcardValidationMessageDisplayed();
    }
}
