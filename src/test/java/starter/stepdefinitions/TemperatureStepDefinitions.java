package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import starter.checktemperature.LookAtTemperature;
import starter.navigation.NavigateTo;

public class TemperatureStepDefinitions {
    @Given("{actor} is at Weather Shopper website")
    public void max_is_at_weather_shopper_website(Actor actor) { actor.wasAbleTo(NavigateTo.theWeatherShopperHomePage()); }
    @When("{actor} sees the temperature displayed")
    public void max_sees_the_temperature_displayed(Actor actor) {
        actor.wasAbleTo(LookAtTemperature.temperature());
    }
    @Then("{actor} decides what category to choose")
    public void max_decides_what_category_to_choose(Actor actor) {
        
        throw new io.cucumber.java.PendingException();
    }
}
