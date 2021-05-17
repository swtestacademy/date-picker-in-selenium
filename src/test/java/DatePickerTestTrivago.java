import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DatePickerTestTrivago extends BaseTest {

    @Test
    @SneakyThrows
    public void trivagoDatePickerTest() {
        //Go to Trivago.com
        driver.navigate().to("https://www.trivago.com.tr/");

        //Search a Hotel
        WebElement searchText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("querytext")));
        searchText.clear();
        searchText.sendKeys("Antalya");

        //Wait and Click the First Results
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ssg-suggestions>li:nth-of-type(1)"))).click();

        //Wait for Visibility of Calendar / DatePicker
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".two-month-calendar")));

        //Select Start Date (Wait visibility then click the start date.)
        wait.until(ExpectedConditions.visibilityOfElementLocated
            (By.cssSelector(
                ".cal-day.cal-is-weekend.cal-is-selectable.cal-is-range.cal-is-range-start,.cal-day.cal-is-selectable.cal-is-range.cal-is-range-start"))).click();

        //Select End Date (Wait Visibility then click the end date)
        wait.until(ExpectedConditions.visibilityOfElementLocated
            (By.cssSelector(
                ".cal-day.cal-is-weekend.cal-is-selectable.cal-is-range.cal-is-range-end,.cal-day.cal-is-selectable.cal-is-range.cal-is-range-end"))).click();

        //See the results with your eyes. :)
        //From now on, you can do what you want.
        Thread.sleep(4000);
    }
}
