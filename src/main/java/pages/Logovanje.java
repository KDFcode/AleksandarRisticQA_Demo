package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logovanje {

    private WebDriver driver;
    private By loginResult = By.linkText("Log out");

    public Logovanje(WebDriver driver) {
        this.driver = driver;
    }

    public String getLoginResult(){
        return driver.findElement(loginResult).getText();
    }

}
