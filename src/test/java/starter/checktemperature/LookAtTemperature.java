package starter.checktemperature;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static starter.cart.CartPage.CART_PRODUCTS;
import static starter.checktemperature.TemperatureIcon.TEMPERATURE_ICON;

public class LookAtTemperature implements Question<String> {
@Override
public String answeredBy(Actor actor) {
    String temperature= TemperatureIcon.TEMPERATURE_ICON.resolveFor(actor).getText();
    String numericPart = temperature.replaceAll("[^0-9]", "");
    System.out.println(numericPart);
    return numericPart;
}
}