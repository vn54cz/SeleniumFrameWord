package bineshTest;

import binesh.data.testData;
import binesh.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import testComponent.baseTest;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class standaloneTestScripts extends baseTest {

   @Test
   public void submitOrder() throws IOException, InterruptedException {
        productCatolog productCatolog = landingPage.loginApplication(testData.email, testData.password);

        List<WebElement> product = productCatolog.getProductList();
        productCatolog.printProduct(product);
        productCatolog.addProductToCart(testData.productName);
        cartPage cartPage = productCatolog.goToCartPage();

        Boolean match = cartPage.verifyProductDisplay(testData.productName);
        Assert.assertTrue(match);
        checkOutPage checkOutPage = cartPage.goToCheckOut();

        checkOutPage.enteringCountry(testData.country);
        checkOutPage.selectingCountry();
        orderConformationPage orderConformationPage = checkOutPage.submitBtn();

        String confirmMessage = orderConformationPage.orderConformationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase(testData.orderConfirmMessage));
        Thread.sleep(10000);

    }
}
