package com.chnu.pavel.telephone.service.city.impls;

import com.chnu.pavel.telephone.dao.city.interfaces.CityDAO;
import com.chnu.pavel.telephone.model.City;
import com.chnu.pavel.telephone.service.city.interfaces.CityService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.CityServiceImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 15.04.2021|00:23
 * @Version CityServiceImpl: 1.0
 */

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityDAO dao;

    @Override
    public List<City> findAll() {
        return dao.findAll();
    }

    @Override
    public City create(City city) {
        return dao.create(city);
    }

    @Override
    public City findById(String id) {
        return dao.findById(id);
    }

    @Override
    public City updateById(City city, String id) {
        return dao.updateById(city, id);
    }

    @Override
    public String deleteById(String id) {
        return dao.deleteById(id);
    }

}
