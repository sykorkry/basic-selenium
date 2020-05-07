package cz.cvut.fel.ts1.still;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Priklad02 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            driver.get("http://35.198.153.63/");
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
            System.out.println(e.getAttribute("textContent"));
        } finally {
            driver.quit();
        }
    }
}
