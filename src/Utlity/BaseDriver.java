package Utlity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;
    @BeforeClass
    public void baslangicIslemler() {
        Logger logger= Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize(); // Ekranı max yapıyor.
        Duration dr=Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);
        driver.manage().timeouts().implicitlyWait(dr);
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
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        WebElement inputEmail = driver.findElement(By.id("input-email"));
        inputEmail.sendKeys("kubilay__culha@hotmail.com");

        WebElement inputPassword = driver.findElement(By.id("input-password"));
        inputPassword.sendKeys("Asdasdpls111");

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        loginButton.click();

        Assert.assertTrue(driver.getTitle().equals("My Account"));
        //Assert.assertTrue(driver.getTitle().equals("My Account"));
        //Assert.assertEquals(driver.getTitle(),"My Account", "Login olamadı");
    }
}
