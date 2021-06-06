package com.chnu.pavel.telephone.dao.telephoneexchange.impls;

import com.chnu.pavel.telephone.dao.telephoneexchange.interfaces.TelephoneExchangeDAO;
import com.chnu.pavel.telephone.model.District;
import com.chnu.pavel.telephone.model.TelephoneExchange;
import com.chnu.pavel.telephone.repository.telephoneexchange.TelephoneExchangeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.TelephoneExchangeDAOImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|15:47
 * @Version TelephoneExchangeDAOImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class TelephoneExchangeDAOImpl implements TelephoneExchangeDAO {

    private final TelephoneExchangeRepository repository;

    @Override
    public TelephoneExchange findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public TelephoneExchange create(TelephoneExchange entityObj) {
        return repository.insert(entityObj);
    }

    @Override
    public TelephoneExchange updateById(Long id, TelephoneExchange entityObj) {
        TelephoneExchange upToDate = findById(id);
        upToDate.setCodeName(entityObj.getCodeName());
        upToDate.setAddress(entityObj.getAddress());
        upToDate.setStationType(entityObj.getStationType());
        upToDate.setAvailableCables(entityObj.getAvailableCables());
        upToDate.setAvailableChannels(entityObj.getAvailableChannels());
        upToDate.setWorkingStatus(entityObj.isWorkingStatus());
        upToDate.setModified_at(entityObj.getModified_at());
        upToDate.setDescription(entityObj.getDescription());
        return repository.save(upToDate);
    }

    @Override
    public TelephoneExchange deleteById(Long id) {
        TelephoneExchange deleted = findById(id);
        repository.deleteById(id);
        if(!repository.findById(id).isPresent()) return deleted;
        else return null;
    }

    @Override
    public List<TelephoneExchange> findAll() {
        return repository.findAll();
    }
}
