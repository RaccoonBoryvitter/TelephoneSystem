package com.chnu.pavel.telephone.dao.calldetailrecord.impls;

import com.chnu.pavel.telephone.dao.calldetailrecord.interfaces.CallDetailRecordDAO;
import com.chnu.pavel.telephone.model.*;
import com.chnu.pavel.telephone.repository.calldetailrecord.CDRRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.CallDetailRecordDAOImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|16:05
 * @Version CallDetailRecordDAOImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class CallDetailRecordDAOImpl implements CallDetailRecordDAO {

    private final CDRRepository repository;

    @Override
    public CallDetailRecord findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public CallDetailRecord create(CallDetailRecord entityObj) {
        return repository.insert(entityObj);
    }

    @Override
    public CallDetailRecord updateById(Long id, CallDetailRecord entityObj) {
        CallDetailRecord upToDate = findById(id);
        upToDate.setFrom(entityObj.getFrom());
        upToDate.setTo(entityObj.getTo());
        upToDate.setStartedAt(entityObj.getStartedAt());
        upToDate.setFinishedAt(entityObj.getFinishedAt());
        upToDate.setConversationType(entityObj.getConversationType());
        upToDate.setTelephoneExchange(entityObj.getTelephoneExchange());
        upToDate.setModified_at(entityObj.getModified_at());
        upToDate.setDescription(entityObj.getDescription());
        return repository.save(upToDate);
    }

    @Override
    public CallDetailRecord deleteById(Long id) {
        CallDetailRecord deleted = findById(id);
        repository.deleteById(id);
        if(!repository.findById(id).isPresent()) return deleted;
        else return null;
    }

    @Override
    public List<CallDetailRecord> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<CallDetailRecord> findByFrom(PhoneNumber from) {
        return repository.findByFrom(from);
    }

    @Override
    public Optional<CallDetailRecord> findByTo(PhoneNumber to) {
        return repository.findByTo(to);
    }

    @Override
    public Optional<CallDetailRecord> findByConversationType(ConversationType conversationType) {
        return repository.findByConversationType(conversationType);
    }

    @Override
    public Optional<CallDetailRecord> findByTelephoneExchange(TelephoneExchange telephoneExchange) {
        return repository.findByTelephoneExchange(telephoneExchange);
    }
}
