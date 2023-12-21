package starter.payment;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import static starter.payment.PaymentPage.*;

public class PaymentDetails {
    public static Performable addDetails() {
        return Task.where("{0} enter the card details",
                Enter.keyValues("amna@gmail.com").into(EMAIL),
                Enter.theValue("4000056655665556").into(CARD_NUMBER),
                Enter.theValue("02/24").into(DATE),
                Enter.keyValues("333").into(CVC)
        );
    }
}