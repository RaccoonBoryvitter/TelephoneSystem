package com.chnu.pavel.telephone.repository.phonenumber;

import com.chnu.pavel.telephone.model.PhoneNumber;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.PhoneNumberRepository
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 29.03.2021|02:35
 * @Version PhoneNumberRepository: 1.0
 */

@Repository
public interface PhoneNumberRepository extends MongoRepository<PhoneNumber, ObjectId> {
}
