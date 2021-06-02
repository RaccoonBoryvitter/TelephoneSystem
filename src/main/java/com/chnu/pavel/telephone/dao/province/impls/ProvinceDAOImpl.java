package com.chnu.pavel.telephone.dao.province.impls;

import com.chnu.pavel.telephone.dao.province.interfaces.ProvinceDAO;
import com.chnu.pavel.telephone.model.Province;
import com.chnu.pavel.telephone.repository.province.ProvinceRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.ProvinceDAOImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 15.04.2021|00:51
 * @Version ProvinceDAOImpl: 1.0
 */

@Component
@AllArgsConstructor
public class ProvinceDAOImpl implements ProvinceDAO {

    private final ProvinceRepository repository;

    @Override
    public Province findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Province updateById(Long id, Province province) {
        Province upToDate = findById(id);
        upToDate.setName(province.getName());
        upToDate.setPhoneCode(province.getPhoneCode());
        upToDate.setState(province.getState());
        upToDate.setModified_at(province.getModified_at());
        upToDate.setDescription(province.getDescription());
        return repository.save(upToDate);
    }

    @Override
    public Province create(Province province) {
        return repository.insert(province);
    }

    @Override
    public Province deleteById(Long id) {
        Province deleted = findById(id);
        repository.deleteById(id);
        if(!repository.findById(id).isPresent()) return deleted;
        else return null;
    }

    @Override
    public List<Province> findAll() {
        return repository.findAll();
    }
}
