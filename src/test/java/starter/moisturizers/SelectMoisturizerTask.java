package starter.moisturizers;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static starter.moisturizers.MoisturizerPage.*;

public class SelectMoisturizerTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).evaluateJavascript("window.scrollTo(0, document.body.scrollHeight)");
        List<WebElementFacade> products = BrowseTheWeb.as(actor).findAll(MOISTURIZER_PRODUCTS);
        String firstProductPrice = products.get(0).findElements(By.xpath("*")).get(2).getText();
        int minProductPrice = Integer.parseInt(firstProductPrice.substring(firstProductPrice.length() - 3));
        int minAlmondPrice = minProductPrice;
        int minAloePrice = minProductPrice;
        int minAlmondIndex = -1, minAloeIndex = -1;

        System.out.println("Number of products found: " + products.size());
        for (int i = 0; i < products.size(); i++) {
            List<WebElement> childElements = products.get(i).findElements(By.xpath("*"));
            int price = Integer.parseInt(childElements.get(2).getText().substring(childElements.get(2).getText().length() - 3));
            String productName = childElements.get(1).getText();

            //this is for myself to print each of the product along with their prices
            System.out.println("Product Name: " + productName);
            System.out.println("Price: " + price);

            //finds the products which contains almond and then compares prices
            if (productName.toLowerCase().contains("almond")) {
                if (price < minAlmondPrice) {
                    minAlmondIndex = i;
                    minAlmondPrice = price;
                }
            }
            //finds the products which contains aloe and then compares prices
            if (productName.toLowerCase().contains("aloe")) {
                if (price < minAloePrice) {
                    minAloeIndex = i;
                    minAloePrice = price;
                }
            }
        }
        if (minAlmondIndex > -1 || minAloeIndex>-1) {
            products.get(minAlmondIndex).find(ADD_TO_CART_BUTTON).click();
        }
        if (minAloeIndex > -1) {
            products.get(minAloeIndex).find(ADD_TO_CART_BUTTON).click();
            System.out.println("Aloe product added to cart");
        }
        //this is for myself only to see if the products are chosen correctly
        System.out.println("Min Almond Price: " + minAlmondPrice);
        System.out.println("Min Almond Index: " + minAlmondIndex);
        System.out.println("Min Aloe Price: " + minAloePrice);
        System.out.println("Min Aloe Index: " + minAloeIndex);
}
    public static SelectMoisturizerTask addMoisturizerToCart() {
        return instrumented(SelectMoisturizerTask.class);
    }
}
