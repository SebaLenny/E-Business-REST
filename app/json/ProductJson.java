package json;

public class ProductJson {
    public String id;
    public String link;
    public String name;
    public String price;
    public String description;
    public String picture;

    public ProductJson(String id,String link, String name, String price, String description, String picture) {
        this.id = id;
        this.link = link;
        this.name = name;
        this.price = price;
        this.description = description;
        this.picture = picture;
    }

    public ProductJson() {

    }
}
