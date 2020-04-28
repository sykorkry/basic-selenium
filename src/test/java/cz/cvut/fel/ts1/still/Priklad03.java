package cz.cvut.fel.ts1.still;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class Priklad03 {
    WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @Test
    public void test01() {
        driver.get("http://35.246.223.13/");
        driver.findElement(By.id("firstName")).sendKeys("Honza");
        driver.findElement(By.id("lastName")).sendKeys("Vocásek");
        driver.findElement(By.id("email")).sendKeys("honzavocaek@gmail.com");
        driver.findElement(By.id("birthDate")).sendKeys("2017-10-01");
        Select selectDestination = new Select(driver.findElement(By.id("destination")));
        selectDestination.selectByVisibleText("London");
        driver.findElement(By.id("student")).click();
        driver.findElement(By.id("bank_transfer")).click();


        driver.findElement(By.cssSelector("body > form > div > button")).click();


        WebElement e = driver.findElement(By.cssSelector("body > h2:nth-child(5)"));
        assertEquals("Total price: 1250", e.getAttribute("textContent"));
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}
