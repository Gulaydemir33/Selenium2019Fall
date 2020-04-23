package day8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

import java.util.List;

public class PracticeTests {
    private WebDriver driver;

    @Test
    public void loginTest(){
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(5);
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword", Keys.ENTER);

        BrowserUtils.wait(5);
        String expected = "Welcome to the Secure Area. When you are done click logout below";
        String actual = driver.findElement(By.className("subheader")).getText();

        Assert.assertEquals(actual, expected, "Sub-header message is not matching!");
    }
    //Given user is on the practice landing page
    //when user navigates to /"forgot password" page
    //Then user enters his email
    //clicks "retrieve password" button
    //user verifies that message "your e-mail has been sent!" is displayed

    @Test
    public void forgotPasswordTest(){
        driver.findElement(By.linkText("Forgot Password")).click();
        BrowserUtils.wait(5);
        driver.findElement(By. name("email")).sendKeys("testemail.com", Keys.ENTER);
        BrowserUtils.wait(3);

        String actual = driver.findElement(By.name("confirmation_message")).getText();
        String expected = "Your e-mail's been sent!";
        Assert.assertEquals(actual, expected, "Confirmation message is not valid!");
    }

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        //
        ChromeOptions chromeOptions = new ChromeOptions();
        //to ignore "your connection is not private issue
        chromeOptions.setAcceptInsecureCerts(true);
        //provide chromeOptions object into chromedriver constructor
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com");
        driver.manage().window().maximize();
    }

        @Test
                public void checkboxTest1(){
            driver.findElement(By.linkText("Checkboxes")).click();
            //locator for specific checkbox, xpath: //input[1], cssSelector: input:nth-of-type(1)
            //collect all checkboxes
            List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
            BrowserUtils.wait(4);

            checkboxes.get(0).click(); //to click on 1st checkbox

            Assert.assertTrue(checkboxes.get(0).isSelected(), "Checkbox #1 is not selected!");

        }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
