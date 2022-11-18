import org.openqa.selenium.WebDriver;

public class driverKlasica{

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public driverKlasica(WebDriver driver) {
        this.driver = driver;
    }
}
