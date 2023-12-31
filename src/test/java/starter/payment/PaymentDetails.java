package starter.payment;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PaymentDetails implements Task{
    @Override
    public <T extends Actor> void performAs(T t) {
        WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('email').value='amna@gmail.com';");
        js.executeScript("document.getElementById('card_number').value='4242424242424242';");
        js.executeScript("document.getElementById('cc-exp').value='04/24';");
        js.executeScript("document.getElementById('cc-csc').value='333';");
    }

    public static PaymentDetails paymentDetails() {
        return instrumented(PaymentDetails.class);
    }
}