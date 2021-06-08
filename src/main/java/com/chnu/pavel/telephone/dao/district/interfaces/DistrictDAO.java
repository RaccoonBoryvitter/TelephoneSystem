package com.chnu.pavel.telephone.dao.district.interfaces;

import com.chnu.pavel.telephone.dao.GenericDAO;
import com.chnu.pavel.telephone.model.City;
import com.chnu.pavel.telephone.model.District;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.DistrictDAO
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|15:35
 * @Version DistrictDAO: 1.0
 */

@Repository
public interface DistrictDAO extends GenericDAO<District> {

    Optional<District> findByName(String name);
    Optional<District> findByCity(City city);

}
