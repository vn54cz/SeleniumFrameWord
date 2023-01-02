package binesh.pages;

import binesh.pageObjects.orderConformationPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class orderConformationPage {
    WebDriver driver;
    public orderConformationPage(WebDriver driver){
        this.driver = driver;
    }
    public String orderConformationMessage(){
        orderConformationPageObject orderConformationPageObject = new orderConformationPageObject(driver);
        String confirmMessage = orderConformationPageObject.orderConfirmationMessage.getText();
        return confirmMessage;

    }
}
