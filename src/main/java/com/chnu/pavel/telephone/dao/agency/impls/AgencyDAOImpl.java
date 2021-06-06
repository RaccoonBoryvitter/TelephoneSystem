package com.chnu.pavel.telephone.dao.agency.impls;

import com.chnu.pavel.telephone.dao.agency.interfaces.AgencyDAO;
import com.chnu.pavel.telephone.model.Agency;
import com.chnu.pavel.telephone.model.Province;
import com.chnu.pavel.telephone.repository.agency.AgencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.AgencyDAOImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|5:34
 * @Version AgencyDAOImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class AgencyDAOImpl implements AgencyDAO {

    private final AgencyRepository repository;

    @Override
    public Agency findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Agency create(Agency entityObj) {
        return repository.insert(entityObj);
    }

    @Override
    public Agency updateById(Long id, Agency agency) {
        Agency upToDate = findById(id);
        upToDate.setName(agency.getName());
        upToDate.setOwner(agency.getOwner());
        upToDate.setTelephoneExchange(agency.getTelephoneExchange());
        upToDate.setModified_at(agency.getModified_at());
        upToDate.setDescription(agency.getDescription());
        return repository.save(upToDate);
    }

    @Override
    public Agency deleteById(Long id) {
        Agency deleted = findById(id);
        repository.deleteById(id);
        if(!repository.findById(id).isPresent()) return deleted;
        else return null;
    }

    @Override
    public List<Agency> findAll() {
        return repository.findAll();
    }
}
