package com.chnu.pavel.telephone.dao.user.interfaces;

import com.chnu.pavel.telephone.dao.GenericDAO;
import com.chnu.pavel.telephone.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.UserDAO
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 07.06.2021|22:00
 * @Version UserDAO: 1.0
 */

@Repository
public interface UserDAO extends GenericDAO<User> {
    User findByUsername(String username);
}
