package TestNGProje2;

import Utlity.BaseDriverParameter;
import Utlity.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.annotation.Target;
import java.time.Duration;
import java.util.List;

public class TestingProje extends BaseDriverParameter {

    @Test()
    public void TestCase2CheckLeftNawMenu() {
        LeftNaw ln = new LeftNaw();


        for (int i = 1; i <ln.dashBoardList.size() ; i++) {

            ln.dashBoardList.get(i).click();
            Tools.Bekle(2);
            Assert.assertTrue(ln.dashBoardList.get(i).getAttribute("class").contains("menu-is-opening"), "Wrong choice");
        }
        for (int i = 0; i < ln.dashBoardList.size(); i++) {
            Assert.assertNotNull(ln.dashBoardList.get(i).getText(), "Wrong choice");

        }

    }
    @Test
    public void TestCase3CreateCustomer() {
        LeftNaw ln = new LeftNaw();

        ln.customers1.click();
        ln.customers2.click();
        ln.addNew.click();
        ln.email.sendKeys("admin@yourstore.com");
        ln.password.sendKeys("admin");
        ln.firstName.sendKeys("kubilay");
        ln.lastName.sendKeys("culha");
        ln.genderMale.click();
        ln.dateOfBirth.sendKeys("01.01.1993");
        ln.company.sendKeys("TechnoStudy");
        ln.newsletter.click();
        wait.until(ExpectedConditions.elementToBeClickable(ln.testStore));
        ln.testStore.click();

    }
}
