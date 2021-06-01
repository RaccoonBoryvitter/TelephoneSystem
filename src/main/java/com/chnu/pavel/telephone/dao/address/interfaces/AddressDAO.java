package com.chnu.pavel.telephone.dao.address.interfaces;

import com.chnu.pavel.telephone.dao.GenericDAO;
import com.chnu.pavel.telephone.model.Address;
import com.chnu.pavel.telephone.model.District;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.AddressDAO
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 28.03.2021|13:24
 * @Version AddressDAO: 1.0
 */

public interface AddressDAO extends GenericDAO<Address> {

    // additional read operations
    List<Address> findByDistrict(District district);

    List<Address> findByStreet(String street);

    Address findByBuilding(String building);

    List<Address> findByZipCode(String zipCode);

}
