package day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.BrowserUtils;

public class RadioButtonsTest {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();

        BrowserUtils.wait(3);

        //<input type=> "radio" id="black" name="color'
        WebElement blackButton = driver.findElement(By.id("black"));


        if (blackButton.isDisplayed() && blackButton.isEnabled()) {
            System.out.println("CLICKED ON BLACK BUTTON");
            blackButton.click();
        } else {
            System.out.println("FAILED TO CLICK ON BLACK BUTTON");

            //returns true, if button is clicked
            if (blackButton.isSelected()) {
                System.out.println(("TEST PASSED!"));
            } else {
                System.out.println("TEST FAILED!");
            }
        }


            driver.quit();
        }
    }