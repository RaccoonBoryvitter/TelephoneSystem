package com.chnu.pavel.telephone.service.phone.impls;

import com.chnu.pavel.telephone.dao.phone.interfaces.PhoneDAO;
import com.chnu.pavel.telephone.helper.SequenceGeneratorService;
import com.chnu.pavel.telephone.model.Agency;
import com.chnu.pavel.telephone.model.Phone;
import com.chnu.pavel.telephone.service.phone.interfaces.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.time.Instant;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.PhoneServiceImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|18:10
 * @Version PhoneServiceImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class PhoneServiceImpl implements PhoneService {

    private final PhoneDAO dao;
    private final SequenceGeneratorService generatorService;

    @Override
    public Phone findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public Phone updateById(Long id, Phone entityObj) {
        entityObj.setModified_at(Date.from(Instant.now()));
        return dao.updateById(id, entityObj);
    }

    @Override
    public Phone create(Phone entityObj) {
        entityObj.setId(generatorService.getSequenceNumber(Phone.SEQUENCE_NAME));
        entityObj.setCreated_at(Date.from(Instant.now()));
        entityObj.setModified_at(Date.from(Instant.now()));
        return dao.create(entityObj);
    }

    @Override
    public Phone deleteById(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public List<Phone> findAll() {
        return dao.findAll();
    }
}
