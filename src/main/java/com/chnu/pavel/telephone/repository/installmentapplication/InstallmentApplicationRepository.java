package com.chnu.pavel.telephone.repository.installmentapplication;

import com.chnu.pavel.telephone.model.InstallmentApplication;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.InstallQueueRepository
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 29.03.2021|02:34
 * @Version InstallQueueRepository: 1.0
 */

@Repository
public interface InstallmentApplicationRepository extends MongoRepository<InstallmentApplication, ObjectId> {
}
