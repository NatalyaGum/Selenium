import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebDriverSeleniumHQTest {
    WebDriver driver;

    @Test
    public void mailruTest () throws InterruptedException {

        driver =new ChromeDriver();
        driver.get("https://mail.ru/");
        WebElement acceptBtn = driver.findElement(By.xpath(" //*[@id='cmpbntyestxt']"));
        acceptBtn.click();
        new WebDriverWait(driver,Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='search:submit']")));
        WebElement searchInput = driver.findElement(By.id("q"));
        searchInput.sendKeys("java");
        WebElement searchBtn=driver.findElement(By.xpath("//*[@id='search:submit']"));
        searchBtn.click();
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1));



        driver.quit();

        driver =new EdgeDriver();
        driver.get("https://mvnrepository.com/");
        Thread.sleep(2000);
        driver.quit();

        driver =new FirefoxDriver();
        driver.get("https://mvnrepository.com/");
        Thread.sleep(2000);
        driver.quit();

       Assert.assertTrue(searchBtn!=null, "no button!");
    }
    @AfterMethod (alwaysRun=true)
public void druverTearDown (){
        driver.quit();
    }
}
