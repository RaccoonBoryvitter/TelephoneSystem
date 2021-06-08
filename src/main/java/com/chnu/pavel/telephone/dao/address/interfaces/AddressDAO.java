package com.chnu.pavel.telephone.dao.address.interfaces;

import com.chnu.pavel.telephone.dao.GenericDAO;
import com.chnu.pavel.telephone.model.Address;
import com.chnu.pavel.telephone.model.District;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.AddressDAO
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 28.03.2021|13:24
 * @Version AddressDAO: 1.0
 */

@Repository
public interface AddressDAO extends GenericDAO<Address> {

    Optional<Address> findByDistrict(District district);
    Optional<Address> findByStreet(String street);
    Optional<Address> findByBuilding(String building);
    Optional<Address> findByZipCode(String zipCode);

}
