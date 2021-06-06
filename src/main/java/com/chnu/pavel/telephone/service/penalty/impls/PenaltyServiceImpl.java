package com.chnu.pavel.telephone.service.penalty.impls;

import com.chnu.pavel.telephone.dao.penalty.interfaces.PenaltyDAO;
import com.chnu.pavel.telephone.model.Penalty;
import com.chnu.pavel.telephone.service.penalty.interfaces.PenaltyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.time.Instant;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.PenaltyServiceImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|18:32
 * @Version PenaltyServiceImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class PenaltyServiceImpl implements PenaltyService {

    private final PenaltyDAO dao;

    @Override
    public Penalty findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public Penalty updateById(Long id, Penalty entityObj) {
        entityObj.setModified_at(Date.from(Instant.now()));
        return dao.updateById(id, entityObj);
    }

    @Override
    public Penalty create(Penalty entityObj) {
        entityObj.setCreated_at(Date.from(Instant.now()));
        entityObj.setModified_at(Date.from(Instant.now()));
        return dao.create(entityObj);
    }

    @Override
    public Penalty deleteById(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public List<Penalty> findAll() {
        return dao.findAll();
    }
}
