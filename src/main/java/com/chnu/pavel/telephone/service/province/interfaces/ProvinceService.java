package com.chnu.pavel.telephone.service.province.interfaces;

import com.chnu.pavel.telephone.model.Province;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.ProvinceService
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 01.04.2021|01:18
 * @Version ProvinceService: 1.0
 */

@Service
public interface ProvinceService {

    Province create(Province province);
    Province getById(String id);
    Province updateById(Province province, String id);
    String deleteById(String id);

    List<Province> getAll();

}
