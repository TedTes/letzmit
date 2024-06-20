package com.tutego.date4u.core.utils;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
// import org.springframework.data.mongodb.core.mapping.Document;
public class Product {
    public ObjectId id;
    public String title;
    public String description;
    public String thumbnail;
    public String category;
    public long price; // price in Cent
    @Autowired
    private MongoTemplate mongoTemplate;
    // public Map<String, Map<?, ?>> map;
    // public List<Map<String, Map<?, ?>>> listOfMaps;
}
