package models;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;


@Entity
public class Product extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String link;
    public String name;
    public Float price;
    public String description;
    public String picture;

    public Product(Integer id,String link, String name, Float price,String description, String picture) {
        this.id = id;
        this.link = link;
        this.name = name;
        this.price = price;
        this.description = description;
        this.picture = picture;
    }

    public Product(){

    }

    public static Finder<Integer, Product> find = new Finder<>(Product.class);

    private static List<Product> products = Lists.newArrayList();

    public static List<Product> retrieveAll() {
        return find.query().findList();
        //return products;
    }

    public static Product retrieveById(Integer id) {
//        for (Product product : products) {
//            if (id.equals(product.id)) {
//                return product;
//            }
//        }
//        return null;
        return find.ref(id);
    }

    public static void add(Product product) {
        products.add(product);
    }

    public static boolean remove(Product product) {
        return products.remove(product);
    }
}
