package starter.sunscreens;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static starter.moisturizers.MoisturizerPage.MOISTURIZER_PRODUCTS;

public class SelectSunscreenTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).evaluateJavascript("window.scrollTo(0, document.body.scrollHeight)");
            List<WebElementFacade> products = BrowseTheWeb.as(actor).findAll(MOISTURIZER_PRODUCTS);

             Map<String, String> minSPF50Products = new HashMap<>();
             Map<String, String> minSPF30Products = new HashMap<>();
            String firstElementPrice = products.get(0).findElements(By.xpath("*")).get(2).getText();
            int minElementPrice = Integer.parseInt(firstElementPrice.substring(firstElementPrice.length() - 3));
            int minSPF50Price = minElementPrice;
            int minSPF30Price = minElementPrice;
            int minSPF50Index = -1;
            int minSPF30Index = -1;
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
                    if (productName.contains("SPF-50")) {
                        if (price <= minSPF50Price) {
                            minSPF50Index = i;
                            minSPF50Price = price;

                            minSPF50Products.put("ProductName", productName);
                            minSPF50Products.put("Price", String.valueOf(price));

                        }
                    }
//                finds the products which contains aloe and then compares prices
                    if (productName.contains("SPF-30")) {
                        if (price <= minSPF30Price) {
                            minSPF30Index = i;
                            minSPF30Price = price;
                            minSPF30Products.put("ProductName", productName);
                            minSPF30Products.put("Price", String.valueOf(price));
                        }
                    }
                }
            }
            if (minSPF50Index> -1) {
                products.get(minSPF50Index).findElements(By.xpath("*")).get(3).click();
            }
            if (minSPF30Index > -1) {
                products.get(minSPF30Index).findElements(By.xpath("*")).get(3).click();
            }

        System.out.println("Min SPF-50 Products: " + minSPF50Products);
        System.out.println("Min SPF-30 Products: " + minSPF30Products);
        }
        public static SelectSunscreenTask addSunscreenToCart() {
            return instrumented(SelectSunscreenTask.class);
        }
}