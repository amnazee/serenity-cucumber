package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.awaitility.Awaitility;
import starter.payment.Confirmation;
import starter.payment.PaymentPage;
import starter.payment.PaymentScreenplayTask;

import java.time.Duration;
import java.util.Map;

import static java.security.AccessController.getContext;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.waits.WaitUntil.the;
import static starter.payment.PaymentPage.PAYMENT_SUCCESS;

public class PaymentStepDefinitions {
    @Given("at the Payment Page")
    public void atThePaymentPage() {
        theActorInTheSpotlight().attemptsTo(
                Switch.toFrame(0)
        );
    }
    @When("enters the payment details into the form")
    public void entersThePaymentDetailsIntoTheForm(Map<String, String> paymentDetails) {
            theActorInTheSpotlight().attemptsTo(new PaymentScreenplayTask(paymentDetails)
        );
    }
    @Then("payment is successful")
    public void paymentIsSuccessful() {
        theActorInTheSpotlight().attemptsTo(
                Switch.toDefaultContext(),
                WaitUntil.the(PAYMENT_SUCCESS, isVisible()).forNoMoreThan(10).seconds(),
                Confirmation.confirmation()
        );
    }
}