package com.chnu.pavel.telephone.dao.city.impls;

import com.chnu.pavel.telephone.dao.city.interfaces.CityDAO;
import com.chnu.pavel.telephone.model.City;
import com.chnu.pavel.telephone.repository.city.interfaces.CityRepository;
import com.chnu.pavel.telephone.repository.city.interfaces.CityRepositoryV2;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.CityDAOImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 07.04.2021|19:45
 * @Version CityDAOImpl: 1.0
 */

@Component
@AllArgsConstructor
public class CityDAOImpl implements CityDAO {

    private final CityRepository repository;

    @Override
    public City create(City city) {
        return repository.create(city);
    }

    @Override
    public City getById(String id) {
        return repository.getById(id);
    }


    @Override
    public City updateById(City city, String id) {
        return repository.updateById(city, id);
    }

    @Override
    public String deleteById(String id) {
        repository.deleteById(id);
        return "Object was deleted";
    }

    @Override
    public List<City> getCities() {
        return repository.getCities();
    }
}
