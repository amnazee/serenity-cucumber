package starter.payment;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static starter.payment.PaymentPage.SUBMIT_BUTTON;
import static starter.payment.PaymentPage.ZIP_CODE;

public class WaitForHiddenFieldToAppear {
    public static Performable waitUntilHiddenFieldAppears() {
        return Task.where(
                actor -> {
                    WaitUntil.the(ZIP_CODE, isVisible()).forNoMoreThan(20).seconds();
                }
        );
    }
}
