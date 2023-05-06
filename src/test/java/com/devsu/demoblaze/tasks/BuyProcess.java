package com.devsu.demoblaze.tasks;

import com.devsu.demoblaze.interactions.AlertPass;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import java.util.List;
import static com.devsu.demoblaze.ui.BuyProductsPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class BuyProcess {

    public static Performable product(String productName) {

        return Task.where("{0} select the product '" + productName + "'",
                WaitUntil.the(PRODUCT_NAME.of(productName), isClickable()).forNoMoreThan(10).seconds(),
                Click.on(PRODUCT_NAME.of(productName)),
                WaitUntil.the(BUTTON_ADD_CART, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(BUTTON_ADD_CART),
                AlertPass.process(),
                Click.on(LINK_HOME));
    }

    public static Performable showCart() {
        return Task.where("{0} click under Cart link ",
                Click.on(LINK_CART));
    }

    public static Performable fillFormPurchase(List<String> dataPurchase) {
        return Task.where("{0} fill form purchase",
                Click.on(BUTTON_FILL_FORM),
                Clear.field(NAME),
                Enter.theValue(dataPurchase.get(0)).into(NAME),
                Clear.field(COUNTRY),
                Enter.theValue(dataPurchase.get(1)).into(COUNTRY),
                Clear.field(CITY),
                Enter.theValue(dataPurchase.get(2)).into(CITY),
                Clear.field(CREDIT_CARD),
                Enter.theValue(dataPurchase.get(3)).into(CREDIT_CARD),
                Clear.field(MONTH),
                Enter.theValue(dataPurchase.get(4)).into(MONTH),
                Clear.field(YEAR),
                Enter.theValue(dataPurchase.get(5)).into(YEAR),
                Click.on(BUTTON_PURCHASE));
    }
}
