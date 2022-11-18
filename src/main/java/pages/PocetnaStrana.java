package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PocetnaStrana {


    private WebDriver driver;


    public PocetnaStrana(WebDriver driver) {
        this.driver = driver;
    }

    public  StranicaZaLogovanje clickLoginPage(){
        clickLink("Log in");
        return new StranicaZaLogovanje(driver);
    }



    public MobilniStranicaPrimer clickMobilni(){
        clickLink("Samsung galaxy s6");
        return new MobilniStranicaPrimer(driver);
    }

    public MonitorStranicaPrimer clickMonitor(){
        clickLink("Apple monitor 24");
        return new MonitorStranicaPrimer(driver);
    }

    public LaptopStranicaPrimer clickLaptop(){
        clickLink("Sony vaio i5");
        return new LaptopStranicaPrimer(driver);
    }

    public Korpa clickCart(){
        clickLink("Cart");
        return new Korpa(driver);
    }

    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

}
