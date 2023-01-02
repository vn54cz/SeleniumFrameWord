package utils;

import binesh.pageObjects.utilityPageObject;
import binesh.pages.cartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class baseComponent {
    WebDriver driver;
    public baseComponent(WebDriver driver){

        this.driver = driver;
    }
    public void waitForElementToAppear(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
    public void waitForElementToDisappear(WebElement ele){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(ele));
    }

    public cartPage goToCartPage() throws InterruptedException {
        utilityPageObject utilityPageObject = new utilityPageObject(driver);
        Thread.sleep(3000);
        utilityPageObject.cartHeader.click();
        cartPage cartPage = new cartPage(driver);
        return cartPage;
    }
}
