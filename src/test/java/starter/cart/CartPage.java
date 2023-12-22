package starter.cart;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import static starter.moisturizers.MoisturizerPage.CART_BUTTON;

public class CartPage extends PageObject {
    public static final Target CHECKOUT_HEADING=Target.the("Checkout Heading").locatedBy("//div//tbody//td");
    public static final Target PAY_BUTTON=Target.the("Pay Button").locatedBy("//button[@class='stripe-button-el']");
    public static final Target ITEMS= Target.the("Items").locatedBy("//tbody//tr//td");
    public static final Target TOTAL=Target.the("Total Price").locatedBy("//p[@id='total']");
}
