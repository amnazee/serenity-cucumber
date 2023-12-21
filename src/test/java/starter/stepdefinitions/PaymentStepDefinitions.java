package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.targets.IFrame;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import starter.payment.PaymentDetails;

import static java.lang.Thread.*;
import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.waits.WaitUntil.the;
import static starter.payment.PaymentPage.*;

public class PaymentStepDefinitions {
    @Given("at the Payment Page")
    public void atThePaymentPage() {
        theActorInTheSpotlight().attemptsTo(
                Switch.toFrame(0)
        );
    }
    @When("enters the payment details into the form")
    public void entersThePaymentDetailsIntoTheForm() {
        theActorInTheSpotlight().attemptsTo(
                PaymentDetails.addDetails()
        );
    }
    @Then("payment is successful")
    public void paymentIsSuccessful() {
    }
}
