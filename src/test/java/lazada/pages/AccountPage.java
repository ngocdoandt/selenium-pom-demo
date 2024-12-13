package lazada.pages;

import lazada.steps.BaseStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BaseStep {
    private WebDriver driver;
    private static String dashboard_class = ".page_title";

    public AccountPage(WebDriver driver){
        this.driver = driver;
    }
    /*public void validateText(String expectedText){
        String actualText = driver.findElement(By.className(dashboard_class)).getText();
        Assert.assertEquals(actualText, expectedText);
    }*/

    public boolean dashboardTextExist(){
        return driver.findElement(By.cssSelector(dashboard_class)).isDisplayed();
    }

}

