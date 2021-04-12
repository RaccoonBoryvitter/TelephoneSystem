package com.chnu.pavel.telephone.repository.city.interfaces;

import com.chnu.pavel.telephone.model.City;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.CityRepository
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 07.04.2021|19:25
 * @Version CityRepository: 1.0
 */

@Repository
public interface CityRepository {

    City create(City city);
    City getById(String id);
    City getByName(String name);
    City updateById(City city, String id);
    String deleteById(String id);

    List<City> getCities();
}
