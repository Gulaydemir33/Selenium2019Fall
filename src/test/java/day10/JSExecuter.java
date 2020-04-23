package day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

public class JSExecuter {
    private RemoteWebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void scrollTest() {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();
        //you need to cast if reference type (JavaScriptExecuter) driver
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //x, y coordinates

        for (int i = 0; i < 10; i++) {
            driver.executeScript("window.scrollBy(0, 250)");


            BrowserUtils.wait(3);
        }
        BrowserUtils.wait(3);

   }
   public void scrollElementTest(){
        driver.get("http://practice.cybertekschool.com/");
       driver.manage().window().maximize();
       BrowserUtils.wait(3);
       WebElement link = driver.findElement(By.linkText("Cybertek School"));
       driver.executeScript("arguments[0].scrollIntoView(true)", link);
   }
}