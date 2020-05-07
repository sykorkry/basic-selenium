package cz.cvut.fel.ts1.still;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Cekani {

    public static void main(String args[]) {
        WebDriver driver = new FirefoxDriver();

        driver.get("http://35.198.153.63/");

        // Implicitní čekání
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        driver.findElement(By.id("firstName")).sendKeys("Honza");
        driver.findElement(By.id("lastName")).sendKeys("Vocásek");
        driver.findElement(By.id("email")).sendKeys("honzavocaek@gmail.com");

        driver.findElement(By.id("birthDate")).sendKeys("2017-10-01");

        Select selectDestination = new Select(driver.findElement(By.id("destination")));
        selectDestination.selectByVisibleText("London");


        driver.findElement(By.id("student")).click();
        driver.findElement(By.id("bank_transfer")).click();

        driver.findElement(By.cssSelector("body > form > div > button")).click();

        // Explicitní čekání
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > h2:nth-child(5)")));
        System.out.println(result.getAttribute("textContent"));

        // Čekáme na neexistující element
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("???")));
        } catch (Exception e) {
            System.out.println("No such element found.");
        } finally {
            driver.close();
        }
    }
}
