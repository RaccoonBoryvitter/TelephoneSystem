package com.chnu.pavel.telephone.repository.province.interfaces;

import com.chnu.pavel.telephone.model.Province;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.ProvinceRepository
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 29.03.2021|02:00
 * @Version ProvinceRepository: 1.0
 */

@Repository
public interface ProvinceRepository extends MongoRepository<Province, ObjectId> {

}
