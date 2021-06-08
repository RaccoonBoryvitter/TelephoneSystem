package com.chnu.pavel.telephone.dao.availablephonenumber.interfaces;

import com.chnu.pavel.telephone.dao.GenericDAO;
import com.chnu.pavel.telephone.model.AvailablePhoneNumber;
import com.chnu.pavel.telephone.model.TelephoneExchange;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.AvailablePhoneNumberRepository
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|15:56
 * @Version AvailablePhoneNumberRepository: 1.0
 */

@Repository
public interface AvailablePhoneNumberDAO extends GenericDAO<AvailablePhoneNumber> {

    Optional<AvailablePhoneNumber> findByNumber(String number);
    Optional<AvailablePhoneNumber> findByTelephoneExchange(TelephoneExchange telephoneExchange);
}
