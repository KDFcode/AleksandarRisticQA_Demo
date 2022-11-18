package testovi;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.Logovanje;
import pages.PocetnaStrana;
import pages.StranicaZaLogovanje;
import testovi.bazicni.BaseTest;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestLogovanja  extends BaseTest {


    @Test
    public void testSucessfulLogin(){



        StranicaZaLogovanje loginStrana = pocetna.clickLoginPage(); //Instanciramo loginStranu tj. objekat klase tog tipa
        //preko metode pocetne stranice
        loginStrana.setUsernameField("qaProjekatUser");
        loginStrana.setPasswordField("qaProjekatPassword"); //ubacujemo informacije

        Logovanje logovanje  = loginStrana.clickLoginButton(); //klikcemo dugme

        assertTrue(logovanje.getLoginResult().contains("Log out"), "Login works"); //ako ima log-out opciju onda je sve ok
        //jer na demoblaze sajtu nema logout opcije dok se ne ulogujemo
        //konceptualno moze i da se proveri ima li 'log in' i ako ima onda da bude poruka da ne radi
        //ili da proveri je li tekst polje u navbaru za ime korisnika popunjeno,ako da,isto onda znaci test neuspesan

        driver.quit();
    }


    @Test
    public void testUnSucessfulLogin(){



        StranicaZaLogovanje loginStrana = pocetna.clickLoginPage(); //Instanciramo loginStranu tj. objekat klase tog tipa
        //preko metode pocetne stranice
        loginStrana.setUsernameField("qaProjekatUserNeregistrovan");
        loginStrana.setPasswordField("qaProjekatPasswordLos"); //ubacujemo informacije

        Logovanje logovanje  = loginStrana.clickLoginButton(); //klikcemo dugme

        assertFalse(logovanje.getLoginResult().contains("Log out"), "Login failed"); //ako nema logout opcije znaci
        //da nije uspelo
        // jer na demoblaze sajtu nema logout opcije dok se ne ulogujemo
        driver.quit();

    }
}





        /*WebDriver driver = null; //pravimo driver cisto da mozemo da ga iskoristimo
        PocetnaStrana pocetna = new PocetnaStrana(driver); //instanciramo pocetnu
        StranicaZaLogovanje  loginStrana = pocetna.clickLoginPage(); //instanciramo login modalni prozor kroz
        //kombinovanje login stranice i metode klase pocetne stranice*/

//pitaj sto tako to zeza naknadno?