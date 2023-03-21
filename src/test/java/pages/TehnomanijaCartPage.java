package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TehnomanijaCartPage extends BaseHelper {

    WebDriver driver;

    public TehnomanijaCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    public String title;

    public void articleTitle() {




        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("cart-item-name")));
        String naslov = driver.findElement(By.className("cart-item-name")).getText();
        System.out.println("Naziv modela: " + naslov);

        title = naslov;

    }

    public String price() {


        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("cart-item-totalPrice")));
        String cena = driver.findElement(By.className("cart-item-totalPrice")).getText();
        System.out.println("Cena proizvoda je: " + cena);

        return cena;
    }

}



