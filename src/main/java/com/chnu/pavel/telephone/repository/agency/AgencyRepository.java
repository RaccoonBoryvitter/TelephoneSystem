package com.chnu.pavel.telephone.repository.agency;

import com.chnu.pavel.telephone.model.Agency;
import com.chnu.pavel.telephone.model.AvailablePhoneNumber;
import com.chnu.pavel.telephone.model.TelephoneExchange;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.AgencyRepository
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 29.03.2021|02:33
 * @Version AgencyRepository: 1.0
 */

@Repository
public interface AgencyRepository extends MongoRepository<Agency, Long> {

    Optional<Agency> findByName(String number);
    Optional<Agency> findByTelephoneExchange(TelephoneExchange telephoneExchange);
}
