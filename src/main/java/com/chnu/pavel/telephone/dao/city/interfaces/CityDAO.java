package com.chnu.pavel.telephone.dao.city.interfaces;

import com.chnu.pavel.telephone.model.City;
import com.chnu.pavel.telephone.repository.city.interfaces.CityRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.CityDAO
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 07.04.2021|19:45
 * @Version CityDAO: 1.0
 */

@Repository
public interface CityDAO {

    City create(City city);
    City findById(String id);
    City updateById(City city, String id);
    String deleteById(String id);

    List<City> findAll();


}
