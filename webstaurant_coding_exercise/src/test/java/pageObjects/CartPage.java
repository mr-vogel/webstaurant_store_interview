package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public enum PageElements {
        removeItem,
        emptyText

    }

    public By by(PageElements element){
        switch(element){
            case removeItem: return By.cssSelector("div.itemDelete > button");
            case emptyText: return By.cssSelector("#main > div > div.cartEmpty > div.box.padded.box--empty > div > div.empty-cart__text > p.header-1");
            default: return null;
        }
    }

    public void emptyCart() {
        clickElement(by(PageElements.removeItem));
    }

    public boolean checkEmptyCart(){
        String emptyCartText = getText(by(PageElements.emptyText));
        return emptyCartText.contains("Your cart is empty.");
    }
}