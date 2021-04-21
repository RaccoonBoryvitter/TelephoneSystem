package com.chnu.pavel.telephone.repository.subscriber;

import com.chnu.pavel.telephone.model.Subscriber;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.SubscriberRepository
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 29.03.2021|02:40
 * @Version SubscriberRepository: 1.0
 */

@Repository
public interface SubscriberRepository  extends MongoRepository<Subscriber, ObjectId> {

    @Query(value = "{ 'gender' : ?0 }")
    List<Subscriber> findAllFemaleSubscribers(String gender);

    @Query("{ $or : [{ 'privilegeType' : ?0 }, { 'intercityAccess' : ?1 }] }")
    List<Subscriber> findAllSubscribersByPrivilegeTypeOrIntercityAccess(String privilegeType, boolean access);
}
