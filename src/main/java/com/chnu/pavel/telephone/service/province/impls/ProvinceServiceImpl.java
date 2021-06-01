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
        return dao.findAll();
    }

    @Override
    public Province findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public Province create(Province province) {
        return dao.create(province);
    }

    @Override
    public Province updateById(Long id, Province province) {
        return dao.updateById(id, province);
    }

    @Override
    public Province deleteById(Long id) {
        return dao.deleteById(id);
    }

}
