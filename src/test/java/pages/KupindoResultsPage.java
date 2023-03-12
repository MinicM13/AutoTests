package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class KupindoResultsPage extends BaseHelper {

    WebDriver driver;
    public KupindoResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id="container_right")
    WebElement results;

    @FindBy(xpath = "//div[normalize-space()='Cena']")
    WebElement cenaDugme;


    @FindBy (xpath = "//input[@id='CenaOd']")
    WebElement cenaOd;

    @FindBy(xpath = "//input[@id='CenaDo']")
    WebElement cenaDo;

    @FindBy (className = "predmet_details")
    WebElement details ;


    public String title;


    private void setMinMaxPrice(String min, String max){

        wdWait.until(ExpectedConditions.visibilityOf(cenaDugme));

        js.executeScript("arguments[0].scrollIntoView({block:\"center\"});",cenaDugme);

        cenaDugme.click();

        cenaOd.sendKeys(min);

        cenaDo.sendKeys(max);
    }
    private void clickOnRequestedArticle(int articleNumber){

        wdWait.until(ExpectedConditions.visibilityOf(results));

        List<WebElement> listOfArticles = results.findElements(By.className("product"));

        WebElement article = listOfArticles.get(articleNumber-1).findElement(By.className("item_link"));

       // WebElement articlePrice = listOfArticles.get(articleNumber-1).findElement(By.className("item_price"));

        title = article.getText();

       // System.out.println(title);

        article.click();
    }

    public String cena() {

        wdWait.until(ExpectedConditions.visibilityOf(details));

        String cena = driver.findElement(By.className("input-group-addon ")).getText();

        return cena;



    }


        public void resultTest(String min,String max, int articleNumber){
        setMinMaxPrice(min,max);
        clickOnRequestedArticle(articleNumber);
    }
}
