package com.devsu.demoblaze.interactions;

import com.devsu.demoblaze.util.Utilities;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class AlertPass implements Interaction {

    public static AlertPass process() {
        return new AlertPass();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Utilities.waitOwn(3);
        BrowseTheWeb.as(actor).getAlert().accept();
    }
}
