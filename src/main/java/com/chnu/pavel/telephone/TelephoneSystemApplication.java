package com.chnu.pavel.telephone;

import com.chnu.pavel.telephone.repository.city.CityRepository;
import com.chnu.pavel.telephone.repository.invoice.InvoiceRepository;
import com.chnu.pavel.telephone.repository.penalty.PenaltyRepository;
import com.chnu.pavel.telephone.repository.subscriber.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

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
        System.out.println("cityRepo.findAll() = " + cityRepo.findAll());
    }
}
