package com.chnu.pavel.telephone.repository.address;

import com.chnu.pavel.telephone.model.Address;
import com.chnu.pavel.telephone.model.District;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.AddressRepository
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 28.03.2021|19:51
 * @Version AddressRepository: 1.0
 */

@Repository
public interface AddressRepository extends MongoRepository<Address, Long> {

    Optional<Address> findByDistrict(District district);
    Optional<Address> findByStreet(String street);
    Optional<Address> findByBuilding(String building);
    Optional<Address> findByZipCode(String zipCode);

}
