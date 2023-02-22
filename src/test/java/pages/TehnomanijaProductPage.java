package pages;


import helpers.BaseHelper;
import org.hamcrest.Factory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TehnomanijaProductPage extends BaseHelper {
    WebDriver driver;
    public TehnomanijaProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(className = "ProductDetailsPageTemplate")
    WebElement productInfo;

    @FindBy(className = "MiniCartSlot")
    WebElement miniCartComponent;

    @FindBy (className = "minicart--dropdown")
    WebElement endShopingDropdown;



    private void addProductToBag() throws InterruptedException {
        Thread.sleep(1000);

        wdWait.until(ExpectedConditions.visibilityOf(productInfo));
        WebElement addToBag = productInfo.findElement(By.className("add-to-cart-btn"));

        js.executeScript("arguments[0].scrollIntoView({block:\"center\"});",addToBag);
        wdWait.until(ExpectedConditions.elementToBeClickable(addToBag));
        addToBag.click();
    }

    private void goToBag() throws InterruptedException {

        Thread.sleep(1000);

        wdWait.until(ExpectedConditions.visibilityOf(miniCartComponent));
        WebElement toBag = miniCartComponent.findElement(By.className("minicart-component-shopping-bag")).findElement(By.className("mini-cart-popover--icon")).findElement(By.className("tehnomanijaMinicart"));
        // wdWait.until(ExpectedConditions.invisibilityOf(endShopingDropdown));

        //js.executeScript("arguments[0].scrollIntoView({block:\"center\"});",toBag);
        wdWait.until(ExpectedConditions.elementToBeClickable(toBag));

        toBag.click();

    }


    public void productTest() throws InterruptedException {
        addProductToBag();
        goToBag();
    }
}

