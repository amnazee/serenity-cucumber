package starter.moisturizers;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import net.serenitybdd.screenplay.targets.Target;

public class MoisturizerPage extends PageObject {
//    public static final Target MOISTURIZER_PRODUCTS = Target.the("Moisturizer Products").locatedBy("//div[@class='text-center col-4']");
//    public static final Target PRODUCT_NAME = Target.the("Product Name").locatedBy("//p[@class='font-weight-bold top-space-10']");
//    public static final Target PRODUCT_PRICE = Target.the("Product Price").locatedBy(".product-price");
//    public static final Target ADD_TO_CART_BUTTON = Target.the("Add to Cart Button").locatedBy("//button[contains(.,'Cart')]");
    public static final By MOISTURIZER_PRODUCTS = By.xpath("//div[@class='text-center col-4']");
    public static final By PRODUCT_NAME = By.xpath("//p[@class='font-weight-bold top-space-10']");
    public static final By ADD_TO_CART_BUTTON = By.xpath("//button[@class='btn btn-primary']");
    public static final By PRODUCT_PRICE = By.xpath("//p[contains(text(),'Price: ')]");
//    public static final Target CART_BUTTON = Target.the("Cart button").locatedBy("//span[@id='cart']");
    public static final Target CART_BUTTON = Target.the("Cart button").locatedBy("//button[contains(.,'Cart')]");
    public static final Target TITLE = Target.the("Title of page").locatedBy("//h2");



}
