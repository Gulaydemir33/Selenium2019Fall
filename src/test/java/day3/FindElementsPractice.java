package day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import utilities.DriverFactory;

public class FindElementsPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager. chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //WebDriver driver= DriverFactory.createADriver("chrome");

        driver.get ("http://practice.cybertekschool.com/sign_up");
        WebElement fullname = driver.findElement(By.name("full_name"));
        fullname.sendKeys("Mister Twister");

        Thread.sleep(2000);

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("sdet@cybertek.com");
        Thread.sleep(2000);

       WebElement signUp = driver.findElement(By.name("wooden_spoon"));
       signUp.click();
       //signUp.submit(); -->same thing
        Thread.sleep(2000);

        String expected = "Thank you for signing up. Click the button below to return to the home  page.";
        WebElement message = driver. findElement(By.className("subheader"));

        String actual= message.getText();

        if(expected.equals(actual)) {
            System.out.println("TEST PASSED!");
        }else{
            System.out.println("TEST FAILED!");
        }



        driver. quit();
        //to close everything
    }
}
