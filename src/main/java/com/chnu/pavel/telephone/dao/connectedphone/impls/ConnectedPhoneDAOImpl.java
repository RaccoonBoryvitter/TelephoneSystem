package com.chnu.pavel.telephone.dao.connectedphone.impls;

import com.chnu.pavel.telephone.dao.connectedphone.interfaces.ConnectedPhoneDAO;
import com.chnu.pavel.telephone.model.City;
import com.chnu.pavel.telephone.model.ConnectedPhone;
import com.chnu.pavel.telephone.model.Phone;
import com.chnu.pavel.telephone.model.PhoneNumber;
import com.chnu.pavel.telephone.repository.connectedphone.ConnectedPhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.ConnectedPhoneDAOImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|16:10
 * @Version ConnectedPhoneDAOImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class ConnectedPhoneDAOImpl implements ConnectedPhoneDAO {

    private final ConnectedPhoneRepository repository;

    @Override
    public ConnectedPhone findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public ConnectedPhone create(ConnectedPhone entityObj) {
        return repository.insert(entityObj);
    }

    @Override
    public ConnectedPhone updateById(Long id, ConnectedPhone entityObj) {
        ConnectedPhone upToDate = findById(id);
        upToDate.setPhoneNumber(entityObj.getPhoneNumber());
        upToDate.setPhone(entityObj.getPhone());
        upToDate.setModified_at(entityObj.getModified_at());
        upToDate.setDescription(entityObj.getDescription());
        return repository.save(upToDate);
    }

    @Override
    public ConnectedPhone deleteById(Long id) {
        ConnectedPhone deleted = findById(id);
        repository.deleteById(id);
        if(!repository.findById(id).isPresent()) return deleted;
        else return null;
    }

    @Override
    public List<ConnectedPhone> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ConnectedPhone> findByPhone(Phone phone) {
        return repository.findByPhone(phone);
    }

    @Override
    public Optional<ConnectedPhone> findByPhoneNumber(PhoneNumber phoneNumber) {
        return repository.findByPhoneNumber(phoneNumber);
    }
}
