package com.chnu.pavel.telephone.service.calldetailrecord.interfaces;

import com.chnu.pavel.telephone.model.CallDetailRecord;
import com.chnu.pavel.telephone.model.ConversationType;
import com.chnu.pavel.telephone.model.PhoneNumber;
import com.chnu.pavel.telephone.model.TelephoneExchange;
import com.chnu.pavel.telephone.service.GenericService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.CallDetailRecordDAO
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|18:15
 * @Version CallDetailRecordDAO: 1.0
 */

@Service
public interface CallDetailRecordService extends GenericService<CallDetailRecord> {
    Optional<CallDetailRecord> findByFrom(PhoneNumber from);
    Optional<CallDetailRecord> findByTo(PhoneNumber to);
    Optional<CallDetailRecord> findByConversationType(ConversationType conversationType);
    Optional<CallDetailRecord> findByTelephoneExchange(TelephoneExchange telephoneExchange);
}
