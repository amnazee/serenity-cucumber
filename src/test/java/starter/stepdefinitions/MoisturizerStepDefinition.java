package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.cart.CartPage;
import starter.moisturizers.GetTitle;
import starter.moisturizers.SelectMoisturizerTask;
import starter.sunscreens.SelectSunscreenTask;

import static net.serenitybdd.screenplay.actors.OnStage.theActor;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static starter.moisturizers.MoisturizerPage.*;

public class MoisturizerStepDefinition {
    @Given("{actor} is at Product Page and the title is {string} or {string}")
    public void maxIsAtProductPage(Actor actor, String expectedTitle1, String expectedTitle2) {
        actor.attemptsTo(
                GetTitle.getTitle(expectedTitle1, expectedTitle2)
        );
    }
    @When("adds the least expensive product to the cart")
    public void theUserAddsTheLeastExpensiveProductToTheCart() {
//        theActorInTheSpotlight().attemptsTo(
//                WaitUntil.the(MOISTURIZER_PRODUCTS, isVisible()).forNoMoreThan(10).seconds(),
//                SelectMoisturizerTask.addMoisturizerToCart(),
//                SelectSunscreenTask.addSunscreenToCart()
//        );

        String productType=TITLE.resolveFor(theActorInTheSpotlight()).getText();
        if(productType.equals("Moisturizers")){
            theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(MOISTURIZER_PRODUCTS, isVisible()).forNoMoreThan(10).seconds(),
                SelectMoisturizerTask.addMoisturizerToCart()
            );
        }
        else if(productType.equals("Sunscreens")){
//            System.out.println("Sunscreens");
            theActorInTheSpotlight().attemptsTo(
                    WaitUntil.the(MOISTURIZER_PRODUCTS, isVisible()).forNoMoreThan(10).seconds(),
                    SelectSunscreenTask.addSunscreenToCart()
            );
        }
        else{
            System.out.println("Invalid Product Type");
        }
    }
    @Then("clicks on the cart to complete the purchase")
    public void theUserClicksOnTheCartToCompleteThePurchase() throws InterruptedException {
        Thread.sleep(5000);
        theActorInTheSpotlight().attemptsTo(
                Click.on(CART_BUTTON)
        );
    }
}