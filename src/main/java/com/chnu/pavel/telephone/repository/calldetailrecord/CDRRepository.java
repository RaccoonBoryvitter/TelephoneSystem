package com.chnu.pavel.telephone.repository.calldetailrecord;

import com.chnu.pavel.telephone.model.CallDetailRecord;
import com.chnu.pavel.telephone.model.ConversationType;
import com.chnu.pavel.telephone.model.PhoneNumber;
import com.chnu.pavel.telephone.model.TelephoneExchange;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.CDRRepository
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 29.03.2021|02:34
 * @Version CDRRepository: 1.0
 */

@Repository
public interface CDRRepository extends MongoRepository<CallDetailRecord, Long> {

    Optional<CallDetailRecord> findByFrom(PhoneNumber from);
    Optional<CallDetailRecord> findByTo(PhoneNumber to);
    Optional<CallDetailRecord> findByConversationType(ConversationType conversationType);
    Optional<CallDetailRecord> findByTelephoneExchange(TelephoneExchange telephoneExchange);

}
