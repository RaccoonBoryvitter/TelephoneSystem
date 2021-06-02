package com.chnu.pavel.telephone.dao.city.impls;

import com.chnu.pavel.telephone.dao.city.interfaces.CityDAO;
import com.chnu.pavel.telephone.model.City;
import com.chnu.pavel.telephone.model.Province;
import com.chnu.pavel.telephone.repository.city.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.CityDAOImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 15.04.2021|00:56
 * @Version CityDAOImpl: 1.0
 */

@Component
@AllArgsConstructor
public class CityDAOImpl implements CityDAO {

    private final CityRepository repository;

    @Override
    public City create(City city) {
        return repository.insert(city);
    }

    @Override
    public City findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public City updateById(Long id, City city) {
        City upToDate = findById(id);
        upToDate.setName(city.getName());
        upToDate.setPhoneCode(city.getPhoneCode());
        upToDate.setProvince(city.getProvince());
        upToDate.setModified_at(city.getModified_at());
        upToDate.setDescription(city.getDescription());
        return repository.save(upToDate);
    }

    @Override
    public City deleteById(Long id) {
        City deleted = findById(id);
        repository.deleteById(id);
        if(!repository.findById(id).isPresent()) return deleted;
        else return null;
    }

    @Override
    public List<City> findAll() {
        return repository.findAll();
    }
}
