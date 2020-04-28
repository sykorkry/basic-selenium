package cz.cvut.fel.ts1.still;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Priklad02 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            driver.get("http://35.246.223.13/");
            driver.findElement(By.id("firstName")).sendKeys("Honza");
            driver.findElement(By.id("lastName")).sendKeys("Vocásek");
//            System.out.println(e.getAttribute("textContent"));
        } finally {
            driver.quit();
        }
    }
}
