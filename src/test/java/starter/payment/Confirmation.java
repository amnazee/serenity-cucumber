package starter.payment;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static starter.payment.PaymentPage.PAYMENT_SUCCESS;

public class Confirmation {

    public static Performable confirmation(){
        return Task.where(actor -> {
            String heading="PAYMENT SUCCESS";
            assertTrue(PAYMENT_SUCCESS.resolveFor(actor).getText().contains(heading));
        });
    }
}
