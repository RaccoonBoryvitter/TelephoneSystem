package com.chnu.pavel.telephone.repository.subscriptionfee;

import com.chnu.pavel.telephone.model.SubscriptionFee;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.SubscriptionFeeRepository
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 29.03.2021|02:41
 * @Version SubscriptionFeeRepository: 1.0
 */

@Repository
public interface SubscriptionFeeRepository extends MongoRepository<SubscriptionFee, ObjectId> {
}
