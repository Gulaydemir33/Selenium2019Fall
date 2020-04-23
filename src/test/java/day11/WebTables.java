package day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class WebTables {
    private WebDriver driver;

    @BeforeMethod

    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true); //to run the browser without GUI
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(2);
        driver.quit();
    }
    @Test
    public void getColumnNames(){
        //th - represents table header cells
        List<String>expected = Arrays.asList("Last Name","First Name", "Email", "Due", "Web Site", "Action");
        List<WebElement>columnNames = driver.findElements(By.xpath("//table[1]//th"));
        //just to print
        for(WebElement columnName : columnNames){
            System.out.println(columnName.getText());
        }
        Assert.assertEquals(BrowserUtils.getTextFromWebElements(columnNames),expected);

    }

    @Test
    public void verifyRowCount(){
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//"));

        Assert.assertEquals(rows.size(),4);
    }
    @Test
    public void getSpecificColumn(){
        List<WebElement>links = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        System.out.println(BrowserUtils.getTextFromWebElements(links));
    }
   public void deleteRowTest(){
        String xpath = "//table[1]//td[text()='jsmith@gmail.com']/..//a[text()='delete']";
        driver.findElement(By.xpath(xpath)).click();

       BrowserUtils.wait(2);

        //get count of rows
        int rowCount = driver.findElements(By.xpath("//table[1]//tbody//tr")).size();

        Assert.assertEquals(rowCount,3);
        List<WebElement> emails = driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']"));
        Assert.assertTrue(driver.findElements(By.xpath("//td[text()='jsmith@gmail.com']")).isEmpty());
   }
   @Test
   public void getColumnIndexByName(){
        String columnName = "Email";

        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));

        int index = 0;
       for (int i = 0; i <columnNames.size() ; i++) {

           String actualColumnName = columnNames.get(i).getText();
           System.out.println(String.format("%s, positions", actualColumnName, i));
           if(columnNames.get(i).getText().equals(columnName)){
               index = i +1;
               break;
           }

       }
       Assert.assertEquals(index, 3);
   }
   @Test
    public void getSprecificCell(){
        String expected = "http://www.jdoe.com";

        int row = 3;
        int column = 5;
        String xpath = "//table[1]//tbody//tr[" + row +"]//td[" + column + "]";

        WebElement cell = driver.findElement(By.xpath(xpath));

        Assert.assertEquals(cell.getText(), expected);
   }
}
