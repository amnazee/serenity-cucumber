package starter.checktemperature;

import com.ibm.icu.impl.Assert;
import net.serenitybdd.screenplay.Actor;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static starter.checktemperature.HomePageButtons.openMoisturizerPage;
import static starter.checktemperature.HomePageButtons.openSunscreenPage;

public class TemperatureChecker {
    public static void checkTemperature(Actor actor) {
        String actualTemperature = LookAtTemperature.temperatureValue().answeredBy(actor);
        try {
            String numericPart = actualTemperature.replaceAll("[^0-9]", "");
            if (!numericPart.isEmpty()) {
                int temperatureValue = Integer.parseInt(numericPart);
                if(temperatureValue<19){
                    MatcherAssert.assertThat(temperatureValue,lessThan(19));
                    openMoisturizerPage.click();
                }
                else if(temperatureValue>34){
                    MatcherAssert.assertThat(temperatureValue,greaterThan(34));
                    openSunscreenPage.click();
                }
                else {
                    Assert.fail("Unsupported temperature condition");
                }
            } else {
                Assert.fail("Temperature is not a valid numeric string");
            }
        } catch (NumberFormatException e) {
            Assert.fail("Failed to parse temperature as a numeric value");
        }
    }
}
