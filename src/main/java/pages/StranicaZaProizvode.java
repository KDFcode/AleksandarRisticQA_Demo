package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;

import java.time.Clock;

public class StranicaZaProizvode {



    private WebDriver driver;
    private By addToCartButton = By.xpath("//*[@onclick='addToCart(1)']");

    public StranicaZaProizvode(WebDriver driver){
        this.driver = driver;
    }

    public void clickAddToCart(){
        driver.findElement(addToCartButton).click();
    }

    public String alertGetText() throws InterruptedException {
        /*WebDriverWait wait = new WebDriverWait(driver, 10); //svakako to treba da bude broj sekundi,ima i opcija za jos par
        //input argumenata ali ovaj sad ne prihvata ovo kako treba?


        wait.until(ExpectedConditions.alertIsPresent());*/

        //sto ovo zeza?
        Thread.sleep(2000);
        return driver.switchTo().alert().getText();
    }
}
