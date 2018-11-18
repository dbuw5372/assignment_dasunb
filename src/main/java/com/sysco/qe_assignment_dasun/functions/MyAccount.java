package com.sysco.qe_assignment_dasun.functions;

import com.sysco.qe_assignment_dasun.pages.MyAccountPage;

public class MyAccount {

    public static MyAccountPage myAccount = new MyAccountPage();

    public static  String getLoggedInName()
    {
       return myAccount.getLoggenInName();
    }

    public  static  boolean isCartCounterDisplayed()
    {
        return  myAccount.isCartCounterDisplayed();
    }



    public static  void clickCartIcon()
    {
        myAccount.clickCartIcon();
    }

    public static void quiteDriver() {
        myAccount.quitDriver();
    }
}
