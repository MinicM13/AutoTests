package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.KupindoHomePage;
import pages.KupindoResultsPage;

public class KupindoSearchTest extends BaseTest{


    @Test
    public void  searchTest() throws InterruptedException {

        String url= "https://www.kupindo.com/";
        String searchTerm= "sony";
        int articleNumber = 4;
        String min = "1000";
        String max="20000";


        KupindoHomePage homepage = new KupindoHomePage(driver);


        homepage.search(url,searchTerm);

        KupindoResultsPage resultspage = new KupindoResultsPage(driver);

        resultspage.resultTest(min,max,articleNumber);
        String naslov = resultspage.title;



        WebElement resultTitle= driver.findElement(By.xpath("//h1[@class='predmet_heading hidden-xs']"));

        Assert.assertTrue("Title does not contain our search Term", resultTitle.getText().toLowerCase().contains(naslov.toLowerCase()));

    }
}
