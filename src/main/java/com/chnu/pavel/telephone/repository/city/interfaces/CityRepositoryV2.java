package com.chnu.pavel.telephone.repository.city.interfaces;

import com.chnu.pavel.telephone.model.City;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.CityRepositoryV2
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 07.04.2021|20:12
 * @Version CityRepositoryV2: 1.0
 */

@Repository
public interface CityRepositoryV2 extends MongoRepository<City, ObjectId> {
}
