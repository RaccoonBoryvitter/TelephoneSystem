package com.chnu.pavel.telephone.repository.subscriber;

import com.chnu.pavel.telephone.model.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.SubscriberRepository
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 29.03.2021|02:40
 * @Version SubscriberRepository: 1.0
 */

@Repository
public interface SubscriberRepository  extends MongoRepository<Subscriber, Long> {

    Optional<Subscriber> findByPrivilegeType(PrivilegeType privilegeType);
    Optional<Subscriber> findByConnectedPhone(ConnectedPhone connectedPhone);

}
