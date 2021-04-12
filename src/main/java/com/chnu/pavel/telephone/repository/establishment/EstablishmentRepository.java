package com.chnu.pavel.telephone.repository.establishment;

import com.chnu.pavel.telephone.model.Establishment;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.EstablishmentRepository
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 29.03.2021|02:34
 * @Version EstablishmentRepository: 1.0
 */

@Repository
public interface EstablishmentRepository extends MongoRepository<Establishment, ObjectId> {
}
