package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.targets.IFrame;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.waits.WaitUntilExpectation;
import net.thucydides.core.annotations.locators.WaitForWebElements;
import org.htmlunit.javascript.background.JavaScriptExecutor;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import starter.payment.Confirmation;
import starter.payment.PaymentDetails;
import starter.payment.WaitForHiddenFieldToAppear;

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
//        Thread.sleep(5000);
        theActorInTheSpotlight().attemptsTo(
                PaymentDetails.paymentDetails(),
                WaitForHiddenFieldToAppear.waitUntilHiddenFieldAppears().then(Click.on(SUBMIT_BUTTON))
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