package starter.checktemperature;

import com.ibm.icu.impl.Assert;
import net.serenitybdd.screenplay.actions.Click;
import static starter.checktemperature.HomePageButtons.*;

public class TemperatureChecker {
    public static void checkTemperature(String tempVal) {
        try {
            if (!tempVal.isEmpty()) {
                int temperatureValue = Integer.parseInt(tempVal);
                System.out.println(temperatureValue);
                if(temperatureValue<19){
                    MOISTURIZER_BUTTON.click();
                }
                else if(temperatureValue>34){
                    SUNSCREEN_BUTTON.click();
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
