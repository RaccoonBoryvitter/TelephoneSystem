package com.chnu.pavel.telephone.dao.installmentapplication.interfaces;

import com.chnu.pavel.telephone.dao.GenericDAO;
import com.chnu.pavel.telephone.model.AvailablePhoneNumber;
import com.chnu.pavel.telephone.model.InstallmentApplication;
import com.chnu.pavel.telephone.model.QueueType;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.InstallmentApplicationDAO
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|16:24
 * @Version InstallmentApplicationDAO: 1.0
 */

@Repository
public interface InstallmentApplicationDAO extends GenericDAO<InstallmentApplication> {
    Optional<InstallmentApplication> findByQueueType(QueueType queueType);
    Optional<InstallmentApplication> findByAvailablePhoneNumber(AvailablePhoneNumber availablePhoneNumber);
}
