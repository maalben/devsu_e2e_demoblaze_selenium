package com.devsu.demoblaze.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.assertj.core.api.SoftAssertions;
import java.util.List;
import static com.devsu.demoblaze.ui.BuyProductsPage.*;
import static com.devsu.demoblaze.util.Constants.TIME_WAIT_EXPLICIT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

@Subject("Validation purchase performed successfully")
public class TheData implements Question<Boolean> {

    private SoftAssertions validate = new SoftAssertions();
    private List<String> dataPurchase;

    public TheData(List<String> dataPurchase) {
        this.dataPurchase = dataPurchase;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        boolean result = false;

        actor.attemptsTo(WaitUntil.the(POPUP_PURCHASE_PERFORMED, isVisible()).forNoMoreThan(TIME_WAIT_EXPLICIT).seconds());

        if(POPUP_PURCHASE_PERFORMED.resolveFor(actor).isVisible()){
            result = true;

            validate.assertThat(Text.of(LABEL_MESSAGE_PURCHASE_SUCCESSFUL).viewedBy(actor).asString()).isEqualTo(dataPurchase.get(6));
            validate.assertThat(Text.of(CONTENT_PURCHASE_SUCCESSFUL).viewedBy(actor).asString()).contains(dataPurchase.get(0));
            validate.assertThat(Text.of(CONTENT_PURCHASE_SUCCESSFUL).viewedBy(actor).asString()).contains(dataPurchase.get(3));

            validate.assertAll();
        }

        return result;
    }

    public static TheData purchase(List<String> dataPurchase) {
        return new TheData(dataPurchase);
    }
}
