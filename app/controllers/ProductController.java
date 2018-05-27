package controllers;
import models.Product;
import play.data.Form;
import play.data.FormFactory;
import play.filters.csrf.CSRF;
import play.mvc.Result;
import play.mvc.Controller;

import java.util.List;
import javax.inject.Inject;
import views.html.product.*;
import views.html.product.index;


//import views.html.index;

public class ProductController extends Controller{

    @Inject
    FormFactory formFactory;

    public Result index(){
        List<Product> products = Product.find.all();
        //return ok(index.render(products));
        return ok();
    }


    public Result create(){
        Form<Product> productForm = formFactory.form(Product.class);
        return ok(create.render(productForm));
    }


    public Result save(){
        Form<Product> productForm = formFactory.form(Product.class).bindFromRequest();
        Product product = productForm.get();
        product.save();
        return redirect(routes.ProductController.index());
    }

    public Result edit(Integer id){
        Product product = Product.find.byId(id);
        if (product==null){
            return notFound("Product not found!");
        }
        Form<Product> productForm = formFactory.form(Product.class).fill(product);
        return ok(edit.render(productForm));
    }

    public Result update(){
        Product product = formFactory.form(Product.class).bindFromRequest().get();
        Product oldProduct = Product.find.byId(product.id);
        if (oldProduct == null){
            return notFound("Product not found!");
        }
        oldProduct.name = product.name;
        oldProduct.price = product.price;
        oldProduct.manufacturer = product.manufacturer;
        oldProduct.update();

        return redirect(routes.ProductController.index());
    }

    public Result show(Integer id){
        Product product = Product.find.byId(id);
        if (product == null) {
            return notFound("Product not found");
        }
        return ok(show.render(product));
    }

    public Result delete(Integer id){
        Product product = Product.find.byId(id);
        if (product == null){
            return notFound("Product not found");
        }
        product.delete();
        return redirect(routes.ProductController.index());
    }

}
