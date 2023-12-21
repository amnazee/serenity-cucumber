package starter.cart;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.junit.Assert;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static starter.cart.CartPage.PAY_BUTTON;
import static starter.moisturizers.MoisturizerPage.CART_BUTTON;

public class GetCartData {
   public static Performable cartData(){
       return Task.where("{0} gets the items in the cart",
               actor -> {
           String cart_value = CART_BUTTON.resolveFor(theActorInTheSpotlight()).getText();
           System.out.println("Cart Value: " + cart_value);
           Assert.assertEquals("Cart - 2 item(s)", cart_value);
       });
   }
}
