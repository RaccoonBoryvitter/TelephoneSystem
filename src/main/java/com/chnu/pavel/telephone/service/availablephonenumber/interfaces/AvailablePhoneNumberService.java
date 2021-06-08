package com.chnu.pavel.telephone.service.availablephonenumber.interfaces;

import com.chnu.pavel.telephone.model.AvailablePhoneNumber;
import com.chnu.pavel.telephone.model.TelephoneExchange;
import com.chnu.pavel.telephone.service.GenericService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.AvailablePhoneNumberService
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|18:00
 * @Version AvailablePhoneNumberService: 1.0
 */

@Service
public interface AvailablePhoneNumberService extends GenericService<AvailablePhoneNumber> {
    Optional<AvailablePhoneNumber> findByNumber(String number);
    Optional<AvailablePhoneNumber> findByTelephoneExchange(TelephoneExchange telephoneExchange);
}
