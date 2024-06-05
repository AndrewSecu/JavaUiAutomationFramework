package online.tekwillacademy.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import online.tekwillacademy.managers.DriverManager;
import online.tekwillacademy.pageobjects.LoginPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class LoginPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @And("the following set of credentials is entered into the login form:")
    public void theFollowingSetOfCredentialsIsEnteredIntoTheLoginForm(List<String> collectedList) {
        String email = collectedList.get(0);
        String password = collectedList.get(1);
        loginPage.completeTheLoginForm(email, password);
    }

    @When("the login button is clicked")
    public void theLoginButtonIsClicked() {
        loginPage.clickOnContinueButton();
        System.out.println("The login button was clicked");
    }
}
