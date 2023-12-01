package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
    }

    public enum PageElements {
        searchField,
        searchButton
    }

    public By by(PageElements element){
        switch(element){
            case searchField: return By.id("searchval");
            case searchButton: return By.cssSelector("#searchForm > div > button");
            default: return null;
        }
    }

    public SearchResults search(String searchText){
        clickElement(by(PageElements.searchField));
        enterText(by(PageElements.searchField), searchText);
        clickElement(by(PageElements.searchButton));
        return new SearchResults(driver);
    }
}