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
import org.testng.annotations.*;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class logginPage {

    @DataProvider(name = "loginValidData")
    public Object[][] getData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},

                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"error_user", "secret_sauce"},
                {"visual_user", "secret_sauce"}
        };
    }

    @Test(priority = 1, enabled = false, dataProvider = "loginValidData", groups = "Smoke")
    public void ValidateLoginWithCorrectData(String usernames, String passwords) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.xpath("//input[@placeholder=\"Username\"]"));
        username.sendKeys(usernames);
        WebElement password = driver.findElement(By.xpath("//input[@placeholder=\"Password\"]"));
        password.sendKeys(passwords);
        WebElement Button = driver.findElement(By.xpath("//input[@type=\"submit\"]"));

        Button.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String Expectet = driver.getCurrentUrl();
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
        String Actual = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(Actual, Expectet);
        driver.quit();
    }

    @Test(priority = 2, enabled = false, groups = "UI")
    public void ValidateLoginButtonISClickable() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement Button = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        boolean click = Button.isEnabled() && Button.isDisplayed();
        Assert.assertTrue(click);
        driver.quit();
    }
@Test(priority = 5,enabled = false,groups = "UI")
    public void ValidateLoginPageResponsive() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
       driver.manage().window().minimize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.close();
    }
@Test(priority = 5, enabled = true,groups = "Home Page")
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
    WebElement Burrger2 = driver.findElement(By.id("react-burger-menu-btn"));
    Burrger2.click();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    WebElement menue2 = driver.findElement(By.className("bm-menu"));

    WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait3.until(ExpectedConditions.visibilityOf(menue2));
    WebElement closs = driver.findElement(By.xpath("//button[@id='react-burger-cross-btn']"));
    closs.click();
   WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
   wait2.until(ExpectedConditions.invisibilityOf(menue2));
    boolean click = menue2.isDisplayed();
    Assert.assertFalse(click);

}
@Test(priority = 6,enabled = false)
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
    }






