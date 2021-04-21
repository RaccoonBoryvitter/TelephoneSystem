package com.chnu.pavel.telephone;

import com.chnu.pavel.telephone.model.*;
import com.chnu.pavel.telephone.repository.city.interfaces.CityRepository;
import com.chnu.pavel.telephone.repository.district.DistrictRepository;
import com.chnu.pavel.telephone.repository.invoice.InvoiceRepository;
import com.chnu.pavel.telephone.repository.penalty.PenaltyRepository;
import com.chnu.pavel.telephone.repository.province.interfaces.ProvinceRepository;
import com.chnu.pavel.telephone.repository.subscriber.SubscriberRepository;
import com.chnu.pavel.telephone.service.AggregationService;
import com.chnu.pavel.telephone.service.AggregationServiceV2;
import com.chnu.pavel.telephone.service.QueriesService;
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
    AggregationService aggregationService;

    @Autowired
    AggregationServiceV2 aggregationServiceV2;

    @Autowired
    QueriesService queriesService;

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
        System.out.println("AGGREGATIONS: Part I");
        System.out.println("aggregationService.firstAggregation() = " + aggregationService.firstAggregation());
        System.out.println("aggregationService.secondAggregation() = " + aggregationService.secondAggregation());
        System.out.println("aggregationService.thirdAggregation() = " + aggregationService.thirdAggregation());
        System.out.println("aggregationService.fourthAggregation() = " + aggregationService.fourthAggregation());
        System.out.println("aggregationService.fifthAggregation() = " + aggregationService.fifthAggregation());
        System.out.println("AGGREGATIONS: Part II");
        System.out.println("aggregationServiceV2.firstAggregation() = " + aggregationServiceV2.firstAggregation());
        System.out.println("aggregationServiceV2.secondAggregation() = " + aggregationServiceV2.secondAggregation());
        System.out.println("aggregationServiceV2.thirdAggregation() = " + aggregationServiceV2.thirdAggregation());
        System.out.println("aggregationServiceV2.fourthAggregation() = " + aggregationServiceV2.fourthAggregation());
        System.out.println("aggregationServiceV2.fifthAggregation() = " + aggregationServiceV2.fifthAggregation());
        System.out.println("/////////////////////////////////////////////////////");
        System.out.println("QUERIES: Part I");
        System.out.println("queriesService.firstQuery() = " + queriesService.firstQuery());
        System.out.println("queriesService.secondQuery() = " + queriesService.secondQuery());
        System.out.println("queriesService.thirdQuery() = " + queriesService.thirdQuery());
        System.out.println("queriesService.fourthQuery() = " + queriesService.fourthQuery());
        System.out.println("queriesService.fifthQuery() = " + queriesService.fifthQuery());
        System.out.println("queriesService.sixthQuery() = " + queriesService.sixthQuery());
        System.out.println("queriesService.seventhQuery() = " + queriesService.seventhQuery());
        System.out.println("queriesService.eighthQuery() = " + queriesService.eighthQuery());
        System.out.println("queriesService.ninthQuery() = " + queriesService.ninthQuery());
        System.out.println("queriesService.tenthQuery() = " + queriesService.tenthQuery());
        System.out.println("queriesService.eleventhQuery() = " + queriesService.eleventhQuery());
        System.out.println("queriesService.twelfthQuery() = " + queriesService.twelfthQuery());
        System.out.println("queriesService.thirteenQuery() = " + queriesService.thirteenQuery());
        System.out.println("QUERIES: Part II");
        System.out.println("cityRepo.findAll() = " + cityRepo.findAll());
        Query withoutId = new Query();
        withoutId.fields().exclude("_id");
        System.out.println("template.find(withoutId, Penalty.class) = " + template.find(withoutId, Penalty.class));
        System.out.println("subscriberRepo.findAllFemaleSubscribers(\"female\") = " + subscriberRepo.findAllFemaleSubscribers("female"));
        System.out.println("template.find(new Query().addCriteria(Criteria.where(\"phoneCode\").is(\"2\")), City.class) = " + template
                .find(new Query().addCriteria(Criteria.where("phoneCode").is("2")), City.class));
        System.out.println("invoiceRepo.findAllInvoicesWhenTotalCostGreaterThanNumber(50.0) = " +
                invoiceRepo.findAllInvoicesWhenTotalCostGreaterThanNumber(50.0));
        System.out.println("invoiceRepo.findAllInvoicesWhenTotalCostLessThanNumber(50.0) = " +
                invoiceRepo.findAllInvoicesWhenTotalCostLessThanNumber(50.0));
        System.out.println("template.find(new Query().addCriteria(Criteria.where(\"localCallsCost\").gte(25)), SubscriptionFee.class) = " + template
                .find(new Query().addCriteria(Criteria.where("localCallsCost").gte(25)), SubscriptionFee.class));
        System.out.println("template.find(new Query().addCriteria(Criteria.where(\"intercityCallsCost\").lte(15)), SubscriptionFee.class) = " + template
                .find(new Query().addCriteria(Criteria.where("intercityCallsCost").lte(15)), SubscriptionFee.class));
        System.out.println("template.find(new Query().addCriteria(Criteria.where(\"city.$id\").ne(new ObjectId(\"6072b1800d1b314b019b7ba6\"))), District.class) = " + template
                .find(new Query().addCriteria(Criteria.where("city.$id")
                                                      .ne(new ObjectId("6072b1800d1b314b019b7ba6"))), District.class));
        System.out.println("template.find(new Query().addCriteria(Criteria.where(\"phoneType\").ne(\"Common\").and(\"isWorking\").is(true)), Phone.class) = " + template
                .find(new Query().addCriteria(Criteria.where("phoneType")
                                                      .ne("Common")
                                                      .and("isWorking")
                                                      .is(true)), Phone.class));
        System.out.println("subscriberRepo.findAllSubscribersByPrivilegeTypeOrIntercityAccess(\"Invalid\", false) = " + subscriberRepo
                .findAllSubscribersByPrivilegeTypeOrIntercityAccess("Invalid", false));
        System.out.println("template.find(new Query().addCriteria(Criteria.where(\"stationType\").ne(\"Foreign\")), TelephoneExchange.class) = " + template
                .find(new Query().addCriteria(Criteria.where("stationType").ne("Foreign")), TelephoneExchange.class));
        System.out.println("template.find(new Query().addCriteria(Criteria.where(\"district.$id\")" +
                ".in(new ObjectId(\"60610eec79d0a6db5f2aec03\"),new ObjectId(\"60610eec79d0a6db5f2aec05\")))," +
                " Address.class) = " + template
                .find(new Query()
                        .addCriteria(Criteria.where("district.$id")
                                             .in(new ObjectId("60610eec79d0a6db5f2aec03"),
                                                     new ObjectId("60610eec79d0a6db5f2aec05"))), Address.class));
    }
}
