package binesh.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkOutPageObject {
    WebDriver driver;
    public checkOutPageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[placeholder='Select Country']")
    public WebElement textBox;

    @FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
    public WebElement choosingSecondOptions;

    @FindBy(css = ".action__submit")
    public WebElement submitBtn;
}
