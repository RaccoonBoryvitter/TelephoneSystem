package com.chnu.pavel.telephone.repository.connectedphone;

import com.chnu.pavel.telephone.model.*;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.ConnectedPhoneRepository
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 02.06.2021|0:28
 * @Version ConnectedPhoneRepository: 1.0
 */

public interface ConnectedPhoneRepository extends MongoRepository<ConnectedPhone, Long> {

    Optional<ConnectedPhone> findByPhone(Phone phone);
    Optional<ConnectedPhone> findByPhoneNumber(PhoneNumber phoneNumber);

}
