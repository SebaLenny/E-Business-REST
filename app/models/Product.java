package models;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Product extends Model {
    @Id
    @GeneratedValue
    public Integer id;
    public String name;
    public Integer price;
    public String manufacturer;

    public Product(Integer id, String name, Integer price, String manufacturer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public Product(){

    }

    public static Finder<Integer, Product> find = new Finder<>(Product.class);

    private static List<Product> products = Lists.newArrayList();

    public static List<Product> retrieveAll() {
        return products;
    }

    public static Product retrieveById(Integer id) {
        for (Product product : products) {
            if (id.equals(product.id)) {
                return product;
            }
        }
        return null;
    }

    public static void add(Product product) {
        products.add(product);
    }

    public static boolean remove(Product product) {
        return products.remove(product);
    }
}
