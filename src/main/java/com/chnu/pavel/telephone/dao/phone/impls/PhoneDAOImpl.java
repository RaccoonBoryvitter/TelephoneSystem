package com.chnu.pavel.telephone.dao.phone.impls;

import com.chnu.pavel.telephone.dao.phone.interfaces.PhoneDAO;
import com.chnu.pavel.telephone.model.Establishment;
import com.chnu.pavel.telephone.model.Phone;
import com.chnu.pavel.telephone.model.PhoneType;
import com.chnu.pavel.telephone.repository.phone.PhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.PhoneDAOImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|16:17
 * @Version PhoneDAOImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class PhoneDAOImpl implements PhoneDAO {

    private final PhoneRepository repository;

    @Override
    public Phone findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Phone create(Phone entityObj) {
        return repository.insert(entityObj);
    }

    @Override
    public Phone updateById(Long id, Phone entityObj) {
        Phone upToDate = findById(id);
        upToDate.setName(entityObj.getName());
        upToDate.setPhoneType(entityObj.getPhoneType());
        upToDate.setWorking(entityObj.isWorking());
        upToDate.setModified_at(entityObj.getModified_at());
        upToDate.setDescription(entityObj.getDescription());
        return repository.save(upToDate);
    }

    @Override
    public Phone deleteById(Long id) {
        Phone deleted = findById(id);
        repository.deleteById(id);
        if(!repository.findById(id).isPresent()) return deleted;
        else return null;
    }

    @Override
    public List<Phone> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Phone> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Optional<Phone> findBPhoneType(PhoneType phoneType) {
        return repository.findByPhoneType(phoneType);
    }
}
