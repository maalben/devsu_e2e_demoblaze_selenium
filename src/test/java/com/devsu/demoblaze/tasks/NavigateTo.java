package com.devsu.demoblaze.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {

    public static Performable signUpPage(String url) {
        return Task.where("{0} opens the demoblaze page",
                Open.url(url));
    }
}
