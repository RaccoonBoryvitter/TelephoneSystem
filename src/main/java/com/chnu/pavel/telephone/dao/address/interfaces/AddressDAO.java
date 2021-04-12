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
    List<Address> getByDistrict(District district);

    List<Address> getByStreet(String street);

    Address getByBuilding(String building);

    List<Address> getByZipCode(String zipCode);

}
