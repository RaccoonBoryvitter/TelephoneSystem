package com.chnu.pavel.telephone.dao.installmentapplication.impls;

import com.chnu.pavel.telephone.dao.installmentapplication.interfaces.InstallmentApplicationDAO;
import com.chnu.pavel.telephone.model.Establishment;
import com.chnu.pavel.telephone.model.InstallmentApplication;
import com.chnu.pavel.telephone.model.Phone;
import com.chnu.pavel.telephone.repository.installmentapplication.InstallmentApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.InstallmentApplicationDAOImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|16:25
 * @Version InstallmentApplicationDAOImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class InstallmentApplicationDAOImpl implements InstallmentApplicationDAO {

    private final InstallmentApplicationRepository repository;

    @Override
    public InstallmentApplication findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public InstallmentApplication create(InstallmentApplication entityObj) {
        return repository.insert(entityObj);
    }

    @Override
    public InstallmentApplication updateById(Long id, InstallmentApplication entityObj) {
        InstallmentApplication upToDate = findById(id);
        upToDate.setApplierFullName(entityObj.getApplierFullName());
        upToDate.setApplierBirthDay(entityObj.getApplierBirthDay());
        upToDate.setApplierGender(entityObj.getApplierGender());
        upToDate.setApplierPrivilegeType(entityObj.getApplierPrivilegeType());
        upToDate.setAvailableNumber(upToDate.getAvailableNumber());
        upToDate.setCableAvailability(upToDate.isChannelAvailability());
        upToDate.setChannelAvailability(upToDate.isChannelAvailability());
        upToDate.setInstallationTime(entityObj.getInstallationTime());
        upToDate.setQueueType(entityObj.getQueueType());
        upToDate.setOrder(entityObj.getOrder());
        upToDate.setModified_at(entityObj.getModified_at());
        upToDate.setDescription(entityObj.getDescription());
        return repository.save(upToDate);
    }

    @Override
    public InstallmentApplication deleteById(Long id) {
        InstallmentApplication deleted = findById(id);
        repository.deleteById(id);
        if(!repository.findById(id).isPresent()) return deleted;
        else return null;
    }

    @Override
    public List<InstallmentApplication> findAll() {
        return repository.findAll();
    }
}
