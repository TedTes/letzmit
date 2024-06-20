package com.tutego.date4u.shell;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import com.tutego.date4u.core.utils.Product;

@ShellComponent
public class ProductDatabaseApplication {
    @Autowired
    private MongoTemplate mongoTemplate;

    @ShellMethod("createProduct")
    public void createNewDocuments() {
        Criteria categoryIsThing = Criteria.where("category").is("Thing");
        Criteria priceRange = Criteria.where("price").gt(10_00).lt(20_00);
        Query query = Query.query(categoryIsThing)
                .addCriteria(priceRange)
                .with(Sort.by("price"));

        List<Product> products = mongoTemplate.find(query, Product.class);
        System.out.println(products);
        // System.out.println(mongoTemplate.findAll(Product.class));
        // for (int i = 0; i < 100_000; i++) {
        // var product = new Product();
        // product.title = "Product " + i;
        // product.description = "Description " + i;
        // product.category = "Thing";
        // product.price = ThreadLocalRandom.current().nextInt(1000, 100000);
        // product.thumbnail = "https://picsum.photos/200/300?image=" + i;
        // mongoTemplate.save(product);
        // }
    }

}
