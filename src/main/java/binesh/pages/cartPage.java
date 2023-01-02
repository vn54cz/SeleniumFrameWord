package binesh.pages;

import binesh.pageObjects.cartPageObject;
import org.openqa.selenium.WebDriver;

public class cartPage {
    WebDriver driver;

    public cartPage(WebDriver driver){
        this.driver = driver;
    }
    public Boolean verifyProductDisplay(String productName){
        cartPageObject cartPageObject = new cartPageObject(driver);
        Boolean match = cartPageObject.productTitle.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
        return(match);
    }

    public checkOutPage goToCheckOut(){
        cartPageObject cartPageObject = new cartPageObject(driver);
        cartPageObject.checkOut.click();
        checkOutPage checkOutPage = new checkOutPage(driver);
        return checkOutPage;
    }

}
