package com.chnu.pavel.telephone.service.agency.impls;

import com.chnu.pavel.telephone.dao.agency.interfaces.AgencyDAO;
import com.chnu.pavel.telephone.helper.SequenceGeneratorService;
import com.chnu.pavel.telephone.model.Agency;
import com.chnu.pavel.telephone.model.TelephoneExchange;
import com.chnu.pavel.telephone.service.agency.interfaces.AgencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.AgencyServiceImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|18:07
 * @Version AgencyServiceImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class AgencyServiceImpl implements AgencyService {

    private final AgencyDAO dao;
    private final SequenceGeneratorService generatorService;

    @Override
    public Agency findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public Agency updateById(Long id, Agency entityObj) {
        entityObj.setModified_at(Date.from(Instant.now()));
        return dao.updateById(id, entityObj);
    }

    @Override
    public Agency create(Agency entityObj) {
        entityObj.setId(generatorService.getSequenceNumber(Agency.SEQUENCE_NAME));
        entityObj.setCreated_at(Date.from(Instant.now()));
        entityObj.setModified_at(Date.from(Instant.now()));
        return dao.create(entityObj);
    }

    @Override
    public Agency deleteById(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public List<Agency> findAll() {
        dao.findAll().stream()
           .filter(a -> a.getTelephoneExchange() == null)
           .forEach(a -> dao.deleteById(a.getId()));

        return dao.findAll();
    }

    @Override
    public Optional<Agency> findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public Optional<Agency> findByTelephoneExchange(TelephoneExchange telephoneExchange) {
        return dao.findByTelephoneExchange(telephoneExchange);
    }
}
