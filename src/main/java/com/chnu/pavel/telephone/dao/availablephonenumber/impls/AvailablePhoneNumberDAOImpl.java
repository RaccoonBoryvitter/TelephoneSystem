package com.chnu.pavel.telephone.dao.availablephonenumber.impls;

import com.chnu.pavel.telephone.dao.availablephonenumber.interfaces.AvailablePhoneNumberDAO;
import com.chnu.pavel.telephone.model.AvailablePhoneNumber;
import com.chnu.pavel.telephone.model.TelephoneExchange;
import com.chnu.pavel.telephone.repository.availablephonenumber.AvailablePhoneNumberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.AvailablePhoneNumberDAOImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|16:00
 * @Version AvailablePhoneNumberDAOImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class AvailablePhoneNumberDAOImpl implements AvailablePhoneNumberDAO {

    private final AvailablePhoneNumberRepository repository;

    @Override
    public AvailablePhoneNumber findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public AvailablePhoneNumber create(AvailablePhoneNumber entityObj) {
        return repository.insert(entityObj);
    }

    @Override
    public AvailablePhoneNumber updateById(Long id, AvailablePhoneNumber entityObj) {
        AvailablePhoneNumber upToDate = findById(id);
        upToDate.setNumber(entityObj.getNumber());
        upToDate.setTelephoneExchange(entityObj.getTelephoneExchange());
        upToDate.setModified_at(entityObj.getModified_at());
        upToDate.setDescription(entityObj.getDescription());
        return repository.save(upToDate);
    }

    @Override
    public AvailablePhoneNumber deleteById(Long id) {
        AvailablePhoneNumber deleted = findById(id);
        repository.deleteById(id);
        if(!repository.findById(id).isPresent()) return deleted;
        else return null;
    }

    @Override
    public List<AvailablePhoneNumber> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<AvailablePhoneNumber> findByNumber(String number) {
        return repository.findByNumber(number);
    }

    @Override
    public Optional<AvailablePhoneNumber> findByTelephoneExchange(TelephoneExchange telephoneExchange) {
        return repository.findByTelephoneExchange(telephoneExchange);
    }
}
