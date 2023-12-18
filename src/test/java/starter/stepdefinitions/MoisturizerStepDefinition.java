package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.cart.CartPage;
import starter.moisturizers.GetTitle;
import starter.moisturizers.SelectMoisturizerTask;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static starter.moisturizers.MoisturizerPage.*;

public class MoisturizerStepDefinition {
    @Given("{actor} is at Product Page and the title is {string} or {string}")
    public void maxIsAtProductPage(Actor actor, String expectedTitle1, String expectedTitle2) {
        actor.attemptsTo(
                GetTitle.getTitle(expectedTitle1, expectedTitle2)
        );
    }
    @When("{actor} adds the least expensive product to the cart")
    public void theUserAddsTheLeastExpensiveProductToTheCart(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(MOISTURIZER_PRODUCTS, isVisible()).forNoMoreThan(10).seconds(),
                SelectMoisturizerTask.addMoisturizerToCart()
        );
    }
    @Then("{actor} clicks on the cart to complete the purchase")
    public void theUserClicksOnTheCartToCompleteThePurchase(Actor actor) {
    }
}