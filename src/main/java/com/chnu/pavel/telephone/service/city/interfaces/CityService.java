package com.chnu.pavel.telephone.service.city.interfaces;

import com.chnu.pavel.telephone.dao.city.interfaces.CityDAO;
import com.chnu.pavel.telephone.model.City;
import com.chnu.pavel.telephone.service.GenericService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.CityService
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 07.04.2021|19:49
 * @Version CityService: 1.0
 */

@Service
public interface CityService extends GenericService<City> {


}
