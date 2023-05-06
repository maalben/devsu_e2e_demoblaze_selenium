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
import static com.devsu.demoblaze.ui.BuyProductsPage.LIST_PRODUCTS_NAME_CART;

@Subject("Control point for validate name products selected")
public class ControlPointValidateName implements Question<Boolean> {

    private WebDriver driver;
    private List<String> listProductNameSelected;
    public ControlPointValidateName(List<String> listProductNameSelected) {
        this.listProductNameSelected = listProductNameSelected;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        driver = BrowseTheWeb.as(actor).getDriver();
        List<WebElement> valuesWebElement;
        List<String> listProductNameListed = new ArrayList<>();
        valuesWebElement = driver.findElements(By.xpath(LIST_PRODUCTS_NAME_CART.resolveFor(actor).toString().split(":")[1].trim()));

        for(WebElement element : valuesWebElement){
            listProductNameListed.add(element.getText());
        }

        Collections.sort(listProductNameSelected);
        Collections.sort(listProductNameListed);

        return Arrays.equals(listProductNameSelected.toArray(), listProductNameListed.toArray());
    }

    public static ControlPointValidateName products(List<String> listProductNameSelected) {
        return new ControlPointValidateName(listProductNameSelected);
    }
}
