package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Korpa {
    private WebDriver driver;

    @FindBy(id= "totalp")
    private WebElement total; //<h3 class="panel-title" id="totalp">1550</h3> //odatle lako preuzimam ukupnu cenu

    public Korpa(WebDriver driver) {
        this.driver = driver;
    }

    //<tr class="success"><td><img width="100" height="100" src="imgs/galaxy_s6.jpg"></td><td>Samsung galaxy s6</td><td>360</td><td><a href="#" onclick="deleteItem('f097faa7-7ec7-8034-3025-ab1f7e70e898')">Delete</a></td></tr>
    public int brojProizvodaUKorpi() {

        int toReturn;

        int brojac=0;

        WebElement table = this.dajTablu();

        List<WebElement> rowsList = table.findElements(By.xpath(".//tr"));
        for(int i = 0; i < rowsList.size(); i++) {
            brojac= brojac+1;
            //ako prosto prebrojim sve redove tabele, time prebrojim svaki zasebni proizvod
        }

        if(brojac == 0) {
            toReturn = 0;
        }
        else {
            toReturn = brojac;
        }
        return toReturn;
    }

    public int cenaProizvoda() {

        int toReturn;
       int cena=0;
       String cenaTekst= total.getText();
        cena= Integer.parseInt(cenaTekst);
        if(cena == 0) {
            toReturn = 0;
        }
        else {
            toReturn = cena;
        }
        return toReturn;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    //<table class="table table-bordered table-hover table-striped">
    //            <thead>
    //              <tr>
    //                <th width="120">Pic</th>
    //                <th>Title</th>
    //                <th>Price</th>
    //                <th>x</th>
    //              </tr>
    //            </thead>
    //            <tbody id="tbodyid">
    //            <tr class="success"><td><img width="100" height="100" src="imgs/galaxy_s6.jpg"></td><td>Samsung galaxy s6</td><td>360</td><td><a href="#" onclick="deleteItem('f097faa7-7ec7-8034-3025-ab1f7e70e898')">Delete</a></td></tr><tr class="success"><td><img width="100" height="100" src="imgs/Lumia_1520.jpg"></td><td>Nokia lumia 1520</td><td>820</td><td><a href="#" onclick="deleteItem('82608436-d891-1948-fe2f-2b0583dc2533')">Delete</a></td></tr></tbody>
    //          </table>
    public WebElement dajTablu() {
        return this.driver.findElement(By.xpath(".//table[@class='table-bordered']")); //sto ovo zeza kad je tu?
        //return this.driver.findElement(By.xpath(".//table"));
       // return this.driver.findElement(By.xpath(".//table[@class='table-bordered table-hover table-striped']"));//ovo se ne nadje lepo?
    } //getTable
   // table class="table table-bordered table-hover table-striped"


    public List<HashMap<String ,String>> dajPodatkeIzTabele() { //getTableData
        List<HashMap<String, String>> toReturn = new ArrayList<>(); //ovde mi treba string,string,string jer ima img src,pa title,pa price

        WebElement table = this.dajTablu();

        List<String> header = new ArrayList<>();
        List<WebElement> headerList = table.findElements(By.xpath(".//th"));

        for(int i = 0; i < headerList.size(); i++) {
            header.add(headerList.get(i).getText());
        }

        WebElement tBody = table.findElement(By.xpath(".//tbody"));
        List<WebElement> tRow = tBody.findElements(By.xpath(".//tr"));
        for(int j = 0; j < tRow.size(); j++) {
            HashMap<String, String> map = new HashMap<>();
            List<WebElement> tData = tRow.get(j).findElements(By.xpath(".//td"));
            for(int k = 0; k < tData.size(); k++) {
                WebElement itemImage = tBody.findElement(By.xpath(".//img[@class='success']")); //da nadje sliku
                String src = itemImage.getAttribute("src"); //da preuzme lokaciju odakle je tj img source
                if (src.isEmpty())
                {
                    map.put(header.get(k), tData.get(k).getText());}

                else
                { map.put(header.get(k), tData.get(k).getText());
                    //a ovde da nekako preuzme taj src da vidi odakle je slika da moze da preuzme
                    //to resi ubuduce nekako
                }


                //<tr class="success"><td><img width="100" height="100" src="imgs/apple_cinema.jpg">
                //WebElement itemImage = item.findElement(By.xpath(".//img[@class='success']"));
                //  WebElement itemImage = item.findElement(By.xpath(".//img[@class='inventory_item_img']"));
                //  String src = itemImage.getAttribute("src");
            }
            toReturn.add(map);
        }
        return toReturn;
    }

    /*public String getCellData(String ImeKolone, int rowIndex) {
        List<HashMap<String, String>> map = this.dajPodatkeIzTabele();
        return map.get(rowIndex).get(ImeKolone);
    }*/ //sto ovo zeza?
    public String dajPodatkeIzCelijeTabele(String ImeKolone, int rowIndex) {
        List<HashMap<String, String>> map = this.dajPodatkeIzTabele();
        return map.get(rowIndex).get(ImeKolone);
    }

}
