package com.sysco.qe_assignment_dasun.tests;

import com.sysco.qe_assignment_dasun.data.ProductData;
import com.sysco.qe_assignment_dasun.functions.*;
import com.sysco.qe_assignment_dasun.testdata.CategoryTestData;
import com.sysco.qe_assignment_dasun.testdata.LoginTestData;
import com.sysco.qe_assignment_dasun.utils.TestBase;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static java.lang.Thread.sleep;

public class CheckoutTest extends TestBase {
    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Online Shopping - Checkout");

        //Load application
        Home.loadHomePage();

        //Navigate to login screen
        Home.navigateToLoginScreen();

        //Perform valid login
        Login.validLogin(LoginTestData.EMAIL,LoginTestData.PASSWORD);
    }

    @AfterClass
    public void closeDriver()
    {
        MyAccount.quiteDriver();
    }

    @Test(description = " | TestCase 004 | Verify Remove items from cartPanel if exists")
    public void removeItemsFromCartifExists () throws InterruptedException
    {

        Cart.removeItemsFromCartIfExists();

        /** Cart counter does not display when number of items in cartPanel is zero **/
        Assert.assertFalse( MyAccount.isCartCounterDisplayed());
    }

    @Test(description = " | TestCase 005 | Verify add item to cart",dependsOnMethods = "removeItemsFromCartifExists")
    public void addItemToCart() throws InterruptedException
    {
        softAssert = new SoftAssert();

        Home.navigateToGivenCategory(CategoryTestData.CATEGORY_MENS);
        sleep(3000);
        Home.navigateToSubcategory(CategoryTestData.SUB_CATEGORY_WALK);
        Product.selectARandomProduct();

        //Saving product information
        ProductData productdata =  new ProductData();
        productdata.setProductname(Product.getItemName());
        productdata.setProductPrice(Product.getItemPrice());

        Product.selectASize("5");
        Product.clickAddToCart();
        MyAccount.clickCartIcon();

        sleep(5000);
        softAssert.assertEquals(Cart.getProductPrice(),productdata.getProductPrice());
        softAssert.assertEquals(Cart.getProductName(),productdata.getProductname());
        softAssert.assertAll();


    }

    @Test(description = " | TestCase 006 | Verify first and last name in checkout page",dependsOnMethods = "addItemToCart")
    public void verifyNameInCheckout()
    {
        softAssert = new SoftAssert();
        Cart.clickProceedTocheckout();

        softAssert.assertEquals(Checkout.getFirstname().trim(),LoginTestData.FIRST_NAME);
        softAssert.assertEquals(Checkout.getLastname().trim(),LoginTestData.LAST_NAME);
        softAssert.assertAll();
    }

    @Test(description = " | TestCase 009 | Verify checkout page mandatory fields validations",dependsOnMethods = "verifyNameInCheckout")
    public void verifyCheckoutPageValidations() throws InterruptedException
    {
        softAssert = new SoftAssert();



        Checkout.clickContinueButton();
        sleep(6000);
        softAssert.assertTrue(Checkout.isCityValidationDisplayed(),
                "City validation message not displayed");

        softAssert.assertTrue(Checkout.isPhoneValidationDisplayed(),
                "Phone validation message not displayed");

        softAssert.assertTrue(Checkout.isPostCodeValidationDisplayed(),
                "Post Code validation message not displayed");

        softAssert.assertTrue(Checkout.isRegionValidationDisplayed(),
                "Region validation message not displayed");

        softAssert.assertAll();

    }



    @Test(description = " | TestCase 007 | Verify fill valid data and proceed to payment",dependsOnMethods = "verifyCheckoutPageValidations")
    public void verifyProceedtoPayment() throws InterruptedException
    {
        Checkout.typeinPhoneNumber("111111111");
        Checkout.typeAndSelectPostCode("2000","2");
        sleep(3000);
        Checkout.typeInStreetOne("01 Test Street");
        Checkout.clickContinueButton();
        sleep(10000);
        Assert.assertTrue(Payment.isPaymentinforDisplayed(),"PAYMENT INFORMATION");
    }

    @Test(description = " | TestCase 008 | Verify credit card field validation",dependsOnMethods = "verifyProceedtoPayment")
    public void verifyCreditCard() throws InterruptedException
    {
        Payment.selectPayementTypeCard();
        sleep(5000);
        Payment.typeInCreditcardNumber("657%^&rtiu");
        Payment.clickPlaceOrderbutton();
        Assert.assertTrue(Payment.isCreditcardValidationMessageDisplayed());

    }



}
