package com.hadikrkc.mongotomysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hadikrkc.mongotomysql.Services.DataTransferService;

@Component
public class DataTransferRunner implements CommandLineRunner {

    @Autowired
    private DataTransferService dataTransferService;

    @Override
    public void run(String... args) throws Exception {
        dataTransferService.transferData();
        System.out.println("Data transfer completed!");
    }
}