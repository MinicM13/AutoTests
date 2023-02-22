package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.TehnomanijaCartPage;
import pages.TehnomanijaHomePage;
import pages.TehnomanijaProductPage;
import pages.TehnomanijaResultPage;

public class TehnomanijaSearchTest extends BaseTest{

  @Test
    public void searchTest() throws InterruptedException {

        String url = "https://www.tehnomanija.rs/";
        String searchTerm = "Samsung";
        String min = "30000";
        String max = "100000";
        int articleNumber = 3;


    TehnomanijaHomePage homepage = new TehnomanijaHomePage(driver);
    homepage.test(url,searchTerm);

    TehnomanijaResultPage resultpage = new TehnomanijaResultPage(driver);
    resultpage.resultTest(min,max,articleNumber);


    TehnomanijaProductPage productpage = new TehnomanijaProductPage(driver);
    productpage.productTest();


    TehnomanijaCartPage cartpage = new TehnomanijaCartPage(driver);
    cartpage.articleTitle();

    String naslov = cartpage.title;

    Assert.assertTrue("Article " + naslov +  " does not contain our search term",
            naslov.toLowerCase().contains(searchTerm.toLowerCase()));


     String fixPrice = cartpage.price().replace("  RSD","").replace(".","");
     int numberPrice = Integer.parseInt(fixPrice);
     System.out.println("Cena proizvoda pretvorena u Int je: " + numberPrice);


    Assert.assertTrue("Article " + naslov + "  is not within given range!",
            numberPrice >= Integer.parseInt(min) && numberPrice <= Integer.parseInt(max));


    }
}
