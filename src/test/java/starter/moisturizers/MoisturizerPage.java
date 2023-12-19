package starter.moisturizers;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import net.serenitybdd.screenplay.targets.Target;

public class MoisturizerPage extends PageObject {
    public static final By MOISTURIZER_PRODUCTS = By.xpath("//div[@class='text-center col-4']");
    public static final By PRODUCT_NAME = By.xpath("//p[@class='font-weight-bold top-space-10']");
    public static final By PRODUCT_PRICE = By.xpath("//p[contains(text(),'Price: ')]");
    public static final By ADD_TO_CART_BUTTON=By.xpath("//button[@class='btn btn-primary']");
    public static final Target CART_BUTTON = Target.the("Cart button").locatedBy("//button[contains(.,'Cart')]");
    public static final Target TITLE = Target.the("Title of page").locatedBy("//h2");
    public static final Target ABC = Target.the("dynamic button").locatedBy("//div[./p[text()={0}]]//button");
}