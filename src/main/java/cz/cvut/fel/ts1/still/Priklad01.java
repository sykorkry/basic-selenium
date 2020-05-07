package cz.cvut.fel.ts1.still;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Priklad01 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/krystof/Projects/seleniumtest01/chromedriver");

        WebDriver driver = new FirefoxDriver();
        try {
            driver.get("http://35.198.153.63/");
            WebElement e = driver.findElement(By.cssSelector("body > form > div > h1"));
            System.out.println(e.getAttribute("textContent"));
        } finally {
            driver.quit();
        }
    }
}
