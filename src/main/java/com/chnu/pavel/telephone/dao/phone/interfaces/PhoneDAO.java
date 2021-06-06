package com.chnu.pavel.telephone.dao.phone.interfaces;

import com.chnu.pavel.telephone.dao.GenericDAO;
import com.chnu.pavel.telephone.model.Phone;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.PhoneDAO
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|16:17
 * @Version PhoneDAO: 1.0
 */

@Repository
public interface PhoneDAO extends GenericDAO<Phone> {
}
