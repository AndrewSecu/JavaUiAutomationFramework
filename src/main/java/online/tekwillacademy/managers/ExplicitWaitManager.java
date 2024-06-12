package online.tekwillacademy.managers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitManager {

    private static int explicitWaitValue = Integer.parseInt(ConfigReaderManager.getProperty("explicitWaitValue"));
    private static WebDriverWait waitObject = new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(explicitWaitValue));

    public static void waitTillElementIsClickable(WebElement element) {
        waitObject.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitTillElementIsVisible(WebElement element) {
        waitObject.until(ExpectedConditions.visibilityOf(element));
    }

}
