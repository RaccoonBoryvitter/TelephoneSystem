package com.chnu.pavel.telephone.service.province.impls;

import com.chnu.pavel.telephone.dao.province.interfaces.ProvinceDAO;
import com.chnu.pavel.telephone.model.Province;
import com.chnu.pavel.telephone.service.province.interfaces.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.ProvinceServiceImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 01.04.2021|01:20
 * @Version ProvinceServiceImpl: 1.0
 */

@Component
public class ProvinceServiceImpl implements ProvinceService {

    @Qualifier("provinceDAOImpl")
    @Autowired
    private ProvinceDAO dao;

    @Override
    public Province create(Province province) {
        return dao.create(province);
    }

    @Override
    public Province getById(String id) {
        return dao.getById(id);
    }

    @Override
    public Province updateById(Province province, String id) {
        return dao.updateById(province, id);
    }

    @Override
    public String deleteById(String id) {
        return dao.deleteById(id);
    }

    @Override
    public List<Province> getAll() {
        return dao.getAll();
    }
}
