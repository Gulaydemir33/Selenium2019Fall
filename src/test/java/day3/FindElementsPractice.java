package day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.DriverFactory;

public class FindElementsPractice {
    public static void main(String[] args) {

        WebDriverManager. chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //WebDriver driver= DriverFactory.createADriver("chrome");

        driver.get ("http://practice.cybertekschool.com/signup");

        driver. quit();
        //to close everything
    }
}
