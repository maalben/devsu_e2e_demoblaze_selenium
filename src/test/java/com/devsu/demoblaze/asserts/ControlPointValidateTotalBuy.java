package com.devsu.demoblaze.asserts;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;
import static com.devsu.demoblaze.ui.BuyProductsPage.LABEL_TOTAL_BUY;
import static java.lang.Integer.parseInt;

@Subject("Control point for validate total purchase")
public class ControlPointValidateTotalBuy implements Question<Boolean> {

    private int totalPriceSelected;
    public ControlPointValidateTotalBuy(int totalPriceSelected) {
        this.totalPriceSelected = totalPriceSelected;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        return totalPriceSelected == parseInt(Text.of(LABEL_TOTAL_BUY).viewedBy(actor).asString());
    }

    public static ControlPointValidateTotalBuy products(int totalPriceSelected) {
        return new ControlPointValidateTotalBuy(totalPriceSelected);
    }
}
