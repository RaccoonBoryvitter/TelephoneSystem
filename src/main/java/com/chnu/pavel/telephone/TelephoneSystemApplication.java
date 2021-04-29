package com.chnu.pavel.telephone;

import com.chnu.pavel.telephone.model.*;
import com.chnu.pavel.telephone.repository.city.interfaces.CityRepository;
import com.chnu.pavel.telephone.repository.invoice.InvoiceRepository;
import com.chnu.pavel.telephone.repository.penalty.PenaltyRepository;
import com.chnu.pavel.telephone.repository.subscriber.SubscriberRepository;
import com.chnu.pavel.telephone.service.AggregationService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@SpringBootApplication
public class TelephoneSystemApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TelephoneSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
