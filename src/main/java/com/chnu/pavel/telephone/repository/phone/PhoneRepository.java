package com.chnu.pavel.telephone.repository.phone;

import com.chnu.pavel.telephone.model.Phone;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.PhoneRepository
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 29.03.2021|02:35
 * @Version PhoneRepository: 1.0
 */

@Repository
public interface PhoneRepository extends MongoRepository<Phone, ObjectId> {
}
