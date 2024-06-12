package online.tekwillacademy.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.ht.Le;
import online.tekwillacademy.managers.DriverManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private static final Logger logger = LogManager.getLogger(Hooks.class);
    WebDriver driver = DriverManager.getInstance().getDriver();

    @BeforeAll
    public static void beforeAllTheTestsAreExecuted() {
        logger.log(Level.INFO, "The test engine started - this method is executed once");
    }

    @Before
    public void beforeEachTestScenario() {
        logger.log(Level.INFO, "A test has been started");
    }

    @After
    public void afterEachTestScenario() {
        DriverManager.getInstance().quiteTheDriver();
        logger.log(Level.INFO, "After each Scenario!");
    }

    @AfterAll
    public static void executeAfterAllTheTests() {
        logger.log(Level.DEBUG, "The test execution is finished!");
    }
}
