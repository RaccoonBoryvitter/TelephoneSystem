package com.chnu.pavel.telephone.repository.phonenumber;

import com.chnu.pavel.telephone.model.Address;
import com.chnu.pavel.telephone.model.AvailablePhoneNumber;
import com.chnu.pavel.telephone.model.PhoneNumber;
import com.chnu.pavel.telephone.model.TelephoneExchange;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.PhoneNumberRepository
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 29.03.2021|02:35
 * @Version PhoneNumberRepository: 1.0
 */

@Repository
public interface PhoneNumberRepository extends MongoRepository<PhoneNumber, Long> {

    Optional<PhoneNumber> findByNumber(String number);
    Optional<PhoneNumber> findByTelephoneExchange(TelephoneExchange telephoneExchange);
    Optional<PhoneNumber> findByAddress(Address address);
}
