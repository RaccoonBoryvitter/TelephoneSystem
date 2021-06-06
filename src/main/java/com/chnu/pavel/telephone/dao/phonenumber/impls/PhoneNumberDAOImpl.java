package com.chnu.pavel.telephone.dao.phonenumber.impls;

import com.chnu.pavel.telephone.dao.phonenumber.interfaces.PhoneNumberDAO;
import com.chnu.pavel.telephone.model.Establishment;
import com.chnu.pavel.telephone.model.PhoneNumber;
import com.chnu.pavel.telephone.repository.phonenumber.PhoneNumberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.PhoneNumberDAOImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|16:21
 * @Version PhoneNumberDAOImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class PhoneNumberDAOImpl implements PhoneNumberDAO {

    private final PhoneNumberRepository repository;

    @Override
    public PhoneNumber findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public PhoneNumber create(PhoneNumber entityObj) {
        return repository.insert(entityObj);
    }

    @Override
    public PhoneNumber updateById(Long id, PhoneNumber entityObj) {
        PhoneNumber upToDate = findById(id);
        upToDate.setNumber(entityObj.getNumber());
        upToDate.setAddress(entityObj.getAddress());
        upToDate.setTelephoneExchange(entityObj.getTelephoneExchange());
        upToDate.setModified_at(entityObj.getModified_at());
        upToDate.setDescription(entityObj.getDescription());
        return repository.save(upToDate);
    }

    @Override
    public PhoneNumber deleteById(Long id) {
        PhoneNumber deleted = findById(id);
        repository.deleteById(id);
        if(!repository.findById(id).isPresent()) return deleted;
        else return null;
    }

    @Override
    public List<PhoneNumber> findAll() {
        return repository.findAll();
    }
}
