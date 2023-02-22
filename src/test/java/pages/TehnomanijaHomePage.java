package pages;


import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TehnomanijaHomePage extends BaseHelper {
    WebDriver driver;

    public TehnomanijaHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy (className = "searchbox" )
    WebElement searchComponent;
    private void navigateToPage(String url){

        driver.get(url);
    }
    private void searchFieldInput(String searchTerm){
        wdWait.until(ExpectedConditions.visibilityOf(searchComponent));
        WebElement searchField = searchComponent.findElement(By.className("ng-valid"));
        searchField.sendKeys(searchTerm);

    }
    private void searchbuttonclick(){
        wdWait.until(ExpectedConditions.visibilityOf(searchComponent));
        WebElement searchButton = searchComponent.findElement(By.className("thm-search"));
        searchButton.click();
    }


    public void test(String url, String searchTerm){
        navigateToPage(url);
        searchFieldInput(searchTerm);
        searchbuttonclick();

    }
}

