package lazada.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Scenario;


import java.io.ByteArrayInputStream;
import java.time.Duration;

public class Hooks {
    private static WebDriver driver;


    @Before
    public void setup(){
        driver = new ChromeDriver();
        //driver.get("https://app.phptravels.com/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        String a = "abc";
    }


    @After
    public void tearDown(Scenario scenario){

        if (scenario.isFailed()) {
            // Capture screenshot
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            // Attach screenshot to Allure Report
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));
        }

        // Quit the browser
        if (driver != null) {
            driver.quit();
    }}

    public static WebDriver getDriver() {
        return driver;
    }
}
