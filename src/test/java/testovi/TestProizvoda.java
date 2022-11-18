package testovi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import testovi.bazicni.BaseTest;

public class TestProizvoda extends BaseTest {

    @Test  //ovde dodajemo specificne proizvode
    public void verifyAddProductToCartByName() {
        StranicaZaLogovanje loginStrana = pocetna.clickLoginPage(); //Instanciramo loginStranu tj. objekat klase tog tipa
        //preko metode pocetne stranice
        loginStrana.setUsernameField("qaProjekatUser");
        loginStrana.setPasswordField("qaProjekatPassword"); //ubacujemo informacije

        Logovanje logovanje  = loginStrana.clickLoginButton(); //klikcemo dugme

        Korpa korpa = new Korpa(driver);

        int brojProizvodaPreDodavanja = korpa.brojProizvodaUKorpi();
        int cenaProizvodaPreDodavanja = korpa.cenaProizvoda();

        MobilniStranicaPrimer Samsung =  pocetna.clickMobilni();//Samsung galaxy s6 //fon
        MonitorStranicaPrimer Apple =  pocetna.clickMonitor();//"Apple monitor 24" monitor jelte
        LaptopStranicaPrimer Sony= pocetna.clickLaptop();//Sony vaio i5 //laptop
        //dodajemo elemente

        int brojProizvodaPosleDodavanja = korpa.brojProizvodaUKorpi();
        int cenaProizvodaPosleDodavanja = korpa.cenaProizvoda();
        Assert.assertEquals(brojProizvodaPosleDodavanja, brojProizvodaPreDodavanja + 3, "Number of products is not as expected");
        //proveravamo ima li ih tu

        //moguce je i
        if (cenaProizvodaPosleDodavanja>cenaProizvodaPreDodavanja)
        {
            System.out.print("cena proizvoda nakon dodavanje je" +  Integer.toString(cenaProizvodaPosleDodavanja));
        }
        else {System.out.print("neuspesno dodavanje proizvoda");}


        //<h3 class="panel-title" id="totalp">1550</h3>


    }

}








        /*
        //ne mozes tek tako klasu da koristis za metodu,moras da instanciras klase prvo
        MobilniStranicaPrimer.clickAddToCart(); //Samsung galaxy s6 //fon
        MonitorStranicaPrimer.clickAddToCart(); //"Apple monitor 24" monitor jelte
        LaptopStranicaPrimer.clickAddToCart(); //Sony vaio i5 //laptop*/

        /*productsPage.addProductToCartByName("Samsung galaxy s6");
        productsPage.addProductToCartByName("Sony vaio i5");
        productsPage.addProductToCartByName("Apple monitor 24");*/ //osmisli moze li ovako