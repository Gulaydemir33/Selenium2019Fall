package day8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

import java.util.List;

public class SearchTests {
    private WebDriver driver;

    @Test
    public void googleSearchTests(){
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        BrowserUtils.wait(5);
        List<WebElement>searchItems = driver.findElements(By.tagName("h2"));
        for(WebElement searchItem: searchItems){
            System.out.println("Title: " +searchItem.getText());

            //System.out.println(searchItem.getText());
            String var= searchItem.getText();
            //if there is a text - print it
            if(!var.isEmpty()){
                System.out.println(var);
                //verify that every search result contains java
                //is some of the seach result doesn't contain java word, it will fail the test
               Assert.assertTrue(var.toLowerCase().contains("java"));
                System.out.println(var.toLowerCase());
                System.out.println();



            }
        }

    }

    /**
     * Given user is on the amazon.com page
     * when user enters "java" as a search item
     * Then user clicks on the search button
     * user clicks on the first search item
     * user verifies that title of the search item contains "java"
     */
    @Test(description = "Search for Java book on amazon")
    public void amazonSearchTest(){
        driver.get("http://amazon.com");
        driver.manage().window().maximize();
        BrowserUtils.wait(5);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        BrowserUtils.wait(5);

        List<WebElement> searchItems = driver.findElements(By.xpath("//h2//a"));

        //click on the first item
        for(WebElement searchItem: searchItems){
            System.out.println(searchItem.getText());
        }
        searchItems.get(0).click();
        BrowserUtils.wait(5);
        WebElement productTitle = driver.findElement(By.id("title"));
        String productTitleString  = productTitle.getText();
        System.out.println(productTitleString);

        Assert.assertTrue(productTitleString.contains("Java"));

    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();

    }
    @AfterMethod
    public void teardown(){
        //close browser and destroy webdriver object
        driver.quit();

    }

}
