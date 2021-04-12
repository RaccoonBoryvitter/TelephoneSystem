package com.chnu.pavel.telephone.repository.subscriber;

import com.chnu.pavel.telephone.model.Subscriber;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

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
}
