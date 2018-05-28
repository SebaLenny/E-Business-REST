package controllers;

import json.ProductJson;
import models.Product;
import play.data.Form;
import play.data.FormFactory;
import play.filters.csrf.CSRF;
import play.mvc.Result;
import play.mvc.Controller;
import play.libs.Json;

import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

import converters.ProductToProductJson;

import views.html.product.*;
import views.html.product.index;


//import views.html.index;
@Singleton
public class ProductController extends Controller {

//    @Inject
//    FormFactory formFactory;
//
//    public Result index(){
//        List<Product> products = Product.find.all();
//        //return ok(index.render(products));
//        return ok();
//    }
//
//
//    public Result create(){
//        Form<Product> productForm = formFactory.form(Product.class);
//        return ok(create.render(productForm));
//    }
//
//
//    public Result save(){
//        Form<Product> productForm = formFactory.form(Product.class).bindFromRequest();
//        Product product = productForm.get();
//        product.save();
//        return redirect(routes.ProductController.index());
//    }
//
//    public Result edit(Integer id){
//        Product product = Product.find.byId(id);
//        if (product==null){
//            return notFound("Product not found!");
//        }
//        Form<Product> productForm = formFactory.form(Product.class).fill(product);
//        return ok(edit.render(productForm));
//    }
//
//    public Result update(){
//        Product product = formFactory.form(Product.class).bindFromRequest().get();
//        Product oldProduct = Product.find.byId(product.id);
//        if (oldProduct == null){
//            return notFound("Product not found!");
//        }
//        oldProduct.name = product.name;
//        oldProduct.price = product.price;
//        oldProduct.manufacturer = product.manufacturer;
//        oldProduct.update();
//
//        return redirect(routes.ProductController.index());
//    }
//
//    public Result show(Integer id){
//        Product product = Product.find.byId(id);
//        if (product == null) {
//            return notFound("Product not found");
//        }
//        return ok(show.render(product));
//    }
//
//    public Result delete(Integer id){
//        Product product = Product.find.byId(id);
//        if (product == null){
//            return notFound("Product not found");
//        }
//        product.delete();
//        return redirect(routes.ProductController.index());
//    }

    @Inject
    private Product product;
    @Inject
    private ProductToProductJson productToProductJson;
    @Inject
    private ProductJson productJson;

    public Result index() {
        return getAllProducts();
    }

    private Result getAllProducts() {
        List<Product> productset = Product.retrieveAll();
        return ok(Json.toJson(productset != null ? productset : ""));
    }

    public Result getWithIndex(Integer id) {
        Product product = Product.find.byId(id);
        if (product == null) {
            return notFound("Product not found!");
        }
        return ok(Json.toJson(product));
    }

    public Result create() {
        ProductJson productJson;
        productJson = Json.fromJson(request().body().asJson(), ProductJson.class);
        Product product = new Product();
        product.name = productJson.name;
        product.manufacturer = productJson.manufacturer;
        product.price = Integer.parseInt(productJson.price);
        Product.add(product);
        return ok("Product successfully created");
    }

    public Result update() {
        Product product = Json.fromJson(request().body().asJson(), Product.class);
        Product oldProduct = Product.find.byId(product.id);
        if (oldProduct == null) {
            return notFound("Product not found!");
        }
        oldProduct.name = product.name;
        oldProduct.price = product.price;
        oldProduct.manufacturer = product.manufacturer;
        oldProduct.update();

        return ok("Product successfully edited");
    }


    public Result delete(Integer id) {
        Product product = Product.find.byId(id);
        if (product == null) {
            return notFound("Product not found");
        }
        product.delete();
        return ok("Product deleted successfully");
    }

}
