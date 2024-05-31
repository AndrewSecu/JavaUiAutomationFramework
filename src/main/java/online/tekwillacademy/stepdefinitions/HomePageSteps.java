package online.tekwillacademy.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import online.tekwillacademy.managers.DriverManager;
import online.tekwillacademy.pageobjects.HomePage;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    HomePage homePage = new HomePage(driver);


    @Given("The Home Page is accessed")
    public void theHomePageIsAccessed() {
        driver.get("http://tekwillacademy-opencart.online/");
    }

    @And("RegisterOption is selected from the header drop-down")
    public void registeroptionIsSelectedFromTheHeaderDropDown() {
        homePage.navigateToRegisterPage();
    }
}
