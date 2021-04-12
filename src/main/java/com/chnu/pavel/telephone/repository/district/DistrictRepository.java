package com.chnu.pavel.telephone.repository.district;

import com.chnu.pavel.telephone.model.District;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.DistrictRepository
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 29.03.2021|02:05
 * @Version DistrictRepository: 1.0
 */

@Repository
public interface DistrictRepository extends MongoRepository<District, ObjectId> {
}
