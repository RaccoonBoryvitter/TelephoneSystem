package com.chnu.pavel.telephone.dao.penalty.impls;

import com.chnu.pavel.telephone.dao.penalty.interfaces.PenaltyDAO;
import com.chnu.pavel.telephone.model.InstallmentApplication;
import com.chnu.pavel.telephone.model.Penalty;
import com.chnu.pavel.telephone.repository.penalty.PenaltyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.PenaltyDAOImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|17:04
 * @Version PenaltyDAOImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class PenaltyDAOImpl implements PenaltyDAO {

    private final PenaltyRepository repository;

    @Override
    public Penalty findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Penalty create(Penalty entityObj) {
        return repository.insert(entityObj);
    }

    @Override
    public Penalty updateById(Long id, Penalty entityObj) {
        Penalty upToDate = findById(id);
        upToDate.setCost(entityObj.getCost());
        upToDate.setWarningSent(entityObj.isWarningSent());
        upToDate.setPenaltyDaysAmount(entityObj.getPenaltyDaysAmount());
        upToDate.setModified_at(entityObj.getModified_at());
        upToDate.setDescription(entityObj.getDescription());
        return repository.save(upToDate);
    }

    @Override
    public Penalty deleteById(Long id) {
        Penalty deleted = findById(id);
        repository.deleteById(id);
        if(!repository.findById(id).isPresent()) return deleted;
        else return null;
    }

    @Override
    public List<Penalty> findAll() {
        return repository.findAll();
    }
}
