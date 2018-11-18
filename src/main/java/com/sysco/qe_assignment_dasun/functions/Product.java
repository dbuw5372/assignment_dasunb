package com.sysco.qe_assignment_dasun.functions;

import com.sysco.qe_assignment_dasun.pages.ProductDetailPage;
import com.sysco.qe_assignment_dasun.pages.ProductsPage;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.WeakHashMap;

public class Product {

    public static ProductsPage products = new ProductsPage();

    public static ProductDetailPage productDetail = new ProductDetailPage();

    public static  void selectARandomProduct()
    {
        List<WebElement> productlinks = products.getProducts();
        for (WebElement productLink: productlinks)
        {
            try {
                productLink.click();
                break;
            }
            catch (Exception e){}
        }
    }

    public static String getItemPrice()
    {
        return productDetail.getItemPrice();
    }

    public static String getItemName()
    {
        return  productDetail.getItemName();
    }

    public static void selectASize(String size)
    {
        List<WebElement> sizes = productDetail.getSizes(size);
        for (WebElement sizeLink: sizes)
        {
            try {
                sizeLink.click();
                break;
            }
            catch (Exception e){}
        }
    }

    public static  void clickAddToCart()
    {
        productDetail.clickAddtoCart();
    }
}
