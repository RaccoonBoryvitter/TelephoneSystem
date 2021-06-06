package com.chnu.pavel.telephone.service.city.impls;

import com.chnu.pavel.telephone.dao.city.interfaces.CityDAO;
import com.chnu.pavel.telephone.model.City;
import com.chnu.pavel.telephone.service.city.interfaces.CityService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.time.Instant;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.CityServiceImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 15.04.2021|00:23
 * @Version CityServiceImpl: 1.0
 */

@Component
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityDAO dao;

    @Override
    public List<City> findAll() {
        dao.findAll().stream()
           .filter(c -> c.getProvince() == null)
           .forEach(c -> dao.deleteById(c.getId()));

        return dao.findAll();
    }

    @Override
    public City create(City city) {
        city.setCreated_at(Date.from(Instant.now()));
        city.setModified_at(Date.from(Instant.now()));
        return dao.create(city);
    }

    @Override
    public City findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public City updateById(Long id, City city) {
        city.setModified_at(Date.from(Instant.now()));
        return dao.updateById(id, city);
    }

    @Override
    public City deleteById(Long id) {
        return dao.deleteById(id);
    }

}
