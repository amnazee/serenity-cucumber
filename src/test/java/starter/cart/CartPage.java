package starter.cart;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.junit.Assert;
import static starter.moisturizers.MoisturizerPage.CART_BUTTON;

public class CartPage {
    public static Performable getCartValue(){
        return Task.where("{0} gets the cart value",
                actor -> {
                    String cart_value = CART_BUTTON.resolveFor(actor).getText();
                    System.out.println("Cart Value: " + cart_value);
                    Assert.assertEquals("Cart - 2 item(s)",cart_value);
                });
    }
}