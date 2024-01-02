package starter.payment;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class PaymentScreenplayTask implements Task {
    private final Map<String, String> paymentDetails;
    public PaymentScreenplayTask(Map<String, String> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        {
            WebDriver driver = BrowseTheWeb.as(actor).getDriver();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value = arguments[1];", PaymentPage.EMAIL.resolveFor(actor), paymentDetails.get("Email"));
            js.executeScript("arguments[0].value = arguments[1];", PaymentPage.CARD_NUMBER.resolveFor(actor), paymentDetails.get("Card Number"));
            js.executeScript("arguments[0].value = arguments[1];", PaymentPage.DATE.resolveFor(actor), paymentDetails.get("Expiration Date"));
            js.executeScript("arguments[0].value = arguments[1];", PaymentPage.CVC.resolveFor(actor), paymentDetails.get("CVC"));
            Click.on(PaymentPage.SUBMIT_BUTTON).performAs(actor);
        }
    }
}