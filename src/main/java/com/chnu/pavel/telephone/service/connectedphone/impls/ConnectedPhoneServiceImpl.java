package com.chnu.pavel.telephone.service.connectedphone.impls;

import com.chnu.pavel.telephone.dao.connectedphone.interfaces.ConnectedPhoneDAO;
import com.chnu.pavel.telephone.model.ConnectedPhone;
import com.chnu.pavel.telephone.service.connectedphone.interfaces.ConnectedPhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.time.Instant;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.ConnectedPhoneServiceImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|18:13
 * @Version ConnectedPhoneServiceImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class ConnectedPhoneServiceImpl implements ConnectedPhoneService {

    private final ConnectedPhoneDAO dao;

    @Override
    public ConnectedPhone findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public ConnectedPhone updateById(Long id, ConnectedPhone entityObj) {
        entityObj.setModified_at(Date.from(Instant.now()));
        return dao.updateById(id, entityObj);
    }

    @Override
    public ConnectedPhone create(ConnectedPhone entityObj) {
        entityObj.setCreated_at(Date.from(Instant.now()));
        entityObj.setModified_at(Date.from(Instant.now()));
        return dao.create(entityObj);
    }

    @Override
    public ConnectedPhone deleteById(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public List<ConnectedPhone> findAll() {
        dao.findAll().stream()
           .filter(cp -> cp.getPhoneNumber() == null)
           .forEach(pn -> dao.deleteById(pn.getId()));

        return dao.findAll();
    }
}
