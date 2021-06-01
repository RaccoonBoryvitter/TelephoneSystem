package com.chnu.pavel.telephone.service.province.impls;

import com.chnu.pavel.telephone.dao.province.interfaces.ProvinceDAO;
import com.chnu.pavel.telephone.model.Province;
import com.chnu.pavel.telephone.service.province.interfaces.ProvinceService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.ProvinceServiceImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 15.04.2021|00:29
 * @Version ProvinceServiceImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class ProvinceServiceImpl implements ProvinceService {

    private final ProvinceDAO dao;

    @Override
    public List<Province> findAll() {
        return dao.findAllProvinces();
    }

    @Override
    public Province findById(String id) {
        return dao.findProvinceById(id);
    }

    @Override
    public Province create(Province province) {
        return dao.createProvince(province);
    }

    @Override
    public Province updateById(Province province, String id) {
        return dao.updateProvinceById(province, id);
    }

    @Override
    public String deleteById(String id) {
        return dao.deleteProvinceById(id);
    }

}
