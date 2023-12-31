package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import starter.cart.NoOfItems;
import starter.cart.RetrieveCartItems;
import starter.moisturizers.GetTitle;
import starter.moisturizers.SelectedMoisturizerProductsQuestion;
import starter.sunscreens.SelectedSunscreenProductsQuestion;
import java.util.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static starter.cart.CartPage.PAY_BUTTON;
import static starter.moisturizers.MoisturizerPage.*;

public class MoisturizerStepDefinition {
    Map<String, Map<String, String>> selectedProducts=new HashMap<>();
    Map<String, String> selectedProductMap = new HashMap<>();

    @Given("{actor} is at Product Page and the title is {string} or {string}")
    public void maxIsAtProductPage(Actor actor, String expectedTitle1, String expectedTitle2) {
        actor.attemptsTo(
                GetTitle.getTitle(expectedTitle1, expectedTitle2)
        );
    }
    @When("adds the least expensive product to the cart")
    public void theUserAddsTheLeastExpensiveProductToTheCart(){
        String productType=TITLE.resolveFor(theActorInTheSpotlight()).getText();
        if (productType.equals("Sunscreens")) {
            selectedProducts=theActorInTheSpotlight().asksFor(new SelectedSunscreenProductsQuestion());
        } else if (productType.equals("Moisturizers")) {
            selectedProducts=theActorInTheSpotlight().asksFor(new SelectedMoisturizerProductsQuestion());
        } else {
            System.out.println("Invalid Product Type");
            return;
        }
        System.out.println(selectedProducts);
        for (Map.Entry<String, Map<String, String>> entry : selectedProducts.entrySet()) {
            String productName = entry.getValue().get("ProductName");
            String productPrice = entry.getValue().get("Price");
            selectedProductMap.put(productName, productPrice);
            System.out.println(selectedProductMap);
        }
    }
    @And("click on the cart button")
    public void clickOnTheCartButton() {
        theActorInTheSpotlight().attemptsTo(
                NoOfItems.noOfItems(),
                Click.on(CART_BUTTON)
        );
    }
    @Then("check if the items in the cart are right products")
    public void checkIfTheItemsInTheCartAreRightProducts() {
        Map<String, String> cartItems = theActorInTheSpotlight().asksFor(new RetrieveCartItems());
        System.out.println(cartItems);
        assertThat(cartItems.keySet()).isEqualTo(selectedProductMap.keySet());
        theActorInTheSpotlight().attemptsTo(
                Click.on(PAY_BUTTON)
        );
    }
}