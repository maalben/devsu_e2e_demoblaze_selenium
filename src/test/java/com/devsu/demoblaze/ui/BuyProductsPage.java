package com.devsu.demoblaze.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BuyProductsPage {

    public static final Target PRODUCT_NAME = Target
            .the("product name")
            .locatedBy("//h4[@class='card-title']//*[contains(text(),'{0}')]");

    public static final Target LABEL_PRICE_PRODUCT_MAIN_PAGE = Target
            .the("label price product main page")
            .locatedBy("//h4[@class='card-title']//*[contains(text(),'{0}')]//following::h5[1]");

    public static final Target LABEL_PRICE_PRODUCT_DETAIL_PAGE = Target
            .the("label price product detail page")
            .locatedBy("//h3[contains(text(),'{0}')]");

    public static final Target BUTTON_ADD_CART = Target
            .the("button add cart")
            .located(By.xpath("//*[text()='Add to cart']"));

    public static final Target LINK_CART = Target
            .the("Link cart")
            .located(By.id("cartur"));

    public static final Target LINK_HOME = Target
            .the("link home")
            .located(By.xpath("//*[text()='Home ']"));

    public static final Target LIST_PRODUCTS_NAME_CART = Target
            .the("list products name cart")
            .located(By.xpath("//tbody//td[2]"));

    public static final Target LIST_PRODUCTS_PRICE_CART = Target
            .the("list products price cart")
            .located(By.xpath("//tbody//td[3]"));

    public static final Target LABEL_TOTAL_BUY = Target
            .the("Label total buy")
            .located(By.id("totalp"));

    public static final Target BUTTON_FILL_FORM = Target
            .the("button fill form")
            .located(By.xpath("//*[text()='Place Order']"));

    public static final Target NAME = Target
            .the("name")
            .located(By.id("name"));

    public static final Target COUNTRY = Target
            .the("country")
            .located(By.id("country"));

    public static final Target CITY = Target
            .the("city")
            .located(By.id("city"));

    public static final Target CREDIT_CARD = Target
            .the("credit card")
            .located(By.id("card"));

    public static final Target MONTH = Target
            .the("month")
            .located(By.id("month"));

    public static final Target YEAR = Target
            .the("year")
            .located(By.id("year"));

    public static final Target BUTTON_PURCHASE = Target
            .the("button purchase")
            .located(By.xpath("//*[text()='Purchase']"));

    public static final Target POPUP_PURCHASE_PERFORMED = Target
            .the("popup purchase performed")
            .located(By.xpath("//div[@class='sweet-alert  showSweetAlert visible']"));

    public static final Target LABEL_MESSAGE_PURCHASE_SUCCESSFUL = Target
            .the("label message purchase successful")
            .located(By.xpath("//div[@class='sweet-alert  showSweetAlert visible']//h2"));

    public static final Target CONTENT_PURCHASE_SUCCESSFUL = Target
            .the("content purchase successful")
            .located(By.xpath("//p[@class='lead text-muted ']"));

}
