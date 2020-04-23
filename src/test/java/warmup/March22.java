package warmup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

import java.util.List;

public class March22 {

    @Test
            public void test() {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/tables");
        //click on column name
        driver.findElement(By.xpath("//table[1]//*[text()='Last Name']")).click();
        BrowserUtils.wait(2);
        //collect all values from the first column
        List<WebElement>column = driver.findElements(By.xpath("//table[1]//tbody//td[1]"));

        for (int i = 0; i <column.size() ; i++) {
            String value = column.get(i).getText();
            String nextValue = column.get(i+1).getText();
            System.out.println(value.compareTo(nextValue));

            //if difference is negative- order value is before
            Assert.assertTrue(value.compareTo(nextValue)<=0);

        }
        driver.quit();
    }
}
