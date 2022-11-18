package testovi.bazicni;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.PocetnaStrana;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected PocetnaStrana pocetna;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\moje stvari\\faks(ITS)\\QA\\instalacije_itd\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        goHome();
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://www.demoblaze.com/");
        pocetna = new PocetnaStrana(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
