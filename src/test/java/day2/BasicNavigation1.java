package day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation1 {
    public static void main(String[] args) throws Exception {
        //to start selenium script we need
        //setup driver(browser driver) and create webdriver object
        WebDriverManager.chromedriver().setup();

        ChromeDriver driver = new ChromeDriver();

        //In selenium everything starts from webdriver interface
        //ChromeDriver extends RemoteWebDriver--> implements Webdriver

        driver.get("http://google.com"); //TO OPEN A WEBSITE
        driver.manage().window().maximize(); //to maximize browser

        Thread.sleep(3000);

        driver.close(); //to close the browser

        String title = driver.getTitle(); //returns <title>  Some title >/title> text
        String expectedTitle = "Google";
        System.out.println("Title is ..."+title);

        if(expectedTitle.equals(title)) {
            System.out.println("TEST PASSED!");
        }else{
            System.out.println("TEST FAILED!");

        }
        driver.navigate().to("http://amazon.com");

        if(driver.getTitle().toLowerCase().contains("amazon")) {
            System.out.println("TEST PASSED!");
        }else{
            System.out.println("TEST FAILED!");
        }
        //MUST BE AT THE END
        driver.close();
    }
    public static void verifyEquals (String arg1, String arg2){
        if (arg1.equals(arg2)) {
            System.out.println("TEST PASSED!");
        }else{
            System.out.println("TEST FAILED");

        }
    }

}
