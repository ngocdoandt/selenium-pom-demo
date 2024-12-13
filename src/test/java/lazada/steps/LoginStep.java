package lazada.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lazada.pages.PageObjectManager;
import org.testng.Assert;


public class LoginStep extends BaseStep{

    PageObjectManager pageObjectManager;

    @Given("user directs to login screen")
    public void userDirectsToLoginScreen() {
        setup();
        //driver.get("https://app.phptravels.com/login");
        pageObjectManager = new PageObjectManager(driver);
        pageObjectManager.getLoginPage().navigate_login();
    }

    @When("user enters a valid email")
    public void userEntersAValidEmail() {
        pageObjectManager.getLoginPage().enter_email("minhngocdt1@gmail.com");
    }

    @And("user enters a valid password")
    public void userEntersAvalidPassword() {
        pageObjectManager.getLoginPage().enter_password("P@ssword!23");
    }
    @And("user enters a invalid password")
    public void userEntersAInvalidPassword() {
       // login_page.enter_password("P@ssword");
    }

    @And("user clicks Submit button")
    public void userClicksSubmitButton(){
        pageObjectManager.getLoginPage().login_btn_click();
    }

    @Then("user should be on My Account page")
    public void userShouldBeOnMyAccountPage() {
        /*String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://app.phptravels.com/dashboard");*/
       //pageObjectManager.getAccountPage().validateText("Dashboard");

       Assert.assertTrue(pageObjectManager.getAccountPage().dashboardTextExist());

    }

    @Then("user get error")
    public void UserGetError(){

    }

}
