package com.chnu.pavel.telephone.repository.user;

import com.chnu.pavel.telephone.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.UserRepository
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 07.06.2021|20:53
 * @Version UserRepository: 1.0
 */

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

    User findByEmail(String email);
    User findByUsername(String username);

}
