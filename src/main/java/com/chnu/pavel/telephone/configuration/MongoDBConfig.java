package com.chnu.pavel.telephone.configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.MongoDBConfig
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 28.03.2021|20:07
 * @Version MongoDBConfig: 1.0
 */

@Configuration
public class MongoDBConfig extends AbstractMongoClientConfiguration {

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost:27017");
    }

    @Override
    protected String getDatabaseName() {
        return "cityTelephoneExchangeDB";
    }
}
