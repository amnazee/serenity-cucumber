package starter.checktemperature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.core.Serenity.getDriver;

public class HomePageButtons {
    public static WebElement openMoisturizerPage = getDriver().findElement(By.xpath("//button[contains(text(),'moisturizer')]"));
    public static WebElement openSunscreenPage=getDriver().findElement(By.xpath("//button[contains(text(),'sunscreen')]"));

}
