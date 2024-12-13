package lazada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    //public static final String PAGE_URL = "https://app.phptravels.com/login";
    private WebDriver driver;

   public LoginPage(WebDriver driver){
       this.driver = driver;

    }

    public void navigate_login(){
       driver.get("https://app.phptravels.com/login");
    }

    private static String emailAddress_name = "email";
    private static String password_id = "password";
    private static String clickBtn_id = "submit";

    public void enter_email(String email){
        driver.findElement(By.name(emailAddress_name)).sendKeys(email);
    }

    public void enter_password(String password){
        driver.findElement(By.name(password_id)).sendKeys(password);
    }

    public void login_btn_click(){
        driver.findElement(By.id(clickBtn_id)).click();
    }


    public String getErrorMessageText(){
        return driver.findElement(By.className("HyEuQL")).getText();
    }
}
