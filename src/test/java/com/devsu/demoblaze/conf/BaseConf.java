package com.devsu.demoblaze.conf;

import com.devsu.demoblaze.tasks.NavigateTo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import static com.devsu.demoblaze.util.Constants.*;
import static java.lang.System.getProperty;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class BaseConf {
    protected static Actor actor;
    private EnvironmentVariables environmentVariables;

    @Managed
    WebDriver driver;

    @Before
    public void setTheStage() {

        OnStage.setTheStage(new OnlineCast());
        actor = theActorCalled(ACTOR);

        actor.can(BrowseTheWeb.with(driver));

        actor.attemptsTo(
                NavigateTo.signUpPage(environmentVariables.getProperty(ENVIRONMENT+getProperty("env")+BASE_URL)));
    }
}