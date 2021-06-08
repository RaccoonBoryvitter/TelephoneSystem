package com.chnu.pavel.telephone.dao.district.impls;

import com.chnu.pavel.telephone.dao.district.interfaces.DistrictDAO;
import com.chnu.pavel.telephone.model.City;
import com.chnu.pavel.telephone.model.District;
import com.chnu.pavel.telephone.model.Province;
import com.chnu.pavel.telephone.repository.district.DistrictRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.DistrictDAOImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|15:36
 * @Version DistrictDAOImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class DistrictDAOImpl implements DistrictDAO {

    private final DistrictRepository repository;

    @Override
    public District findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public District create(District entityObj) {
        return repository.insert(entityObj);
    }

    @Override
    public District updateById(Long id, District entityObj) {
        District upToDate = findById(id);
        upToDate.setName(entityObj.getName());
        upToDate.setCity(entityObj.getCity());
        upToDate.setModified_at(entityObj.getModified_at());
        upToDate.setDescription(entityObj.getDescription());
        return repository.save(upToDate);
    }

    @Override
    public District deleteById(Long id) {
        District deleted = findById(id);
        repository.deleteById(id);
        if(!repository.findById(id).isPresent()) return deleted;
        else return null;
    }

    @Override
    public List<District> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<District> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Optional<District> findByCity(City city) {
        return repository.findByCity(city);
    }
}
