package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.SearchResults;

import java.util.List;

public class InterviewTestCase extends BaseTestCase {

    @Test
    public void interviewTestCase(){
        HomePage h = new HomePage(driver);
        SearchResults s;
        CartPage c;

        List<String> productTitles;
        //2. Search for stainless work table
        s = h.search("stainless work table");

        //3. Check the search result ensuring every product has the word Table in its title.
        productTitles = s.getProductTitles();
        boolean result = s.verifyProductTitles(productTitles);
       Assert.assertTrue(result);

        //4. Add the last of found items to Cart.
        s.addLastItemToCart();
        c = s.goToCart();

        //5. Empty Cart.
        c.emptyCart();

        //Check cart is empty
        Assert.assertTrue(c.checkEmptyCart());
        }
}