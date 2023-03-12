package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class KupindoHomePage extends BaseHelper {

    WebDriver driver;
    public KupindoHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy (id = "txtPretraga")
    WebElement searchField;

    @FindBy(id="search_button")
    WebElement searchButton;

    private void navigateToPage(String url){
        driver.get(url);
    }

    private void searchFieldInput(String searchTerm){
        wdWait.until(ExpectedConditions.elementToBeClickable(searchField));
        searchField.sendKeys(searchTerm);

    }

    private void searchButtonClick(){

        wdWait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();

    }
    public void search(String url, String searchTerm){


        navigateToPage(url);
        searchFieldInput(searchTerm);
        searchButtonClick();

    }
}
