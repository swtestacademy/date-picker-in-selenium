import java.util.List;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DatePickerTestsTurkishAirlines extends BaseTest {

    @Test
    @SneakyThrows
    public void turkishAirlinesDatePicker() {
        //Because of the Webdriver Bot Detection this test cannot be run properly.
        //But you can follow the approach in debug mode I run the test successfully and it worked.
        driver.navigate().to("https://www.turkishairlines.com");

        //Click and open the Date Picker
        driver.findElement(By.id("dateSelector")).click();

        //This is from date picker table
        WebElement dateWidgetFrom = wait.until(
            ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-datepicker-calendar"))).get(0);

        //This are the rows of the from date picker table
        List<WebElement> rows = dateWidgetFrom.findElements(By.tagName("tr"));

        //This are the columns of the from date picker table
        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));

        DateUtil.clickGivenDay(columns, DateUtil.getCurrentDay());

        //Wait a bit to see that we have selected the data properly.
        Thread.sleep(5000);
    }
}
