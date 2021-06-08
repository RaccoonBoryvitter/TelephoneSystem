package com.chnu.pavel.telephone.service.district.impls;

import com.chnu.pavel.telephone.dao.district.interfaces.DistrictDAO;
import com.chnu.pavel.telephone.helper.SequenceGeneratorService;
import com.chnu.pavel.telephone.model.City;
import com.chnu.pavel.telephone.model.District;
import com.chnu.pavel.telephone.service.district.interfaces.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.DistrictServiceImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|17:33
 * @Version DistrictServiceImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class DistrictServiceImpl implements DistrictService {

    private final DistrictDAO dao;
    private final SequenceGeneratorService generatorService;

    @Override
    public District findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public District updateById(Long id, District entityObj) {
        entityObj.setModified_at(Date.from(Instant.now()));
        return dao.updateById(id, entityObj);
    }

    @Override
    public District create(District entityObj) {
        entityObj.setId(generatorService.getSequenceNumber(District.SEQUENCE_NAME));
        entityObj.setCreated_at(Date.from(Instant.now()));
        entityObj.setModified_at(Date.from(Instant.now()));
        return dao.create(entityObj);
    }

    @Override
    public District deleteById(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public List<District> findAll() {

        return dao.findAll();
    }

    @Override
    public Optional<District> findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public Optional<District> findByCity(City city) {
        return dao.findByCity(city);
    }
}
