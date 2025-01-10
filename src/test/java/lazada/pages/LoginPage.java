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
       driver.get("https://app.bugbug.io/sign-in/");
    }

    private static String emailAddress_name = "email";
    private static String password_id = "password";
    private static String clickBtn_css = "button[type=submit]";
    private static String errorText_path = "//p[text()='Unable to log in with provided credentials.']";

    public void enter_email(String email){
        driver.findElement(By.name(emailAddress_name)).sendKeys(email);
    }

    public void enter_password(String password){
        driver.findElement(By.name(password_id)).sendKeys(password);
    }

    public void login_btn_click(){
        driver.findElement(By.cssSelector(clickBtn_css)).click();
    }


    public boolean getErrorMessageText(){
        //WebDriverWait wait = new WebDriverWait(driver,10);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(errorText_path)));
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        return driver.findElement(By.xpath(errorText_path)).isDisplayed();
    }
}
