package com.chnu.pavel.telephone.service.telephoneexchange.impls;

import com.chnu.pavel.telephone.dao.telephoneexchange.interfaces.TelephoneExchangeDAO;
import com.chnu.pavel.telephone.helper.SequenceGeneratorService;
import com.chnu.pavel.telephone.model.Agency;
import com.chnu.pavel.telephone.model.TelephoneExchange;
import com.chnu.pavel.telephone.service.telephoneexchange.interfaces.TelephoneExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.time.Instant;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.TelephoneExchangeServiceImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|17:51
 * @Version TelephoneExchangeServiceImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class TelephoneExchangeServiceImpl implements TelephoneExchangeService {

    private final TelephoneExchangeDAO dao;
    private final SequenceGeneratorService generatorService;

    @Override
    public TelephoneExchange findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public TelephoneExchange updateById(Long id, TelephoneExchange entityObj) {
        entityObj.setModified_at(Date.from(Instant.now()));
        return dao.updateById(id, entityObj);
    }

    @Override
    public TelephoneExchange create(TelephoneExchange entityObj) {
        entityObj.setId(generatorService.getSequenceNumber(TelephoneExchange.SEQUENCE_NAME));
        entityObj.setCreated_at(Date.from(Instant.now()));
        entityObj.setModified_at(Date.from(Instant.now()));
        return dao.create(entityObj);
    }

    @Override
    public TelephoneExchange deleteById(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public List<TelephoneExchange> findAll() {
        dao.findAll().stream()
           .filter(tx -> tx.getAddress() == null)
           .forEach(tx -> dao.deleteById(tx.getId()));

        return dao.findAll();
    }
}
