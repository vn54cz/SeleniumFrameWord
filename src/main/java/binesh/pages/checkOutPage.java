package binesh.pages;

import binesh.pageObjects.checkOutPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.baseComponent;

public class checkOutPage extends baseComponent {
    WebDriver driver;
    public checkOutPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    By countryOptions = By.cssSelector(".ta-results");

    public void enteringCountry(String countryName){
        Actions actions = new Actions(driver);
        checkOutPageObject checkOutPageObject = new checkOutPageObject(driver);
        actions.sendKeys(checkOutPageObject.textBox, countryName).build().perform();
        waitForElementToAppear(countryOptions);
    }
    public void selectingCountry(){
        checkOutPageObject checkOutPageObject = new checkOutPageObject(driver);
        checkOutPageObject.choosingSecondOptions.click();
    }

    public orderConformationPage submitBtn(){
        checkOutPageObject checkOutPageObject = new checkOutPageObject(driver);
        checkOutPageObject.submitBtn.click();
        orderConformationPage orderConformationPage = new orderConformationPage(driver);
        return orderConformationPage;
    }
}
