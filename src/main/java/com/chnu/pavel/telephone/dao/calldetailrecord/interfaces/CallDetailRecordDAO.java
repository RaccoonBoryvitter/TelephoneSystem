package com.chnu.pavel.telephone.dao.calldetailrecord.interfaces;

import com.chnu.pavel.telephone.dao.GenericDAO;
import com.chnu.pavel.telephone.model.CallDetailRecord;
import com.chnu.pavel.telephone.model.ConversationType;
import com.chnu.pavel.telephone.model.PhoneNumber;
import com.chnu.pavel.telephone.model.TelephoneExchange;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.CallDetailRecordDAO
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|15:59
 * @Version CallDetailRecordDAO: 1.0
 */

@Repository
public interface CallDetailRecordDAO extends GenericDAO<CallDetailRecord> {

    Optional<CallDetailRecord> findByFrom(PhoneNumber from);
    Optional<CallDetailRecord> findByTo(PhoneNumber to);
    Optional<CallDetailRecord> findByConversationType(ConversationType conversationType);
    Optional<CallDetailRecord> findByTelephoneExchange(TelephoneExchange telephoneExchange);

}
