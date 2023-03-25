package Utlity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriverParameter {
    public static WebDriver driver;
    public static WebDriverWait wait;
    @BeforeClass
    @Parameters("browserTipi")
    public void baslangicIslemler(String browser) {
        Logger logger= Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        switch (browser.toLowerCase())
        {
            case "firefox" :
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                driver = new FirefoxDriver();
                System.out.println("firefox started");
                break;

            case "safari":
                driver=new SafariDriver();
                break;

            // case "edge":
            //  driver=new EdgeDriver();
            //  break;

            default:
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
        }
        // driver.manage().window().maximize(); // Ekranı max yapıyor.
        Duration dr=Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);
        driver.manage().timeouts().implicitlyWait(dr);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,Duration.ofSeconds(30));

    }
    @AfterClass
    public void bitisIslemler() {
        System.out.println("Bitiş işlemleri yapılıyor");
        Tools.Bekle(5);
        driver.quit();
    }
    @Test
     public void loginTest() {
        driver.get("https://admin-demo.nopcommerce.com/login?");

        WebElement email = driver.findElement(By.xpath("//input[@name='Email']"));
        email.clear();
        email.sendKeys("admin@yourstore.com");
        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.clear();
        password.sendKeys("admin");
        WebElement loginBtn = driver.findElement(By.xpath("//*[@class='button-1 login-button']"));
        loginBtn.click();

        WebElement logoutBtn = driver.findElement(By.xpath("//*[text()='Logout']"));
        wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
        Assert.assertTrue(logoutBtn.isDisplayed() , "Failed Test");

        // Assert.assertTrue(driver.getTitle().equals("My Account"));
        //Assert.assertTrue(driver.getTitle().equals("My Account"));
        //Assert.assertEquals(driver.getTitle(),"My Account", "Login olamadı");
    }
}
