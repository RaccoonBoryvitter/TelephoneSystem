package com.chnu.pavel.telephone.service.installmentapplication.impls;

import com.chnu.pavel.telephone.dao.installmentapplication.interfaces.InstallmentApplicationDAO;
import com.chnu.pavel.telephone.helper.SequenceGeneratorService;
import com.chnu.pavel.telephone.model.Agency;
import com.chnu.pavel.telephone.model.InstallmentApplication;
import com.chnu.pavel.telephone.service.installmentapplication.interfaces.InstallmentApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.time.Instant;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.InstallmentApplicationServiceImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|18:20
 * @Version InstallmentApplicationServiceImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class InstallmentApplicationServiceImpl implements InstallmentApplicationService {

    private final InstallmentApplicationDAO dao;
    private final SequenceGeneratorService generatorService;

    @Override
    public InstallmentApplication findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public InstallmentApplication updateById(Long id, InstallmentApplication entityObj) {
        entityObj.setModified_at(Date.from(Instant.now()));
        return dao.updateById(id, entityObj);
    }

    @Override
    public InstallmentApplication create(InstallmentApplication entityObj) {
        entityObj.setId(generatorService.getSequenceNumber(InstallmentApplication.SEQUENCE_NAME));
        entityObj.setCreated_at(Date.from(Instant.now()));
        entityObj.setModified_at(Date.from(Instant.now()));
        return dao.create(entityObj);
    }

    @Override
    public InstallmentApplication deleteById(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public List<InstallmentApplication> findAll() {
        return dao.findAll();
    }
}
