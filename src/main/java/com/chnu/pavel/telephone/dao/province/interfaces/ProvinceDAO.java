package com.chnu.pavel.telephone.dao.province.interfaces;

import com.chnu.pavel.telephone.model.Province;
import com.chnu.pavel.telephone.repository.province.interfaces.ProvinceRepository;
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

    Province findProvinceById(String id);
    Province updateProvinceById(Province province, String id);
    Province createProvince(Province province);
    String deleteProvinceById(String id);

    List<Province> findAllProvinces();

}
