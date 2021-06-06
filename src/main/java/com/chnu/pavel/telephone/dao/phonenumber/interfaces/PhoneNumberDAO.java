package com.chnu.pavel.telephone.dao.phonenumber.interfaces;

import com.chnu.pavel.telephone.dao.GenericDAO;
import com.chnu.pavel.telephone.model.PhoneNumber;
import org.springframework.stereotype.Repository;

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
}
