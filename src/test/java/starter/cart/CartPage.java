package starter.cart;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartPage extends PageObject {
    Actor actor;
    public static final Target PAY_BUTTON=Target.the("Pay Button").locatedBy("//button[@class='stripe-button-el']");
    public static final Target CART_PRODUCTS=Target.the("Cart Products").locatedBy("//div//table[@class='table table-striped']//tbody//tr//td[1]");
    public Map<String, String> getCartItemsAndPrices() {
        List<WebElementFacade> cartProductElements = CART_PRODUCTS.resolveAllFor(actor);
        Map<String, String> itemMap = new HashMap<>();

        for (WebElementFacade productElement : cartProductElements) {
            String productNameXpath = String.format("//table//tbody/tr[%d]//td[1]", cartProductElements.indexOf(productElement) + 1);
            String productPriceXpath = String.format("//table//tbody/tr[%d]//td[2]", cartProductElements.indexOf(productElement) + 1);

            String productName = productElement.findBy(productNameXpath).getText();
            String productPriceText = productElement.findBy(productPriceXpath).getText();

//             Convert price text to numerical value if needed
            BigDecimal productPrice = BigDecimal.ZERO; // Replace with appropriate parsing if necessary
            try {
                productPrice = new BigDecimal(productPriceText.replaceAll("[^\\d.]", "")); // Example parsing
            } catch (NumberFormatException e) {
                System.out.println("Error:" + e);
            }
            itemMap.put(productName, productPrice.toString()); // Store as string for consistency
        }
        return itemMap;
    }

}
