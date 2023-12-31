package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.*;
import starter.payment.Confirmation;
import starter.payment.PaymentDetails;
import starter.payment.PaymentScreenplayTask;
import starter.payment.WaitForHiddenFieldToAppear;

import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static starter.payment.PaymentPage.*;

public class PaymentStepDefinitions {
    @Given("at the Payment Page")
    public void atThePaymentPage() {
        theActorInTheSpotlight().attemptsTo(
                Switch.toFrame(0)
        );
    }
    @When("enters the payment details into the form")
    public void entersThePaymentDetailsIntoTheForm(Map<String, String> paymentDetails) {
//                PaymentDetails.paymentDetails(),
            theActorInTheSpotlight().attemptsTo(new PaymentScreenplayTask(paymentDetails)
//        WaitForHiddenFieldToAppear.waitUntilHiddenFieldAppears().then(Click.on(SUBMIT_BUTTON))
        );
    }
    @Then("payment is successful")
    public void paymentIsSuccessful() throws InterruptedException {
        Thread.sleep(2000);
        theActorInTheSpotlight().attemptsTo(
                Switch.toDefaultContext(),
                Confirmation.confirmation()
        );
}}