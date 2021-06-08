package com.chnu.pavel.telephone.service.province.impls;

import com.chnu.pavel.telephone.dao.province.interfaces.ProvinceDAO;
import com.chnu.pavel.telephone.helper.SequenceGeneratorService;
import com.chnu.pavel.telephone.model.Province;
import com.chnu.pavel.telephone.service.province.interfaces.ProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

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
    private final SequenceGeneratorService generatorService;

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
        province.setId(generatorService.getSequenceNumber(Province.SEQUENCE_NAME));
        province.setCreated_at(Date.from(Instant.now()));
        province.setModified_at(Date.from(Instant.now()));
        return dao.create(province);
    }

    @Override
    public Province updateById(Long id, Province province) {
        province.setModified_at(Date.from(Instant.now()));
        return dao.updateById(id, province);
    }

    @Override
    public Province deleteById(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public Optional<Province> findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public Optional<Province> findByPhoneCode(String phoneCode) {
        return dao.findByPhoneCode(phoneCode);
    }

}
