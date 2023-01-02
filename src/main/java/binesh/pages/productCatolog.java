package binesh.pages;

import binesh.data.testData;
import binesh.pageObjects.productCatalogObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.baseComponent;

import java.util.List;

public class productCatolog extends baseComponent {
    WebDriver driver;
    public productCatolog(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    By productsBy = By.cssSelector(".mb-3");
    By addToCart = By.cssSelector(".card-body button:last-of-type");
    By toastMessage = By.cssSelector("#toast-container");
    public List<WebElement> getProductList(){
        productCatalogObject productCatalogObject = new productCatalogObject(driver);
        waitForElementToAppear(productsBy);
        List<WebElement> products = productCatalogObject.products;
        return products;
    }

    public void printProduct(List <WebElement> product){
        for(int i = 0 ; i<product.size() ; i++){
            System.out.println(product.get(i).findElement(By.tagName("b")).getText());
        }
    }

    public WebElement getProductByName(String productName){
        WebElement prod = getProductList().stream().filter(item->
                item.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        return prod;
    }

    public void addProductToCart(String productName){
        WebElement prod = getProductByName(productName);
        prod.findElement(addToCart).click();
        waitForElementToAppear(toastMessage);
        waitForElementToDisappear(productCatalogObject.spinner);
    }

}
