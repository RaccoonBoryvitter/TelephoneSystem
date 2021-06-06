package com.chnu.pavel.telephone.service.phonenumber.impls;

import com.chnu.pavel.telephone.dao.phonenumber.interfaces.PhoneNumberDAO;
import com.chnu.pavel.telephone.helper.SequenceGeneratorService;
import com.chnu.pavel.telephone.model.Agency;
import com.chnu.pavel.telephone.model.PhoneNumber;
import com.chnu.pavel.telephone.service.phonenumber.interfaces.PhoneNumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.time.Instant;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.PhoneNumberServiceImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|17:54
 * @Version PhoneNumberServiceImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class PhoneNumberServiceImpl implements PhoneNumberService {

    private final PhoneNumberDAO dao;
    private final SequenceGeneratorService generatorService;

    @Override
    public PhoneNumber findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public PhoneNumber updateById(Long id, PhoneNumber entityObj) {
        entityObj.setModified_at(Date.from(Instant.now()));
        return dao.updateById(id, entityObj);
    }

    @Override
    public PhoneNumber create(PhoneNumber entityObj) {
        entityObj.setId(generatorService.getSequenceNumber(PhoneNumber.SEQUENCE_NAME));
        entityObj.setCreated_at(Date.from(Instant.now()));
        entityObj.setModified_at(Date.from(Instant.now()));
        return dao.create(entityObj);
    }

    @Override
    public PhoneNumber deleteById(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public List<PhoneNumber> findAll() {
        dao.findAll().stream()
           .filter(pn -> pn.getAddress() == null)
           .forEach(pn -> dao.deleteById(pn.getId()));

        dao.findAll().stream()
           .filter(pn -> pn.getTelephoneExchange() == null)
           .forEach(pn -> dao.deleteById(pn.getId()));

        return dao.findAll();
    }
}
