package day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.DriverFactory;

import java.util.List;

public class WebOrders {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public  void setup(){
        driver = DriverFactory.createADriver("chrome");
        wait = new WebDriverWait(driver, 10);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders");
        driver. findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver. findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);
    }
    @Test
    public  void checkBoxTest(){
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        BrowserUtils.wait(2);
        List<WebElement>checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        for(WebElement checkbox: checkboxes){
            Assert.assertTrue(checkbox.isSelected());
        }
    }
    @Test
    public void updateZipCode(){
         WebElement zipcode = driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td[7] "));
         Assert.assertEquals(zipcode.getText(), "21233");

         driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td/input"));
         WebElement zipcodeInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
         zipcodeInput.clear();
         zipcodeInput.sendKeys("20002");
         zipcode=driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td/input"));
       driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();
        Assert.assertEquals(zipcode.getText(), "20002");
    }

    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(2);
        driver.quit();
    }
}
