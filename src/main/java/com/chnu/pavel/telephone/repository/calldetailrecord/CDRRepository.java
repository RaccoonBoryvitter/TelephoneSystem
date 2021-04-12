package com.chnu.pavel.telephone.repository.calldetailrecord;

import com.chnu.pavel.telephone.model.CallDetailRecord;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.CDRRepository
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 29.03.2021|02:34
 * @Version CDRRepository: 1.0
 */

@Repository
public interface CDRRepository extends MongoRepository<CallDetailRecord, ObjectId> {
}
