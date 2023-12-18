package starter.checktemperature;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.questions.Text;
import static starter.checktemperature.TemperatureIcon.TEMPERATURE_ICON;

public class LookAtTemperature implements Question<String> {
    public static Performable getTemperatureValue(){
        return Task.where("{0} gets the temperature value",
                actor -> {
                    String temperatureValue = TEMPERATURE_ICON.resolveFor(actor).getTextValue();
                    System.out.println("Temperature Value: " + temperatureValue);
                }
        );
    }
    public static Question<String> temperatureValue() {
        return actor ->
            Text.of(TEMPERATURE_ICON).answeredBy(actor);
    }
    @Override
    public String answeredBy(Actor actor) {
        return temperatureValue().answeredBy(actor);
    }
}