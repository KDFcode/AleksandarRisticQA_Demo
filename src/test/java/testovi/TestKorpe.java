package testovi;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import testovi.bazicni.BaseTest;

public class TestKorpe extends BaseTest {



    @Test
    public void readTableData() {
        StranicaZaLogovanje loginStrana = pocetna.clickLoginPage(); //Instanciramo loginStranu tj. objekat klase tog tipa
        //preko metode pocetne stranice
        loginStrana.setUsernameField("qaProjekatUser");
        loginStrana.setPasswordField("qaProjekatPassword"); //ubacujemo informacije
        Logovanje logovanje  = loginStrana.clickLoginButton(); //klikcemo dugme

        Korpa korpa = new Korpa(driver);//instanciramo nama novu korpu
        MobilniStranicaPrimer Samsung =  pocetna.clickMobilni();//Samsung galaxy s6 //fon
        MonitorStranicaPrimer Apple =  pocetna.clickMonitor();//"Apple monitor 24" monitor jelte
        LaptopStranicaPrimer Sony= pocetna.clickLaptop();//Sony vaio i5 //laptop
        //dodajemo elemente

        List<HashMap<String, String>> tableMap =  korpa.dajPodatkeIzTabele(); //  koristimo metodu za preuzimanje podataka iz tabele
        //koristeci instancu klase korpa da napunimo hashmapu cije podatke mozemo ispisati
        //System.out.println(tableMap.toString());

        if (korpa.dajPodatkeIzCelijeTabele("Title", 2).isEmpty() &&
                korpa.dajPodatkeIzCelijeTabele("Price", 3).isEmpty())
        {System.out.println("Nema nicega u korpi");
        }
        else
        {System.out.println(korpa.dajPodatkeIzCelijeTabele("Title", 2)); //jer prvi red je slika
            System.out.println(korpa.dajPodatkeIzCelijeTabele("Price", 3));
            //ispisujemo podatke iz korpe tj tabele u slucaju da su prisutni
        }


    }

}
