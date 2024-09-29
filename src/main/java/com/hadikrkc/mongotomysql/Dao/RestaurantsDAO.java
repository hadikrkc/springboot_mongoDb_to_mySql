package com.hadikrkc.mongotomysql.Dao;

import java.util.List;

import com.hadikrkc.mongotomysql.Entities.Restaurants;

public interface RestaurantsDAO {
    
    List<Restaurants> findAll();

    void update(Restaurants transaction);

    void save(Restaurants transaction);
}