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
        driver.navigate().to("http://www.turkishairlines.com");

        //Get Today
        String today = DateUtil.getCurrentDay();
        System.out.println("Today's number: " + today + "\n");

        //Click and open the Date Picker
        driver.findElement(By.id("dateSelector")).click();

        //This is from date picker table
        WebElement dateWidgetFrom = wait.until(
            ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-datepicker-calendar"))).get(0);

        //This are the rows of the from date picker table
        List<WebElement> rows = dateWidgetFrom.findElements(By.tagName("tr"));

        //This are the columns of the from date picker table
        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));

        //DatePicker is a table. Thus we can navigate to each cell
        //and if a cell matches with the current date then we will click it.
        for (WebElement cell : columns) {
            /*
            //If you want to click 18th Date
            if (cell.getText().equals("18")) {
            */
            //Select Today's Date
            String cellText = cell.getText();
            if (cellText.contains(today)) {
                cell.click();
                break;
            }
        }

        //Wait a bit to see that we have selected the data properly.
        Thread.sleep(5000);
    }
}
