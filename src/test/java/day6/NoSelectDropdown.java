package day6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.BrowserUtils;

import java.util.List;

public class NoSelectDropdown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");

        BrowserUtils.wait(3);
        driver.findElement(By.id("dropdownMenuLink")).click(); //to expand dropdown
        //<a class="dropdown-item" href="https://www.amazon.com/">Amazon</a>
        BrowserUtils.wait(3);
        List<WebElement> allLinks = driver.findElements(By.className("dropdown-item"));
        for(WebElement link: allLinks){
            System.out.println(link.getText()+":"+link.getAttribute("href"));
        }
        //driver.findElement(By.linkText("Amazon")).click(); //click on option
        driver.findElement(By.linkText("Google")).click();

        BrowserUtils.wait(3);

        driver.quit();

        //there are two types of drop-downs: select and other


}}
