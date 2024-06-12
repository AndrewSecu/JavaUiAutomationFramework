package online.tekwillacademy.managers;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverManager {
    private static String webDriverType = ConfigReaderManager.getProperty("browser");
    private static DriverManager instance;
    private WebDriver driver;

    private DriverManager() {
        switch (webDriverType.toUpperCase()) {
            case "CHROME":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                driver = new ChromeDriver(options);
                System.out.println("The Chrome Driver was initiated!");
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                System.out.println("The Firefox Driver was initiated!");
                break;
            case "SAFARI":
                driver = new SafariDriver();
                System.out.println("The Safari Browser was initiated!");
                break;
            case "EDGE":
                driver = new EdgeDriver();
                System.out.println("The Edge Browser was initiated!");
                break;
            default:
                System.out.println("The webDriverType " + webDriverType + " is not defined!");
        }
        driver.manage().window().maximize();

        int implicitWaitValue = Integer.parseInt(ConfigReaderManager.getProperty("implicitWait"));
        int pageLoadWaitValue = Integer.parseInt(ConfigReaderManager.getProperty("pageLoadWaitValue"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitValue));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadWaitValue));

    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            getInstance();
        }
        return driver;
    }

    public void quiteTheDriver() {
        driver.quit();
        driver = null;
        instance = null;
        System.out.println("The driver was reset to null, same as instance object");
    }
}
