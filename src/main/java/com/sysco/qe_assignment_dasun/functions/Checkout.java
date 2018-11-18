package com.sysco.qe_assignment_dasun.functions;

import com.sysco.qe_assignment_dasun.pages.CheckoutPage;

public class Checkout  {
    public static CheckoutPage checkout  =  new CheckoutPage();

    public static String  getFirstname()
    {
        return checkout.getFirstName();
    }

    public static String  getLastname()
    {
        return checkout.getLastName();
    }

    public static void clickContinueButton()
    {
        checkout.clickContinue();
    }

    public  static boolean isCityValidationDisplayed()
    {

       return checkout.isCityValidationMessageDisplayed();
    }

    public  static boolean isPhoneValidationDisplayed()
    {
        return checkout.isPhoneValidationMessageDisplayed();
    }

    public  static boolean isRegionValidationDisplayed()
    {
        return checkout.isRegionValidationMessageDisplayed();
    }

    public  static boolean isPostCodeValidationDisplayed()
    {
        return checkout.isPostCodeValidationMessageDisplayed();
    }

    public  static void typeAndSelectPostCode(String postcode,String index) throws InterruptedException
    {
         checkout.typeAndSelectPostCode(postcode, index);
    }

    public static  void typeinPhoneNumber (String phoneNumber)
    {
        checkout.typeInPhoneNumber(phoneNumber);
    }

    public static void typeInStreetOne(String street)
    {
        checkout.typeInStreetOne(street);

    }
}
