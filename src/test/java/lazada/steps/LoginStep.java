package lazada.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lazada.pages.PageObjectManager;
import org.testng.Assert;


public class LoginStep extends BaseStep{

    PageObjectManager pageObjectManager;

    @Given("userA directs to login screen")
    public void userDirectsToLoginScreen() {
        setup();
        //driver.get("https://app.phptravels.com/login");
        pageObjectManager = new PageObjectManager(driver);
        pageObjectManager.getLoginPage().navigate_login();
    }

    @When("userA enters a valid email")
    public void userEntersAValidEmail() {
        pageObjectManager.getLoginPage().enter_email("minhngocdt1@gmail.com");
    }

    @And("userA enters a valid password")
    public void userEntersAvalidPassword() {
        pageObjectManager.getLoginPage().enter_password("P@ssword!23");
    }
    @And("userA enters a invalid password")
    public void userEntersAInvalidPassword() {
       // login_page.enter_password("P@ssword");
    }

    @And("userA clicks Submit button")
    public void userClicksSubmitButton(){
        pageObjectManager.getLoginPage().login_btn_click();
    }

    @Then("userA should be on My Account page")
    public void userShouldBeOnMyAccountPage() {
        /*String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://app.phptravels.com/dashboard");*/
       //pageObjectManager.getAccountPage().validateText("Dashboard");

       Assert.assertTrue(pageObjectManager.getAccountPage().dashboardTextExist());

    }

    @Then("userA get error")
    public void UserGetError(){

    }

}
