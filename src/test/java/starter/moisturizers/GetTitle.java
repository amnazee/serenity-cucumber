package starter.moisturizers;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static starter.moisturizers.MoisturizerPage.TITLE;

public class GetTitle {
    public static Performable getTitle(String expectedTitle1, String expectedTitle2){
        return Task.where("{0} gets the title value",
                actor -> {
                    String titleValue = TITLE.resolveFor(actor).getText();
                    System.out.println("Title: " + titleValue);
                    String[] expectedTitles = {expectedTitle1,expectedTitle2};
                    List<String> expectedTitlesList = Arrays.asList(expectedTitles);
                    assertTrue(expectedTitlesList.contains((titleValue)));
       });
    }
}