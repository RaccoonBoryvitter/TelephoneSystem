package com.chnu.pavel.telephone.dao.province.impls;

import com.chnu.pavel.telephone.dao.province.interfaces.ProvinceDAO;
import com.chnu.pavel.telephone.model.Province;
import com.chnu.pavel.telephone.repository.province.interfaces.ProvinceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.ProvinceDAOImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 01.04.2021|01:16
 * @Version ProvinceDAOImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class ProvinceDAOImpl implements ProvinceDAO {

    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public Province create(Province province) {
        return provinceRepository.create(province);
    }

    @Override
    public Province getById(String id) {
        return provinceRepository.getById(id);
    }

    @Override
    public Province updateById(Province province, String id) {
        return provinceRepository.updateById(province, id);
    }

    @Override
    public String deleteById(String id) {
        return provinceRepository.deleteById(id);
    }

    @Override
    public List<Province> getAll() {
        return provinceRepository.getAll();
    }
}
