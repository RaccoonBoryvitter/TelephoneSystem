package com.chnu.pavel.telephone.dao.establishment.impls;

import com.chnu.pavel.telephone.dao.establishment.interfaces.EstablishmentDAO;
import com.chnu.pavel.telephone.model.ConnectedPhone;
import com.chnu.pavel.telephone.model.Establishment;
import com.chnu.pavel.telephone.repository.establishment.EstablishmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.EstablishmentDAOImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|16:15
 * @Version EstablishmentDAOImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class EstablishmentDAOImpl implements EstablishmentDAO {

    private final EstablishmentRepository repository;

    @Override
    public Establishment findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Establishment create(Establishment entityObj) {
        return repository.insert(entityObj);
    }

    @Override
    public Establishment updateById(Long id, Establishment entityObj) {
        Establishment upToDate = findById(id);
        upToDate.setName(entityObj.getName());
        upToDate.setTelephoneExchange(entityObj.getTelephoneExchange());
        upToDate.setModified_at(entityObj.getModified_at());
        upToDate.setDescription(entityObj.getDescription());
        return repository.save(upToDate);
    }

    @Override
    public Establishment deleteById(Long id) {
        Establishment deleted = findById(id);
        repository.deleteById(id);
        if(!repository.findById(id).isPresent()) return deleted;
        else return null;
    }

    @Override
    public List<Establishment> findAll() {
        return repository.findAll();
    }
}
