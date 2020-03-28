package day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get ("http://google.com");
        Thread.sleep(5000);
        //By.name(q)--> name= "q"

        WebElement seach=driver.findElement(By.name("q"));
        //once we find an element, how to enter text?
        //to enter the text, use sendKeys () method
        //how to press enter after entering text?
        //use Key.ENTER
        //Key.ENTER- performs ketbord click
        seach.sendKeys("Java", Keys.ENTER);

        WebElement news = driver.findElement(By.linkText("News"));
        news.click();//to click on the element

        Thread.sleep(2000);

                driver. quit();

    }
}
