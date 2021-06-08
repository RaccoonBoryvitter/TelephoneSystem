package com.chnu.pavel.telephone.service.district.interfaces;

import com.chnu.pavel.telephone.model.City;
import com.chnu.pavel.telephone.model.District;
import com.chnu.pavel.telephone.service.GenericService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.DistrictService
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|17:33
 * @Version DistrictService: 1.0
 */

@Service
public interface DistrictService extends GenericService<District> {

    Optional<District> findByName(String name);
    Optional<District> findByCity(City city);

}
