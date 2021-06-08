package com.chnu.pavel.telephone.dao.agency.interfaces;

import com.chnu.pavel.telephone.dao.GenericDAO;
import com.chnu.pavel.telephone.model.Agency;
import com.chnu.pavel.telephone.model.TelephoneExchange;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.AgencyDAO
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|5:33
 * @Version AgencyDAO: 1.0
 */

@Repository
public interface AgencyDAO extends GenericDAO<Agency> {

    Optional<Agency> findByName(String number);
    Optional<Agency> findByTelephoneExchange(TelephoneExchange telephoneExchange);

}
