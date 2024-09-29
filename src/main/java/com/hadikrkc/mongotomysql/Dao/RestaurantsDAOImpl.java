package com.hadikrkc.mongotomysql.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hadikrkc.mongotomysql.Entities.Restaurants;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class RestaurantsDAOImpl implements RestaurantsDAO{
    //define field for entity

    private EntityManager entityManager;
    
    //inject entity manager using constructor

    public RestaurantsDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void update(Restaurants theConnectors) {
        entityManager.merge(theConnectors);
    }

    @Override
    public List<Restaurants> findAll() {
        TypedQuery<Restaurants> theQuery = entityManager.createQuery("FROM Restaurants", Restaurants.class);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void save(Restaurants theTransaction) {
        entityManager.persist(theTransaction);
    }
}
