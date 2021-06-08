package com.chnu.pavel.telephone.dao.phonenumber.interfaces;

import com.chnu.pavel.telephone.dao.GenericDAO;
import com.chnu.pavel.telephone.model.Address;
import com.chnu.pavel.telephone.model.PhoneNumber;
import com.chnu.pavel.telephone.model.TelephoneExchange;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.PhoneNumberDAO
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|16:21
 * @Version PhoneNumberDAO: 1.0
 */

@Repository
public interface PhoneNumberDAO extends GenericDAO<PhoneNumber> {
    Optional<PhoneNumber> findByNumber(String number);
    Optional<PhoneNumber> findByTelephoneExchange(TelephoneExchange telephoneExchange);
    Optional<PhoneNumber> findByAddress(Address address);
}
