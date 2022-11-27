package by.epam.pageobject_model.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverSingleton {

    private static final Logger LOGGER = LogManager.getRootLogger();
    private static WebDriver driver;

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            switch (System.getProperty("browser").toLowerCase()) {
                case "firefox": {
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--no-sandbox");
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(firefoxOptions);
                    LOGGER.info("Browser Firefox is running.");
                    break;
                }
                case "edge": {
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--no-sandbox");
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver(edgeOptions);
                    LOGGER.info("Browser Edge is running.");
                    break;
                }
                default: {
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--no-sandbox");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chromeOptions);
                    LOGGER.info("Browser Chrome is running.");
                    break;
                }
            }

            driver.manage().window().maximize();
        }
        return driver;
    }
    public static void closeDriver() {
        driver.quit();
        driver = null;
        LOGGER.info("Browser closed.");
    }
}
