package com.hadikrkc.mongotomysql.Entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Restaurants")
@Data
public class Restaurants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Url", columnDefinition = "longtext")
    private String url;

    @Column(name = "Address", columnDefinition = "longtext")
    private String address;

    @Column(name = "Address2", columnDefinition = "longtext")
    private String address2;

    @Column(name = "Name", columnDefinition = "longtext")
    private String name;

    @Column(name = "Outcode", columnDefinition = "longtext")
    private String outcode;

    @Column(name = "Postcode", columnDefinition = "longtext")
    private String postcode;

    @Column(name = "Rating", nullable = false)
    private Double rating;

    @Column(name = "FoodType", columnDefinition = "longtext")
    private String foodType;

    @Column(name = "CreatedDate", nullable = false, length = 6)
    private LocalDateTime createdDate;
}
