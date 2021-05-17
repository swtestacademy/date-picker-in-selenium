import java.util.List;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DatePickerTestsFlyDubai extends BaseTest {

    @Test
    @SneakyThrows
    public void flyDubaiDatePicker() {
        //Go to website
        driver.get("https://www.flydubai.com/en/");

        //Click Departure Place
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".airportPickerTo.makeBookingTo.mat-form-group"))).click();

        //Wait Dropdown and click the first city
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector(" .makeBookingTo .search-list-dropdown [data-metro-active='false']:nth-of-type(1)"))).click();

        //Wait the DatePicker Opens
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(".lightpick__inner"))));

        //This are the cell of the from date picker table for departure. Get all elements.
        List<WebElement> cellsOfDepartureDate = wait.until(
            ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("section:nth-of-type(1) > .lightpick__days > div")));

        //Click the today for Departure
        DateUtil.clickGivenDay(cellsOfDepartureDate, DateUtil.getCurrentDay());

        //This are the cell of the from date picker table for arrival. Get all elements.
        List<WebElement> cellsOfArrivalDate = wait.until(
            ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("section:nth-of-type(2) > .lightpick__days > div")));

        //Click the 4th day (element).
        cellsOfArrivalDate.get(4).click();

        //Wait and see the selection.
        Thread.sleep(5000);
    }
}
