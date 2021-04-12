package com.chnu.pavel.telephone.repository.installqueue;

import com.chnu.pavel.telephone.model.InstallQueue;
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
public interface InstallQueueRepository extends MongoRepository<InstallQueue, ObjectId> {
}
