package lazada.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorDemo {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://scrapfly.io/login");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("input.form-control[type='email']")).sendKeys("hello");
    }
}
