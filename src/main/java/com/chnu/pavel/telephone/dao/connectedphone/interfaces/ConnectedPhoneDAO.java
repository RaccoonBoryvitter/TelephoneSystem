package com.chnu.pavel.telephone.dao.connectedphone.interfaces;

import com.chnu.pavel.telephone.dao.GenericDAO;
import com.chnu.pavel.telephone.model.ConnectedPhone;
import com.chnu.pavel.telephone.model.Phone;
import com.chnu.pavel.telephone.model.PhoneNumber;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.ConnectedPhoneDAO
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|16:10
 * @Version ConnectedPhoneDAO: 1.0
 */

@Repository
public interface ConnectedPhoneDAO extends GenericDAO<ConnectedPhone> {
    Optional<ConnectedPhone> findByPhone(Phone phone);
    Optional<ConnectedPhone> findByPhoneNumber(PhoneNumber phoneNumber);
}
