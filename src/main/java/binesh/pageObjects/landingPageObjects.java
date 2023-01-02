package binesh.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingPageObjects {
    WebDriver driver;

    public landingPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userEmail")
    public WebElement userEmail;

    @FindBy(id = "userPassword")
    public WebElement userPassword;

    @FindBy(id = "login")
    public WebElement loginBtn;
}
