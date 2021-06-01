package com.chnu.pavel.telephone.repository.address;

import com.chnu.pavel.telephone.model.Address;
import com.chnu.pavel.telephone.model.District;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Query("{ 'district' : ?0 }")
    List<Address> findByDistrict(District district);

    @Query("{ 'street' : ?0 }")
    List<Address> findByStreet(String street);

    @Query("{ 'building' : ?0 }")
    Address findByBuildingNo(String building);

    @Query("{ 'zipCode' : ?0 }")
    List<Address> findByZipCode(String zipCode);

}
