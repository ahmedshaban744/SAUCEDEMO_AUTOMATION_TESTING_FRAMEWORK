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

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
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

    @Test(priority = 7,enabled = false,groups = "Home Page")
    public void ValidateAdddToCartFunctionality() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        wait.until(ExpectedConditions.urlContains("inventory"));

        List<WebElement> addButtons = driver.findElements(By.xpath("//button[text()='Add to cart']"));

        int productCount = addButtons.size();

        for (WebElement btn : addButtons) {
            btn.click();
        }
        WebElement cartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge")));
        int actualCount = Integer.parseInt(cartBadge.getText());
        System.out.println("Expected: " + productCount);
        System.out.println("Actual: " + actualCount);
        Assert.assertEquals(actualCount, productCount);
        driver.quit();
    }
  @Test(priority = 10,enabled = false,groups = "Home Page")
  public void ValidateProductClikable() {
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

         for (WebElement item : items)

          {
               WebElement imag=item.findElement(By.className("inventory_item_img"));
               WebElement Title=item.findElement(By.className("inventory_item_name"));
               imag.click();
               driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
               Assert.assertTrue(imag.isEnabled());
               driver.navigate().back();
               driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
               Title.click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
               driver.navigate().back();
               Assert.assertTrue(Title.isEnabled());
               driver.navigate().back();
               driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

  }
    @Test(priority = 11,enabled = true,groups = "Home Page")
    public void ValidateSocialMediaLinkFunctionality() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        // Login
        driver.findElement(By.xpath("//input[@placeholder=\"Username\"]"))
                .sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@placeholder=\"Password\"]"))
                .sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));

        String mainWindow = driver.getWindowHandle();

        // Helper function logic (manual inline handling)

        // ---------------- TWITTER ----------------
        driver.findElement(By.xpath("(//a[@rel='noreferrer'])[1]")).click();

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
            }
        }

        wait.until(ExpectedConditions.urlContains("x.com"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://x.com/saucelabs");

        driver.close();
        driver.switchTo().window(mainWindow);

        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));

        // ---------------- FACEBOOK ----------------
        driver.findElement(By.xpath("(//a[@rel='noreferrer'])[2]")).click();

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
            }
        }

        wait.until(ExpectedConditions.urlContains("facebook.com"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/saucelabs");

        driver.close();
        driver.switchTo().window(mainWindow);

        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));

        // ---------------- LINKEDIN ----------------
        driver.findElement(By.xpath("(//a[@rel='noreferrer'])[3]")).click();

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
            }
        }

        wait.until(ExpectedConditions.urlContains("linkedin.com"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/company/sauce-labs/");

        driver.close();
        driver.switchTo().window(mainWindow);

        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));

        driver.quit();
    }
}



