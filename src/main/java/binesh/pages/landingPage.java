package binesh.pages;

import binesh.data.testData;
import binesh.pageObjects.landingPageObjects;
import org.openqa.selenium.WebDriver;
import utils.baseComponent;

public class landingPage extends baseComponent {
    WebDriver driver;
    testData testData = new testData();
    public landingPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    public productCatolog loginApplication(String email, String password){
        landingPageObjects land = new landingPageObjects(driver);
        land.userEmail.sendKeys(email);
        land.userPassword.sendKeys(password);
        land.loginBtn.click();
        productCatolog productCatolog = new productCatolog(driver);
        return productCatolog;
    }

    public void goToUrl(){
        driver.get(testData.url);
    }
}
