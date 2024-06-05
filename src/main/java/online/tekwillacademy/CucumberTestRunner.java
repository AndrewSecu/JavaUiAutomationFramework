package online.tekwillacademy;

import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/online/tekwillacademy/features",
        glue = "online.tekwillacademy.stepdefinitions",
        tags = "",
        plugin = {"pretty", "html:target/cucumber-reports"}
)

public class CucumberTestRunner {
}
