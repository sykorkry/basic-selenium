package cz.cvut.fel.ts1.still.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;

public class FlightOrderPage {
    private WebDriver driver;
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By email = By.id("email");
    private By birthDate = By.id("birthDate");
    private By destination = By.id("destination");
    private By submit = By.cssSelector("body > form > div > button");

    public static FlightOrderPage goTo(String baseUrl, WebDriver driver) {
        driver.get(baseUrl);
        FlightOrderPage flightOrderPage = new FlightOrderPage(driver);
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedCondition<Boolean>) driver1 -> driver1.findElement(By.id("firstName")).isDisplayed());
        return flightOrderPage;
    }

    public FlightOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstName(String strFirstName) {
        driver.findElement(firstName).sendKeys(strFirstName);
    }

    public void setLastName(String strLastName) {
        driver.findElement(lastName).sendKeys(strLastName);
    }

    public void setEmail(String strEmail) {
        driver.findElement(email).sendKeys(strEmail);
    }

    public void setBirthDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);
        Date date = cal.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedBirthDate = null;
        try {
            formattedBirthDate = dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.findElement(birthDate).sendKeys(formattedBirthDate);
    }

    public void setDestination(String destinationVisibleText) {
        Select selectDestination = new Select(driver.findElement(destination));
        selectDestination.selectByVisibleText(destinationVisibleText);
    }

    public void clickCheckbox(String checkboxIdToCheck) {
        try {
            driver.findElement(By.id(checkboxIdToCheck)).click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void submitOrder() {
        driver.findElement(submit).click();
    }
}