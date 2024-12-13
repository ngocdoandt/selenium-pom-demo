package lazada.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseStep {

    public static WebDriver driver;


    public void setup(){
        driver = new ChromeDriver();
        //driver.get("https://app.phptravels.com/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}

