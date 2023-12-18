package starter.checktemperature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static net.serenitybdd.core.Serenity.getDriver;

public class HomePageButtons {
    public static WebElement MOISTURIZER_BUTTON = getDriver().findElement(By.xpath("//button[contains(text(),'moisturizer')]"));
    public static WebElement SUNSCREEN_BUTTON=getDriver().findElement(By.xpath("//button[contains(text(),'sunscreen')]"));
}
