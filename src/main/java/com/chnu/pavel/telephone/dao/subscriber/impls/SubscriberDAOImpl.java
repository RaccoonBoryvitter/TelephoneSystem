package com.chnu.pavel.telephone.dao.subscriber.impls;

import com.chnu.pavel.telephone.dao.subscriber.interfaces.SubscriberDAO;
import com.chnu.pavel.telephone.model.*;
import com.chnu.pavel.telephone.repository.subscriber.SubscriberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.SubscriberDAOImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|17:00
 * @Version SubscriberDAOImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class SubscriberDAOImpl implements SubscriberDAO {

    private final SubscriberRepository repository;

    @Override
    public Subscriber findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Subscriber create(Subscriber entityObj) {
        return repository.insert(entityObj);
    }

    @Override
    public Subscriber updateById(Long id, Subscriber entityObj) {
        Subscriber upToDate = findById(id);
        upToDate.setFullName(entityObj.getFullName());
        upToDate.setDateOfBirth(entityObj.getDateOfBirth());
        upToDate.setGender(entityObj.getGender());
        upToDate.setPrivilegeType(entityObj.getPrivilegeType());
        upToDate.setConnectedPhone(entityObj.getConnectedPhone());
        upToDate.setIntercityAccess(entityObj.isIntercityAccess());
        upToDate.setModified_at(entityObj.getModified_at());
        upToDate.setDescription(entityObj.getDescription());
        return repository.save(upToDate);
    }

    @Override
    public Subscriber deleteById(Long id) {
        Subscriber deleted = findById(id);
        repository.deleteById(id);
        if(!repository.findById(id).isPresent()) return deleted;
        else return null;
    }

    @Override
    public List<Subscriber> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Subscriber> findByPrivilegeType(PrivilegeType privilegeType) {
        return repository.findByPrivilegeType(privilegeType);
    }

    @Override
    public Optional<Subscriber> findByConnectedPhone(ConnectedPhone connectedPhone) {
        return repository.findByConnectedPhone(connectedPhone);
    }
}
