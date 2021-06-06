package com.chnu.pavel.telephone.service.subscriber.impls;

import com.chnu.pavel.telephone.dao.subscriber.interfaces.SubscriberDAO;
import com.chnu.pavel.telephone.model.Subscriber;
import com.chnu.pavel.telephone.service.subscriber.interfaces.SubscriberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.time.Instant;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.SubscriberServiceImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|18:27
 * @Version SubscriberServiceImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class SubscriberServiceImpl implements SubscriberService {

    private final SubscriberDAO dao;

    @Override
    public Subscriber findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public Subscriber updateById(Long id, Subscriber entityObj) {
        entityObj.setModified_at(Date.from(Instant.now()));
        return dao.updateById(id, entityObj);
    }

    @Override
    public Subscriber create(Subscriber entityObj) {
        entityObj.setCreated_at(Date.from(Instant.now()));
        entityObj.setModified_at(Date.from(Instant.now()));
        return dao.create(entityObj);
    }

    @Override
    public Subscriber deleteById(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public List<Subscriber> findAll() {
        dao.findAll().stream()
           .filter(s -> s.getConnectedPhone().getPhoneNumber().getTelephoneExchange() == null)
           .forEach(s -> dao.deleteById(s.getId()));

        return dao.findAll();
    }
}
