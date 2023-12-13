package starter.checktemperature;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static starter.checktemperature.TemperatureIcon.TEMPERATURE_ICON;

public class LookAtTemperature {
    public static Performable temperature(){
        return Task.where(TEMPERATURE_ICON.getName());
    }
}
