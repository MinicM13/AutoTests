package pages;


import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class TehnomanijaResultPage extends BaseHelper {
    WebDriver driver;

    public TehnomanijaResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(className = "product-list")
    WebElement results;

    @FindBy(xpath = "//input[@placeholder='od']")
    WebElement minPriceField;

    @FindBy(xpath = "//input[@placeholder='do']")
    WebElement maxPriceField;

    @FindBy(className = "price-range--button")
    WebElement nextButton;

    @FindBy(className = "custom-facet")
    WebElement categoryComponent;

    @FindBy(xpath = "//span[normalize-space()='Telefoni']")
    WebElement phonesSelect;

    private void setMinPrice(String min) {

        wdWait.until(ExpectedConditions.visibilityOf(minPriceField));
        wdWait.until(ExpectedConditions.elementToBeClickable(minPriceField));
        minPriceField.clear();
        //  minPriceField.sendKeys(Keys.BACK_SPACE);
        wdWait.until(ExpectedConditions.elementToBeClickable(minPriceField));
        minPriceField.sendKeys(min);


    }

    private void setMaxPrice(String max) {

        wdWait.until(ExpectedConditions.elementToBeClickable(maxPriceField));
        maxPriceField.clear();
        // maxPriceField.sendKeys(Keys.BACK_SPACE);
        wdWait.until(ExpectedConditions.elementToBeClickable(maxPriceField));
        maxPriceField.sendKeys(max);

    }

    private void nextButtonClick() {

        wdWait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();

    }

    private void choosePhones() throws InterruptedException {

        // Thread.sleep(1000);

        wdWait.until(ExpectedConditions.visibilityOf(phonesSelect));
        js.executeScript("arguments[0].scrollIntoView({block:\"center\"});", phonesSelect);

        phonesSelect.click();

    }

    private void clickOnRequestedArticle(int articleNumber) throws InterruptedException {

        Thread.sleep(1000);
        wdWait.until(ExpectedConditions.visibilityOf(results));

        List<WebElement> articleList = results.findElements(By.className("product"));
        System.out.println("Broj artikala: " + articleList.size());


        articleList.removeIf(n -> n.findElement(By.className("product-carousel--info")).getText().contains("Watch"));
        System.out.println("Broj artikala koji nisu sat: " + articleList.size());

        WebElement article = articleList.get(articleNumber - 1).findElement(By.className("product-carousel")).findElement(By.tagName("a"));

        article.click();

    }

    public void resultTest(String min, String max, int articleNumber) throws InterruptedException {
        choosePhones();
        setMinPrice(min);
        setMaxPrice(max);
        nextButtonClick();
        clickOnRequestedArticle(articleNumber);
    }
}

public class TehnomanijaResultPage {
}
