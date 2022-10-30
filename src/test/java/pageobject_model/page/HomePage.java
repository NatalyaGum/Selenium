package pageobject_model.page;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {

    @Test
    public void mailruTest () throws InterruptedException {
    WebDriver driver =new ChromeDriver();
        driver.get("https://mail.ru/");

        /*new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cmpbntyestxt']")));

        WebElement acceptBtn = driver.findElement(By.xpath(" //*[@id='cmpbntyestxt']"));
        acceptBtn.click();*/

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        WebElement loginBtn=driver.findElement(By.xpath("//button[@class='ph-login svelte-1hiqrvn']"));
        loginBtn.click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']")));

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='input-0-2-71']")));


        WebElement loginInput = driver.findElement(By.cssSelector(".input-0-2-71"));//*[@class='input-0-2-71']
        loginInput.sendKeys("2004nbg");

        WebElement enterPasswordBtn=driver.findElement(By.xpath("//button[@class='base-0-2-79 primary-0-2-93']"));
        enterPasswordBtn.click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));

        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));//*[@class='input-0-2-71']
        passwordInput.sendKeys("");

        WebElement signinBtn=driver.findElement(By.xpath("//span[@class='inner-0-2-81 innerTextWrapper-0-2-82']"));
        signinBtn.click();



        new WebDriverWait(driver, Duration.ofSeconds(700))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='2004nbg@mail.ru']")));
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(6));

        WebElement letter = driver.findElement(By.xpath("//div[@aria-label='2004nbg@mail.ru']"));
        System.out.println(letter.toString());

        Thread.sleep(8000);
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println(size);
       // driver.switchTo().frame(0);
        List<WebElement> letters=driver.findElements(By.cssSelector("a.llc llc_normal llc_new llc_new-selection js-letter-list-item js-tooltip-direction_letter-bottom"));
        int n=letters.size();
        System.out.println("писем"+n);
        Assert.assertTrue(letter!=null);
        driver.quit();

    /*    new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='search:submit']")));
    WebElement searchInput = driver.findElement(By.id("q"));
        searchInput.sendKeys("java");
    WebElement searchBtn=driver.findElement(By.xpath("//*[@id='search:submit']"));
        searchBtn.click();
        driver.manage().timeouts().setScriptTimeout(5,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1));}*/

}}
