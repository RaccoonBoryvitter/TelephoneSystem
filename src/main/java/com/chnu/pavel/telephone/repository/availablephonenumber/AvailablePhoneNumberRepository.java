package com.chnu.pavel.telephone.repository.availablephonenumber;

import com.chnu.pavel.telephone.model.AvailablePhoneNumber;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.AvailablePhoneNumberRepository
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 02.06.2021|0:27
 * @Version AvailablePhoneNumberRepository: 1.0
 */

public interface AvailablePhoneNumberRepository extends MongoRepository<AvailablePhoneNumber, Long> {
}
