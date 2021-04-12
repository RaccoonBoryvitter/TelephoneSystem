package com.chnu.pavel.telephone.repository.telephoneexchange;

import com.chnu.pavel.telephone.model.TelephoneExchange;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.TelephoneExchangeRepository
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 29.03.2021|02:43
 * @Version TelephoneExchangeRepository: 1.0
 */

@Repository
public interface TelephoneExchangeRepository extends MongoRepository<TelephoneExchange, ObjectId> {
}
