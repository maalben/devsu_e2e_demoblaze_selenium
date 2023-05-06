package com.devsu.demoblaze.features;

import com.devsu.demoblaze.asserts.ControlPointValidateName;
import com.devsu.demoblaze.asserts.ControlPointValidatePrice;
import com.devsu.demoblaze.asserts.ControlPointValidateTotalBuy;
import com.devsu.demoblaze.conf.BaseConf;
import com.devsu.demoblaze.questions.TheData;
import com.devsu.demoblaze.tasks.BuyProcess;
import com.devsu.demoblaze.tasks.Select;
import com.devsu.demoblaze.util.Utilities;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.ArrayList;
import java.util.List;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
@Narrative(title = "Purchase of products", text = {
        "As a customer I want to be able to purchase products.",
        "I want to validate that the purchase flow is correct."
})
@WithTag("@testFull")
public class BuyProductsTest extends BaseConf {

    @Test
    @Title("Purchase products in the system")
    @WithTagValuesOf("{@successFlow}")
    public void el_Usuario_Compra_Productos_De_Manera_Correcta() {

        List<String> myProducts = new ArrayList<>();
        myProducts.add("Samsung galaxy s6");
        myProducts.add("Iphone 6 32gb");
        myProducts.add("Nexus 6");

        List<String> dataPurchase = new ArrayList<>();
        dataPurchase.add("Juan de Arco");
        dataPurchase.add("Colombia");
        dataPurchase.add("Medellin");
        dataPurchase.add("4000 0000 0000 0002");
        dataPurchase.add("06");
        dataPurchase.add("27");
        dataPurchase.add("Thank you for your purchase!");

        actor.attemptsTo(Select.products(myProducts));
        actor.attemptsTo(BuyProcess.showCart());
        actor.should(seeThat(ControlPointValidateName.products(myProducts), equalTo(true)));
        actor.should(seeThat(ControlPointValidatePrice.products(actor.recall("listPriceSelected")), equalTo(true)));
        actor.should(seeThat(ControlPointValidateTotalBuy.products(Utilities.totalValuesList(actor.recall("listPriceSelected"))), equalTo(true)));
        actor.attemptsTo(BuyProcess.fillFormPurchase(dataPurchase));
        actor.should(seeThat(TheData.purchase(dataPurchase), equalTo(true)));
    }
}











