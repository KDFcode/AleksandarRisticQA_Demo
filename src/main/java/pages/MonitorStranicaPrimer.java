package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MonitorStranicaPrimer {


    private WebDriver driver;
    private By addToCartButton = By.xpath("//*[@onclick='addToCart(1)']");

    public MonitorStranicaPrimer(WebDriver driver){
        this.driver = driver;
    }

    public void clickAddToCart(){
        driver.findElement(addToCartButton).click();
    }

    public String alertGetText() throws InterruptedException {
       /* WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());*/ //sto ovo nece?
        Thread.sleep(2000);
        return driver.switchTo().alert().getText();
    }
}
