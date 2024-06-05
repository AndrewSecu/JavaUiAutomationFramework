package online.tekwillacademy.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import online.tekwillacademy.managers.DriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class GenericSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();

    @Given("The {string} link is accessed")
    public void theLinkIsAccessed(String collectedLink) {
        driver.get(collectedLink);
        System.out.println("The link " + collectedLink + " is opened");
    }

    @Then("the following error messages are displayed:")
    public void theFollowingErrorMessagesAreDisplayed(List<String> errorsList) throws InterruptedException {
        Thread.sleep(500);
        errorsList.forEach(errorMessage -> {
            boolean messageIsDisplayed = driver.findElement(By.xpath(".//*[contains(text(),'" + errorMessage + "')]")).isDisplayed();
            Assertions.assertTrue(messageIsDisplayed, "The message is displayed");
        });
    }
}
