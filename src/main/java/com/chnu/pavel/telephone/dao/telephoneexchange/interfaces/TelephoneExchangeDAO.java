package com.chnu.pavel.telephone.dao.telephoneexchange.interfaces;

import com.chnu.pavel.telephone.dao.GenericDAO;
import com.chnu.pavel.telephone.model.Address;
import com.chnu.pavel.telephone.model.StationType;
import com.chnu.pavel.telephone.model.TelephoneExchange;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.TelephoneExchangeDAO
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|15:46
 * @Version TelephoneExchangeDAO: 1.0
 */

@Repository
public interface TelephoneExchangeDAO extends GenericDAO<TelephoneExchange> {

    Optional<TelephoneExchange> findByCodeName(String codeName);
    Optional<TelephoneExchange> findByAddress(Address address);
    Optional<TelephoneExchange> findByStationType(StationType stationType);
    Optional<TelephoneExchange> findByWorkingStatus(boolean workingStatus);

}
