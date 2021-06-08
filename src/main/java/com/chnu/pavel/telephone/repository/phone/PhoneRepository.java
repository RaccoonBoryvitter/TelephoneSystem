package com.chnu.pavel.telephone.repository.phone;

import com.chnu.pavel.telephone.model.AvailablePhoneNumber;
import com.chnu.pavel.telephone.model.Phone;
import com.chnu.pavel.telephone.model.PhoneType;
import com.chnu.pavel.telephone.model.TelephoneExchange;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.PhoneRepository
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 29.03.2021|02:35
 * @Version PhoneRepository: 1.0
 */

@Repository
public interface PhoneRepository extends MongoRepository<Phone, Long> {

    Optional<Phone> findByName(String name);
    Optional<Phone> findByPhoneType(PhoneType phoneType);

}
