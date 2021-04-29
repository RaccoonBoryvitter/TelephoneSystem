package com.chnu.pavel.telephone.configuration.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.MongoDBConfig
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 28.03.2021|20:07
 * @Version MongoDBConfig: 1.0
 */

@Configuration
@EnableMongoRepositories(basePackages = "com.chnu.pavel.telephone.repository")
public class MongoDBConfig extends AbstractMongoClientConfiguration {

    @Value("${spring.data.mongodb.host}")
    private String hostname;



    public String getHostname() {
        return hostname;
    }

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost:27017");
    }

    @Override
    protected String getDatabaseName() {
        return "cityTelephoneExchangeDB";
    }
}
