package com.chnu.pavel.telephone.dao.province.interfaces;

import com.chnu.pavel.telephone.model.Province;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.ProvinceDAO
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 01.04.2021|01:15
 * @Version ProvinceDAO: 1.0
 */

@Repository
public interface ProvinceDAO {

    Province create(Province province);
    Province getById(String id);
    Province updateById(Province province, String id);
    String deleteById(String id);

    List<Province> getAll();

}
