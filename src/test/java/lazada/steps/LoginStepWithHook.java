package lazada.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lazada.pages.PageObjectManager;
import org.testng.Assert;

public class LoginStepWithHook {

    PageObjectManager pageObjectManager;
    private String currentError;

    @Given("user directs to login screen")
    public void userDirectsToLoginScreen() {

        pageObjectManager = new PageObjectManager(Hooks.getDriver());
        pageObjectManager.getLoginPage().navigate_login();
    }

    @When("user enters a valid email")
    public void userEntersAValidEmail() {
        pageObjectManager.getLoginPage().enter_email("minhngocdt1@gmail.com");
    }

    @When("user enters a invalid email")
    public void userEntersInvalidEmail(){
        pageObjectManager.getLoginPage().enter_email("abc@gmail.com");
    }

    @And("user enters a valid password")
    public void userEntersAvalidPassword() {
        pageObjectManager.getLoginPage().enter_password("P@ssword!23");
    }
    @And("user enters a invalid password")
    public void userEntersAInvalidPassword() {
        // login_page.enter_password("P@ssword");
    }

    @When("user enters an email {string} and password {string}")
    public void enter_email_and_password(String email, String password){
        pageObjectManager.getLoginPage().enter_email(email);
        pageObjectManager.getLoginPage().enter_password(password);

        if (email == null || email.isEmpty() || password == null || password.isEmpty()){
            currentError = "This field is required";
        }
        else {
            currentError = "Unable to log in with provided credentials.";
        }
    }

    @Then("user gets the error message {string}")
    public void get_error(String expectedError){
        Assert.assertEquals(currentError, expectedError, "Error does not match.");
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

    @Then("user gets error")
    public void UserGetError(){

        Assert.assertTrue(pageObjectManager.getLoginPage().getErrorMessageText());
    }
}
