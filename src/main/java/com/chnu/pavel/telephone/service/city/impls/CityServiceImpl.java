package com.chnu.pavel.telephone.service.city.impls;

import com.chnu.pavel.telephone.dao.city.interfaces.CityDAO;
import com.chnu.pavel.telephone.model.City;
import com.chnu.pavel.telephone.service.city.interfaces.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.CityServiceImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 07.04.2021|19:50
 * @Version CityServiceImpl: 1.0
 */

@Component
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityDAO dao;

    @Override
    public City create(City city) {
        return dao.create(city);
    }

    @Override
    public City getById(String id) {
        return dao.getById(id);
    }

    @Override
    public City updateById(City city, String id) {
        return dao.updateById(city, id);
    }

    @Override
    public String deleteById(String id) {
        return dao.deleteById(id);
    }

    @Override
    public List<City> getCities() {
        return dao.getCities();
    }
}
