package json;

public class ProductJson {
    public String id;
    public String name;
    public String price;
    public String manufacturer;

    public ProductJson(String id, String name, String price, String manufacturer){
        this.id = id;
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public ProductJson(){

    }
}
