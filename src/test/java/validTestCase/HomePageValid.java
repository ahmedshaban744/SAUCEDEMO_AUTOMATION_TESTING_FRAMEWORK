package validTestCase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HomePageValid {

    @Test(priority = 5, enabled = false,groups = "Home Page")
    public void ValidateBurrgerMenueFunctionality()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.xpath("//input[@placeholder=\"Username\"]"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@placeholder=\"Password\"]"));
        password.sendKeys("secret_sauce");
        WebElement Button = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        Button.click();
        WebElement Burrger = driver.findElement(By.id("react-burger-menu-btn"));
        Burrger.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement menue = driver.findElement(By.className("bm-menu"));
        Assert.assertTrue(menue.isDisplayed());
        WebElement About = driver.findElement(By.id("about_sidebar_link"));
        About.click();
        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait4.until(ExpectedConditions.urlToBe("https://saucelabs.com/"));
        String ExpectednewPage=driver.getCurrentUrl();
        String ActualnewPage="https://saucelabs.com/";
        Assert.assertEquals(ActualnewPage,ExpectednewPage);
        driver.navigate().back();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
        driver.findElement(By.id("react-burger-menu-btn")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement menue2 = driver.findElement(By.className("bm-menu"));
        driver.findElement(By.className("bm-menu")).click();

        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait3.until(ExpectedConditions.visibilityOf(menue2));
        driver.findElement(By.xpath("//button[@id='react-burger-cross-btn']")).click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.invisibilityOf(menue2));
        boolean click = menue2.isDisplayed();
        Assert.assertFalse(click);
    }
    @Test(priority = 6, enabled = false, groups = "Home Page")
    public void ValidateLogoutFuncality() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.xpath("//input[@placeholder=\"Username\"]"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@placeholder=\"Password\"]"));
        password.sendKeys("secret_sauce");
        WebElement Button = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        Button.click();
        WebElement Burrger = driver.findElement(By.id("react-burger-menu-btn"));
        Burrger.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement menue = driver.findElement(By.className("bm-menu"));
        WebElement Logout = driver.findElement(By.id("logout_sidebar_link"));
        Logout.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/");
        driver.quit();
    }

    @Test(priority = 7,enabled = true,groups = "Home Page")
    public void ValidateAdddToCartFunctionality()
    {
        int Product_Count=0;
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.xpath("//input[@placeholder=\"Username\"]"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@placeholder=\"Password\"]"));
        password.sendKeys("secret_sauce");
        WebElement Button = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        Button.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
        List<WebElement> items = driver.findElements(By.className("inventory_item"));
        for (WebElement item : items) {

            String name = item.findElement(By.className("inventory_item_name")).getText();
            System.out.println(name);
            WebElement AddButton=item.findElement(By.tagName("button"));
            if(AddButton.isDisplayed()&&AddButton.getText().equals("Add to cart"))
            {
                AddButton.click();
                Product_Count++;
            }
        }
        WebElement CartCount =driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
        int Expected =Integer.parseInt(CartCount.getText());
        System.out.println(Expected);
        System.out.println(CartCount.getText());
         Assert.assertEquals(Expected,Product_Count);
    }
}
