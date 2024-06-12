package online.tekwillacademy.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import online.tekwillacademy.managers.DriverManager;
import online.tekwillacademy.managers.ExplicitWaitManager;
import online.tekwillacademy.managers.ScrollManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class GenericSteps {
    private static final Logger logger = LogManager.getLogger(GenericSteps.class);
    WebDriver driver = DriverManager.getInstance().getDriver();

    @Given("The {string} link is accessed")
    public void theLinkIsAccessed(String collectedLink) {
        driver.get(collectedLink);
        logger.log(Level.INFO, "The link " + collectedLink + " is opened");
    }

    @Then("the following error messages are displayed:")
    public void theFollowingErrorMessagesAreDisplayed(List<String> errorsList) throws InterruptedException {
        Thread.sleep(500);
        errorsList.forEach(errorMessage -> {
            boolean messageIsDisplayed = driver.findElement(By.xpath(".//*[contains(text(),'" + errorMessage + "')]")).isDisplayed();
            Assertions.assertTrue(messageIsDisplayed, "The message is displayed");
        });
    }

    @When("the {string} from {string} is clicked")
    public void theFromIsClicked(String clickableElement, String pageName) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class classInstance = Class.forName("online.tekwillacademy.pageobjects." + pageName);
        Field webClickableElementField = classInstance.getDeclaredField(clickableElement);
        webClickableElementField.setAccessible(true);
        WebElement webClickableElement = (WebElement) webClickableElementField.get(classInstance.getConstructor(WebDriver.class).newInstance(driver));
        ExplicitWaitManager.waitTillElementIsClickable(webClickableElement);
        ScrollManager.scrollToElement(webClickableElement);
        webClickableElement.click();
    }
}
