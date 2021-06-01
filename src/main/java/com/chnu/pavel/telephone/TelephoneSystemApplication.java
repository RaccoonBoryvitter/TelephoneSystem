package com.chnu.pavel.telephone;

import com.chnu.pavel.telephone.model.*;
import com.chnu.pavel.telephone.repository.city.interfaces.CityRepository;
import com.chnu.pavel.telephone.repository.district.DistrictRepository;
import com.chnu.pavel.telephone.repository.invoice.InvoiceRepository;
import com.chnu.pavel.telephone.repository.penalty.PenaltyRepository;
import com.chnu.pavel.telephone.repository.province.interfaces.ProvinceRepository;
import com.chnu.pavel.telephone.repository.subscriber.SubscriberRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@SpringBootApplication
public class TelephoneSystemApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TelephoneSystemApplication.class, args);
    }

    @Autowired
    CityRepository cityRepo;

    @Autowired
    PenaltyRepository penaltyRepo;

    @Autowired
    SubscriberRepository subscriberRepo;

    @Autowired
    InvoiceRepository invoiceRepo;

    @Autowired
    MongoTemplate template;


    @Override
    public void run(String... args) throws Exception {

    }
}
