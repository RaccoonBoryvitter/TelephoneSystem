package com.chnu.pavel.telephone.dao.establishment.interfaces;

import com.chnu.pavel.telephone.dao.GenericDAO;
import com.chnu.pavel.telephone.model.Establishment;
import com.chnu.pavel.telephone.model.TelephoneExchange;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.EstablishmentDAO
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|16:14
 * @Version EstablishmentDAO: 1.0
 */

@Repository
public interface EstablishmentDAO extends GenericDAO<Establishment> {
    Optional<Establishment> findByName(String name);
    Optional<Establishment> findByTelephoneExchange(TelephoneExchange telephoneExchange);
}
