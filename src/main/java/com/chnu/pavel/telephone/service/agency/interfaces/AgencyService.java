package com.chnu.pavel.telephone.service.agency.interfaces;

import com.chnu.pavel.telephone.model.Agency;
import com.chnu.pavel.telephone.model.TelephoneExchange;
import com.chnu.pavel.telephone.service.GenericService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.AgencyService
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|18:06
 * @Version AgencyService: 1.0
 */

@Service
public interface AgencyService extends GenericService<Agency> {

    Optional<Agency> findByName(String number);
    Optional<Agency> findByTelephoneExchange(TelephoneExchange telephoneExchange);
}
