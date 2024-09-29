package com.hadikrkc.mongotomysql.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hadikrkc.mongotomysql.Entities.RestaurantData;

public interface MongoEntityRepository extends MongoRepository<RestaurantData, String>  {
}