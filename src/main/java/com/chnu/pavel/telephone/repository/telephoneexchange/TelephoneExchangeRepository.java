package com.chnu.pavel.telephone.repository.telephoneexchange;

import com.chnu.pavel.telephone.model.Address;
import com.chnu.pavel.telephone.model.StationType;
import com.chnu.pavel.telephone.model.TelephoneExchange;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.TelephoneExchangeRepository
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 29.03.2021|02:43
 * @Version TelephoneExchangeRepository: 1.0
 */

@Repository
public interface TelephoneExchangeRepository extends MongoRepository<TelephoneExchange, Long> {

    Optional<TelephoneExchange> findByCodeName(String codeName);
    Optional<TelephoneExchange> findByAddress(Address address);
    Optional<TelephoneExchange> findByStationType(StationType stationType);
    Optional<TelephoneExchange> findByWorkingStatus(boolean workingStatus);
}
