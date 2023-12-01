package testCase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTestCase {

    public WebDriver driver = null;


    @BeforeClass()
    public void initialize(){
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);

        //1. Go to https://www.webstaurantstore.com/
        driver.get("https://www.webstaurantstore.com/");
    }

    @AfterClass()
    public void shutDown(){
        driver.quit();
    }
}