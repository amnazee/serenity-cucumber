package starter.stepdefinitions;

import com.ibm.icu.impl.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import starter.checktemperature.HomePageButtons;
import starter.checktemperature.LookAtTemperature;
import starter.checktemperature.TemperatureChecker;
import starter.checktemperature.TemperatureIcon;
import starter.moisturizers.MoisturizerPage;
import starter.navigation.NavigateTo;

public class TemperatureStepDefinitions {

    @Given("{actor} is at Weather Shopper website")
    public void max_is_at_weather_shopper_website(Actor actor) {
        actor.wasAbleTo(NavigateTo.theWeatherShopperHomePage());
    }

    @When("{actor} sees the temperature displayed")
    public void max_sees_the_temperature_displayed(Actor actor) {
        String temperature= TemperatureIcon.TEMPERATURE_ICON.resolveFor(actor).getText();
        String numericPart = temperature.replaceAll("[^0-9]", "");
        System.out.println(numericPart);
        actor.remember("Temperature", numericPart);
    }

    @Then("{actor} decides what category to choose as he sees temperature")
    public void maxDecidesWhatCategoryToChooseAsHeSees(Actor actor) {
        String temperature= actor.recall("Temperature");
        System.out.println(temperature+ " temperature is ");
        TemperatureChecker.checkTemperature(temperature);
    }
}