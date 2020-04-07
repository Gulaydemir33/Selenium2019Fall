package day6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.BrowserUtils;

public class Xpath {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtils.wait(3);

        WebElement btn1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        btn1.click();

        WebElement result = driver.findElement(By.id("result"));
        System.out.println(result.getText());

        //click on button #2
        WebElement btn2 = driver.findElement(By.xpath("//button[text()='Button 2']"));
        btn2.click();
        System.out.println(result.getText());

        WebElement btn3 = driver.findElement(By.xpath("// button[starts-with(@id, 'button'] [3]"));
        btn3.click();
        System.out.println(result.getText());

        WebElement btn4 = driver.findElement(By.xpath("//button[contains(@id, 'button'][4]"));
        btn4.click();
        System.out.println(result.getText());

        WebElement btn5 = driver.findElement(By.xpath("//button[contains(text(), '5')]"));
        btn5.click();
        System.out.println(result.getText());


        BrowserUtils.wait(3);
        driver.quit();
    }}