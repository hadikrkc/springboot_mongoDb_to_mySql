package com.hadikrkc.mongotomysql.Services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hadikrkc.mongotomysql.Dao.RestaurantsDAO;
import com.hadikrkc.mongotomysql.Entities.RestaurantData;
import com.hadikrkc.mongotomysql.Entities.Restaurants;
import com.hadikrkc.mongotomysql.Repositories.MongoEntityRepository;

import jakarta.transaction.Transactional;

@Service
public class DataTransferService {

    @Autowired
    private MongoEntityRepository mongoEntityRepository;

    private RestaurantsDAO restaurantsDAO;

    public DataTransferService (RestaurantsDAO restaurantsDAO){
        this.restaurantsDAO = restaurantsDAO;
    }

    @Transactional
    public void transferData() {
        System.out.println("restaurantDatas");
        List<RestaurantData> restaurantDatas = mongoEntityRepository.findAll();
        System.out.println("Size restaurantDatas: " + restaurantDatas.size());

        List<Restaurants> restaurants = restaurantsDAO.findAll();
        System.out.println("Size restaurants: " + restaurants.size());
        Date date = new Date();
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();

        for (RestaurantData restaurantData : restaurantDatas) {
            try{
                Restaurants newRestaurant = new Restaurants();
                newRestaurant.setUrl(restaurantData.getUrl());
                newRestaurant.setAddress(restaurantData.getAddress());
                newRestaurant.setAddress2(restaurantData.getAddress2());
                newRestaurant.setName(restaurantData.getName());
                newRestaurant.setOutcode(restaurantData.getOutcode());
                newRestaurant.setPostcode(restaurantData.getPostcode());
                newRestaurant.setRating(Double.valueOf(restaurantData.getRating()));
                newRestaurant.setFoodType(restaurantData.getFoodType());
                newRestaurant.setCreatedDate(localDateTime);

                restaurantsDAO.save(newRestaurant);
                //System.out.println("Done: " + newRestaurant.getId());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Kaydedilmedi: restaurantData" + restaurantData.toString());
            }
        }
    }
}