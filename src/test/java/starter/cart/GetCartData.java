package starter.cart;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.junit.Assert;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static starter.cart.CartPage.CART_PRODUCTS;

public class GetCartData {
public static Performable cartData() {
    return Task.where("gets the items in the cart",
            actor -> {
                BrowseTheWeb.as(actor).evaluateJavascript("window.scrollTo(0, document.body.scrollHeight)");
                List<WebElementFacade> cartProductElements = CART_PRODUCTS.resolveAllFor(actor);
                System.out.println("No of Products: "+cartProductElements.size());
                int cart_value=cartProductElements.size();
                Assert.assertEquals(2, cart_value);
                // store item names and prices
                Map<String, String> itemMap = new HashMap<>();
                // Iterate through each product element and retrieve name and price
                for (int i = 0; i < cartProductElements.size(); i++) {
                    WebElementFacade productElement = cartProductElements.get(i);
//                    System.out.println("Row Content: " + productElement.getText());

                    String productNameXpath = String.format("//table//tbody/tr[%d]//td[1]", i + 1);
                    String productPriceXpath = String.format("//table//tbody/tr[%d]//td[2]", i + 1);

                    String productName = productElement.findBy(productNameXpath).getText();
                    String productPrice = productElement.findBy(productPriceXpath).getText();

                    itemMap.put(productName, productPrice);
                }
                // Print the retrieved item names and prices for myself to check what products are in the cart
                System.out.println("Items in the cart: " + itemMap.size());
                for (Map.Entry<String, String> entry : itemMap.entrySet()) {
                    System.out.println("Item Name: " + entry.getKey() + ", Product Price: " + entry.getValue());
                }
            });
        }
}
