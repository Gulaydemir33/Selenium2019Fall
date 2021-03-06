package day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.BrowserUtils;

import java.util.List;

public class CheckBoxes {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/checkboxes");
        driver.manage().window().maximize();
        BrowserUtils.wait(5);

        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
        checkBoxes.get(0).click(); //click on first checkbox

        BrowserUtils.wait(5);

        for (int i = 0; i < checkBoxes.size(); i++) {


            if (!checkBoxes.get(i).isDisplayed() && checkBoxes.get(1).isEnabled() && (!checkBoxes.get(1).isSelected())) {

                checkBoxes.get(1).click(); //click on the second checkbox
                System.out.println("checkbox was clicked!");

            }else{
                System.out.println(i+1 +"checkbox wasn't clicked!");

                BrowserUtils.wait(5);

                driver.quit();

            }
        }
    }}
