package online.tekwillacademy.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import online.tekwillacademy.managers.DataGeneratorManager;
import online.tekwillacademy.managers.DriverManager;
import online.tekwillacademy.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;

public class RegisterPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @And("the register form is populated with Valid data")
    public void theRegisterFormIsPopulatedWithValidData() {
        String firstName = DataGeneratorManager.getRandomName();
        String lastName = DataGeneratorManager.getRandomName();
        String email = DataGeneratorManager.getRandomEmail();
        String password = DataGeneratorManager.getRandomPassword(10,20);

        registerPage.completeTheRegisterForm(firstName, lastName, email, password);
    }

    @And("Privacy Toggle is enabled")
    public void privacyToggleIsEnabled() {
        registerPage.enablePrivacyToggle();
    }

    @When("the Continue Button is clicked")
    public void theContinueButtonIsClicked() {
        registerPage.clickOnContinueButton();
    }
}
