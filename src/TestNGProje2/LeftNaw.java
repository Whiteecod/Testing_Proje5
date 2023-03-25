package TestNGProje2;

import Utlity.BaseDriverParameter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LeftNaw {

    public LeftNaw() {
        PageFactory.initElements(BaseDriverParameter.driver , this);
    }

    @FindBy (xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column nav-legacy']/li")
    public List<WebElement> dashBoardList;

    @FindBy(xpath = "//i[@class='nav-icon far fa-user']")
    public WebElement customers1;

    @FindBy(xpath = "//*[text()=' Customers']")
    public WebElement customers2;

    @FindBy(xpath = "//i[@class='fas fa-plus-square']")
    public WebElement addNew;

    @FindBy(css = "input[id='Email']")
    public WebElement email;

    @FindBy(css = "input[id='Password']")
    public WebElement password;

    @FindBy(id = "FirstName")
    public WebElement firstName;

    @FindBy(id = "LastName")
    public WebElement lastName;

    @FindBy(id = "Gender_Male")
    public WebElement genderMale;

    @FindBy(id = "DateOfBirth")
    public WebElement dateOfBirth;

    @FindBy(id = "Company")
    public WebElement company;

    @FindBy(id = "//div[@class='k-multiselect-wrap k-floatwrap']")
    public WebElement newsletter;

    @FindBy(id = "//*[text()='Test store 2']")
    public WebElement testStore;

}
