package com.hadikrkc.mongotomysql.Entities;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.Id;
import lombok.Data;

@Data
@Document(collection = "restaurantCollection")
public class RestaurantData {

    @Id
    private Object id;

    @Field(name = "URL")
    private String url;

    @Field(name = "address")
    private String address;

    @Field(name = "address line 2")
    private String address2;

    @Field(name = "name")
    private String name;

    @Field(name = "outcode")
    private String outcode;

    @Field(name = "postcode")
    private String postcode;

    @Field(name = "rating")
    private String rating;

    @Field(name = "type_of_food")
    private String foodType;
}
