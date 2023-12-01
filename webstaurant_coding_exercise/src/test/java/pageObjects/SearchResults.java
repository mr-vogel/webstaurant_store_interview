package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class SearchResults extends BasePage{

    public SearchResults(WebDriver driver){
        super(driver);
    }

    public enum PageElements {
        product,
        addToCart,
        goToCartBtn
    }

    public By by(PageElements element){
        switch(element){
            case product: return By.id("ProductBoxContainer");
            case addToCart: return By.cssSelector("#ProductBoxContainer > div.add-to-cart > form > div > div > input.btn.btn-cart.btn-small");
            case goToCartBtn: return By.xpath("//a[@href='/viewcart.cfm']");
            default: return null;
        }
    }

    public List<String> getProductTitles(){

        List<WebElement> products;
        List<String> productTitle = new ArrayList<String>();
        products = driver.findElements(by(PageElements.product));

        for(int i = 0; i < products.size(); i++){
            productTitle.add(getFirstLine(products.get(i).getText()));
        }
        return productTitle;
    }

    public String getFirstLine(String aString) {
        return aString.substring(0, aString.indexOf("\n"));
    }

    public boolean verifyProductTitles(List<String> list){
        boolean result = false;
        for(int i = 0; i < list.size(); i++){
             if(list.get(i).toLowerCase().contains("table")){
                 result = true;
             } else {
                 System.out.println("MISSING TITLE: " + list.get(i));
                 result = false;
                 break;
             }
        }
        return result;
    }

    public void addLastItemToCart(){
        List<WebElement> addToCartButtons;
        addToCartButtons = driver.findElements(by(PageElements.addToCart));
        addToCartButtons.get(addToCartButtons.size()-1).click();
    }

    public CartPage goToCart(){
        clickElement(by(PageElements.goToCartBtn));
        return new CartPage(driver);
    }
}