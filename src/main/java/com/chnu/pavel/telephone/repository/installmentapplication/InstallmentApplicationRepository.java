package com.chnu.pavel.telephone.repository.installmentapplication;

import com.chnu.pavel.telephone.model.AvailablePhoneNumber;
import com.chnu.pavel.telephone.model.InstallmentApplication;
import com.chnu.pavel.telephone.model.PrivilegeType;
import com.chnu.pavel.telephone.model.QueueType;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.InstallQueueRepository
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 29.03.2021|02:34
 * @Version InstallQueueRepository: 1.0
 */

@Repository
public interface InstallmentApplicationRepository extends MongoRepository<InstallmentApplication, Long> {

    Optional<InstallmentApplication> findByQueueType(QueueType queueType);
    Optional<InstallmentApplication> findByAvailableNumber(AvailablePhoneNumber availablePhoneNumber);

}
