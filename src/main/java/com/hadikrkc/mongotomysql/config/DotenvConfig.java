package com.hadikrkc.mongotomysql.config;


import org.springframework.context.annotation.Configuration;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;

@Configuration
public class DotenvConfig {

    @PostConstruct
    public void loadEnv() {
        Dotenv dotenv = Dotenv.configure().load();

        System.out.println("DATABASE_URL: " + dotenv.get("DATABASE_URL"));
		System.out.println("DATABASE_USERNAME: " + dotenv.get("DATABASE_USERNAME"));
		System.out.println("DATABASE_PASSWORD: " + dotenv.get("DATABASE_PASSWORD"));
        System.out.println("MONGODB_URL: " + dotenv.get("MONGODB_URL"));

        System.setProperty("DATABASE_URL", dotenv.get("DATABASE_URL"));
        System.setProperty("DATABASE_USERNAME", dotenv.get("DATABASE_USERNAME"));
        System.setProperty("DATABASE_PASSWORD", dotenv.get("DATABASE_PASSWORD"));
        System.setProperty("MONGODB_URL", dotenv.get("MONGODB_URL"));
    }
}