package day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(5000);

        //every window has some id, this id calls window handle
        //based on window handle, we can switch in between windows
        String windowHandle= driver.getWindowHandle();

        System.out.println(windowHandle);
        Set<String> windowHandles= driver.getWindowHandles();

        System.out.println(windowHandles);

        //since we have all windows
        //and we know id of original window
        //we can say switch to something that is not equal to the old id



    }

}
