package pages;

public class Proizvod {


    private String name; //ime/naziv
    private Double price;//cena
    private String imgSource;//izvor slike tj. lokacija

    private String description; //opis (ovo u saucedemo-u nije bilo ubacivano)
    //OVO DODATI I U NAKNADNE KLASE

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgSource() {
        return imgSource;
    }

    public void setImgSource(String imgSource) {
        this.imgSource = imgSource;
    }

    public Proizvod(String name, Double price, String imgSource) {
        this.name = name;
        this.price = price;
        this.imgSource = imgSource;
    }
}
