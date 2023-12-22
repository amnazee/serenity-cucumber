package starter.payment;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentPage extends PageObject {
    public static Target EMAIL= Target.the("email").locatedBy("//input[@id='email']");
    public static Target CARD_NUMBER=Target.the("card number").locatedBy("//input[@id='card_number']");
    public static Target DATE=Target.the("date").locatedBy("//input[@id='cc-exp']");
    public static Target CVC=Target.the("cvc").locatedBy("//input[@id='cc-csc']");
    public static Target ZIP_CODE=Target.the("zip code").locatedBy("//input[@id='billing-zip']");
    public static Target PAYMENT_SUCCESS=Target.the("payment success").locatedBy("//h2[contains(.,'SUCCESS')]");
    public static Target PAYMENT_HEADING=Target.the("payment heading").locatedBy("//h1[contains(.,'Stripe')]");
    public static Target SUBMIT_BUTTON=Target.the("submit").locatedBy("//span[@class='iconTick']");
    public static Target IFRAME=Target.the("Iframe").locatedBy("//iframe[@name='stripe_checkout_app']");


}