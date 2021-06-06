package com.chnu.pavel.telephone.service.establishment.impls;

import com.chnu.pavel.telephone.dao.establishment.interfaces.EstablishmentDAO;
import com.chnu.pavel.telephone.helper.SequenceGeneratorService;
import com.chnu.pavel.telephone.model.Agency;
import com.chnu.pavel.telephone.model.Establishment;
import com.chnu.pavel.telephone.service.establishment.interfaces.EstablishmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.time.Instant;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.EstablishmentServiceImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|18:04
 * @Version EstablishmentServiceImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class EstablishmentServiceImpl implements EstablishmentService {

    private final EstablishmentDAO dao;
    private final SequenceGeneratorService generatorService;

    @Override
    public Establishment findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public Establishment updateById(Long id, Establishment entityObj) {
        entityObj.setModified_at(Date.from(Instant.now()));
        return dao.updateById(id, entityObj);
    }

    @Override
    public Establishment create(Establishment entityObj) {
        entityObj.setId(generatorService.getSequenceNumber(Establishment.SEQUENCE_NAME));
        entityObj.setCreated_at(Date.from(Instant.now()));
        entityObj.setModified_at(Date.from(Instant.now()));
        return dao.create(entityObj);
    }

    @Override
    public Establishment deleteById(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public List<Establishment> findAll() {
        dao.findAll().stream()
           .filter(e -> e.getTelephoneExchange() == null)
           .forEach(e -> dao.deleteById(e.getId()));

        return dao.findAll();
    }
}
