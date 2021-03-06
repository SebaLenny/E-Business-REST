package converters;

import json.ProductJson;
import models.Product;

import javax.inject.Singleton;
import java.util.function.Function;

@Singleton
public class ProductToProductJson implements Function<Product, ProductJson> {
    @Override
    public ProductJson apply(Product product) {
        return new ProductJson(
                Integer.toString(product.id),
                product.link,
                product.name,
                Float.toString(product.price),
                product.description,
                product.picture);

    }
}
