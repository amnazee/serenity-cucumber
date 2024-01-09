package starter.moisturizers;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static starter.moisturizers.MoisturizerPage.ADD_TO_CART_BUTTON;
import static starter.moisturizers.MoisturizerPage.MOISTURIZER_PRODUCTS;

public class SelectedMoisturizerProductsQuestion  implements Question<Map<String, Map<String, String>>> {
    @Override
    public Map<String, Map<String, String>> answeredBy(Actor actor) {
        BrowseTheWeb.as(actor).evaluateJavascript("window.scrollTo(0, document.body.scrollHeight)");
        List<WebElementFacade> products = BrowseTheWeb.as(actor).findAll(MOISTURIZER_PRODUCTS);
        Map<String, Map<String, String>> selectedProducts = new HashMap<>();
        Map<String, String> minAlmondProducts = new HashMap<>();
        Map<String, String> minAloeProducts = new HashMap<>();
        int minAlmondPrice = Integer.MAX_VALUE;
        int minAloePrice = Integer.MAX_VALUE;
        int minAlmondIndex = -1;
        int minAloeIndex = -1;
        //to check how many products are found in the list
        System.out.println("Number of products found: " + products.size());
        if(products.size()==6){
            for (int i = 0; i < products.size(); i++) {
                List<WebElement> listElements = products.get(i).findElements(By.xpath("*"));
                int price = Integer.parseInt(listElements.get(2).getText().substring(listElements.get(2).getText().length() - 3));
                String productName = listElements.get(1).getText();

                //this is for myself to print each of the product along with their prices
                System.out.println("Product Name: " + productName);
                System.out.println("Price: " + price);

                //finds the products which contains almond and then compares prices
                if (productName.toLowerCase().contains("almond")) {
                    if (price <= minAlmondPrice) {
                        minAlmondIndex = i;
                        minAlmondPrice = price;
                        minAlmondProducts.put("ProductName", productName);
                        minAlmondProducts.put("Price", String.valueOf(price));
                    }
                }
                //finds the products which contains aloe and then compares prices
                if (productName.toLowerCase().contains("aloe")) {
                    if (price <= minAloePrice) {
                        minAloeIndex = i;
                        minAloePrice = price;
                        minAloeProducts.put("ProductName", productName);
                        minAloeProducts.put("Price", String.valueOf(price));
                    }
                }
            }
        }
        if (minAlmondIndex > -1) {
//            products.get(minAlmondIndex).findBy(ADD_TO_CART_BUTTON).click();
            products.get(minAlmondIndex).findElements(By.xpath("*")).get(3).click();
        }
        if (minAloeIndex > -1) {
//            products.get(minAloeIndex).findBy(ADD_TO_CART_BUTTON).click();
            products.get(minAloeIndex).findElements(By.xpath("*")).get(3).click();
        }
        selectedProducts.put("almond", minAlmondProducts);
        selectedProducts.put("aloe", minAloeProducts);
        return selectedProducts;
    }
}
