package invalid;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

public class loggin {

    @Test
    public void invalidlogin() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement drobdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        drobdown.click();
        Select s1 = new Select(drobdown);
        s1.selectByIndex(2);
    }

}