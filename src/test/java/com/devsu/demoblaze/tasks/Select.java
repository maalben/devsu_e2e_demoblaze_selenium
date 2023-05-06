package com.devsu.demoblaze.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import static com.devsu.demoblaze.ui.BuyProductsPage.LABEL_PRICE_PRODUCT_MAIN_PAGE;
import static com.devsu.demoblaze.ui.BuyProductsPage.PRODUCT_NAME;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Select implements Task {

    private List<String> myProducts;

    public Select(List<String> myProducts) {
        this.myProducts = myProducts;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Integer> priceProducts = new ArrayList<>();
        for (String productName : myProducts)
        {
            if(PRODUCT_NAME.of(productName).resolveFor(actor).isVisible()){
                String valuePriceMainPage = LABEL_PRICE_PRODUCT_MAIN_PAGE.of(productName).resolveFor(actor).getText().split(Pattern.quote("$"))[1];
                priceProducts.add(Integer.parseInt(valuePriceMainPage));
                actor.attemptsTo(BuyProcess.product(productName));
            }
        }
        actor.remember("listPriceSelected", priceProducts);
    }

    public static Select products(List<String> myProducts) {
        return instrumented(Select.class, myProducts);
    }

}
