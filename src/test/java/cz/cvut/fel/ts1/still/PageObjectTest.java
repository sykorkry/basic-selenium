package cz.cvut.fel.ts1.still;

import cz.cvut.fel.ts1.still.page_objects.FlightOrderPage;
import cz.cvut.fel.ts1.still.page_objects.FlightOrderPageUsingPageFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class PageObjectTest {

    FlightOrderPage flightOrderPage;
    FlightOrderPageUsingPageFactory flightOrderPageUsingPageFactory;
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        flightOrderPage = FlightOrderPage.goTo("http://35.198.153.63/", driver);
//        flightOrderPageUsingPageFactory = FlightOrderPageUsingPageFactory.goTo("http://35.198.153.63/", driver);
    }

    @Test
    public void flightOrder_basicTest() {
        flightOrderPage.setFirstName("Jan");
        flightOrderPage.setLastName("Vomáčka");
        flightOrderPage.setEmail("jan@vomacka.cz");
        flightOrderPage.setBirthDate(1999, 4, 20);
        flightOrderPage.clickCheckbox("student");
        flightOrderPage.setDestination("London");
        flightOrderPage.submitOrder(); // can return page
        // can assert result
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}
