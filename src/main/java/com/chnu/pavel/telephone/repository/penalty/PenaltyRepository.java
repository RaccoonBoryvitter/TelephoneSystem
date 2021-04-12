package com.chnu.pavel.telephone.repository.penalty;

import com.chnu.pavel.telephone.model.Penalty;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.PenaltyRepository
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 29.03.2021|02:35
 * @Version PenaltyRepository: 1.0
 */

@Repository
public interface PenaltyRepository extends MongoRepository<Penalty, ObjectId> {
}
