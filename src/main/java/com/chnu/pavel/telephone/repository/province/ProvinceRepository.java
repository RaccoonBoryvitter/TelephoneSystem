package com.chnu.pavel.telephone.repository.province;

import com.chnu.pavel.telephone.model.Province;
import com.chnu.pavel.telephone.model.State;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.ProvinceRepository
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 29.03.2021|02:00
 * @Version ProvinceRepository: 1.0
 */

@Repository
public interface ProvinceRepository extends MongoRepository<Province, Long> {

    Optional<Province> findByName(String name);
    Optional<Province> findByPhoneCode(String phoneCode);

}
