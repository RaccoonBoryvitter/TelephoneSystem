package com.chnu.pavel.telephone.repository.province.interfaces;

import com.chnu.pavel.telephone.model.Province;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.ProvinceRepository
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 29.03.2021|02:00
 * @Version ProvinceRepository: 1.0
 */

@Repository
public interface ProvinceRepository {

    Province create(Province Province);
    Province getById(String id);
    Province getByName(String name);
    Province getByState(String state);
    Province updateById(Province province, String id);
    String deleteById(String id);

    List<Province> getAll();

}
