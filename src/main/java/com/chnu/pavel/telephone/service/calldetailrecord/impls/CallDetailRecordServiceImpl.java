package com.chnu.pavel.telephone.service.calldetailrecord.impls;

import com.chnu.pavel.telephone.dao.calldetailrecord.interfaces.CallDetailRecordDAO;
import com.chnu.pavel.telephone.helper.SequenceGeneratorService;
import com.chnu.pavel.telephone.model.*;
import com.chnu.pavel.telephone.service.calldetailrecord.interfaces.CallDetailRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.CallDetailRecordServiceImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|18:16
 * @Version CallDetailRecordServiceImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class CallDetailRecordServiceImpl implements CallDetailRecordService {

    private final CallDetailRecordDAO dao;
    private final SequenceGeneratorService generatorService;

    @Override
    public CallDetailRecord findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public CallDetailRecord updateById(Long id, CallDetailRecord entityObj) {
        entityObj.setModified_at(Date.from(Instant.now()));
        return dao.updateById(id, entityObj);
    }

    @Override
    public CallDetailRecord create(CallDetailRecord entityObj) {
        entityObj.setId(generatorService.getSequenceNumber(CallDetailRecord.SEQUENCE_NAME));
        entityObj.setCreated_at(Date.from(Instant.now()));
        entityObj.setModified_at(Date.from(Instant.now()));
        return dao.create(entityObj);
    }

    @Override
    public CallDetailRecord deleteById(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public List<CallDetailRecord> findAll() {
        dao.findAll().stream()
           .filter(cdr -> cdr.getTelephoneExchange() == null)
           .forEach(cdr -> dao.deleteById(cdr.getId()));

        return dao.findAll();
    }

    @Override
    public Optional<CallDetailRecord> findByFrom(PhoneNumber from) {
        return dao.findByFrom(from);
    }

    @Override
    public Optional<CallDetailRecord> findByTo(PhoneNumber to) {
        return dao.findByTo(to);
    }

    @Override
    public Optional<CallDetailRecord> findByConversationType(ConversationType conversationType) {
        return dao.findByConversationType(conversationType);
    }

    @Override
    public Optional<CallDetailRecord> findByTelephoneExchange(TelephoneExchange telephoneExchange) {
        return dao.findByTelephoneExchange(telephoneExchange);
    }
}
