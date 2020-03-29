package warmup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class March4 {

    public static void main(String[] args) throws Exception {

        ebayTest();
        amazonTest();
        wikiTest();

    }

     public static void ebayTest() throws Exception {
         WebDriverManager. chromedriver().setup();
         WebDriver driver = new ChromeDriver();
        driver.get("http://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("java book");
         driver.findElement(By.id("gh-btn")).click();
         Thread.sleep(3000);
         WebElement searchResults = driver.findElement((By.tagName("h1")));
         System.out.println(searchResults.getText().split(" ") [0]);

         String[] searchSentence = searchResults.getText().split(" ");
         System.out.println(searchSentence [0]);
         driver.quit();

     }
    public static void amazonTest() throws Exception {
        WebDriverManager. chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://amazon.com");
        driver.findElement(By.id("twotabsearchtextbook")).sendKeys("java book");

        Thread.sleep(3000);

        String title = driver.getTitle();
        if(title.contains("java book")) {
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        driver.quit();
    }
        public static void wikiTest() throws Exception {
            WebDriverManager. chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://en.wikipedia.org/wiki/Main_Page");
            driver.findElement(By.id("searchInput")).sendKeys("Selenium webdriver", Keys.ENTER);
            driver.findElement(By.partialLinkText("("));
            String link = driver.getCurrentUrl();
            if(link.endsWith("Selenium_(software)")) {
                System.out.println("TEST PASSED");
            }else{
                System.out.println("TEST FAILED");
            }
            Thread.sleep(3000);
            driver.quit();
        }
    }

