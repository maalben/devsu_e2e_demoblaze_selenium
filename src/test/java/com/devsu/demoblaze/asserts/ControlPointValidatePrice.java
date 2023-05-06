package com.devsu.demoblaze.asserts;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.annotations.Subject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static com.devsu.demoblaze.ui.BuyProductsPage.LIST_PRODUCTS_PRICE_CART;
import static java.lang.Integer.parseInt;

@Subject("Control point for validate price products selected")
public class ControlPointValidatePrice implements Question<Boolean> {

    private WebDriver driver;
    private List<Integer> listPriceSelected;
    public ControlPointValidatePrice(List<Integer> listPriceSelected) {
        this.listPriceSelected = listPriceSelected;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        driver = BrowseTheWeb.as(actor).getDriver();
        List<WebElement> valuesWebElement;
        List<Integer> listPriceListed = new ArrayList<>();
        valuesWebElement = driver.findElements(By.xpath(LIST_PRODUCTS_PRICE_CART.resolveFor(actor).toString().split(":")[1].trim()));

        for(WebElement element : valuesWebElement){
            listPriceListed.add(parseInt(element.getText()));
        }

        Collections.sort(listPriceSelected);
        Collections.sort(listPriceListed);

        return Arrays.equals(listPriceSelected.toArray(), listPriceListed.toArray());
    }

    public static ControlPointValidatePrice products(List<Integer> listPriceSelected) {
        return new ControlPointValidatePrice(listPriceSelected);
    }
}
