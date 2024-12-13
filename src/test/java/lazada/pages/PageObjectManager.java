package lazada.pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;
    private LoginPage loginPage;
    private AccountPage accountPage;


    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public AccountPage getAccountPage() {
        if (accountPage == null) {
            accountPage = new AccountPage(driver);
        }
        return accountPage;
    }
}
