package cz.cvut.fel.ts1.still.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;

public class FlightOrderPageUsingPageFactory {
    private WebDriver driver;

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "birthDate")
    private WebElement birthDate;

    @FindBy(id = "destination")
    private WebElement destination;

    @FindBy(css = "body > form > div > button")
    private WebElement submitButton;

    public void waitFor() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedCondition<Boolean>) driver1 -> driver1.findElement(By.id("firstName")).isDisplayed());
    }

    public static FlightOrderPageUsingPageFactory goTo(String baseUrl, WebDriver driver) {
        driver.get(baseUrl);
        FlightOrderPageUsingPageFactory flightOrderPageUsingPageFactory = new FlightOrderPageUsingPageFactory(driver);
        flightOrderPageUsingPageFactory.waitFor();
        return flightOrderPageUsingPageFactory;
    }

    public FlightOrderPageUsingPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setFirstName(String strFirstName) {
        firstName.sendKeys(strFirstName);
    }

    public void setLastName(String strLastName) {
        lastName.sendKeys(strLastName);
    }

    public void setEmail(String strEmail) {
        email.sendKeys(strEmail);
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
        birthDate.sendKeys(formattedBirthDate);
    }

    public void setDestination(String destinationVisibleText) {
        Select selectDestination = new Select(destination);
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
        submitButton.click();
    }
}