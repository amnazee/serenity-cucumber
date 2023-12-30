package starter.cart;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static starter.cart.CartPage.CART_PRODUCTS;

public class RetrieveCartItems implements Question<Map<String, String>> {

    public RetrieveCartItems() {
        super();
    }

    @Override
    public Map<String, String> answeredBy(Actor actor) {
        BrowseTheWeb.as(actor).evaluateJavascript("window.scrollTo(0, document.body.scrollHeight)");
        List<WebElementFacade> cartProductElements = CART_PRODUCTS.resolveAllFor(actor);

        // Optional assertion for verification
        // Assert.assertEquals(2, cartProductElements.size());

        Map<String, String> itemMap = new HashMap<>();
        for (int i = 0; i < cartProductElements.size(); i++) {
            WebElementFacade productElement = cartProductElements.get(i);

            String productNameXpath = String.format("//table//tbody/tr[%d]//td[1]", i + 1);
            String productPriceXpath = String.format("//table//tbody/tr[%d]//td[2]", i + 1);

            String productName = productElement.findBy(productNameXpath).getText();
            String productPrice = productElement.findBy(productPriceXpath).getText();

            itemMap.put(productName, productPrice);
        }

        return itemMap;
    }
}
