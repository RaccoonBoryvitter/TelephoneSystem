package com.chnu.pavel.telephone.service.address.interfaces;

import com.chnu.pavel.telephone.model.Address;
import com.chnu.pavel.telephone.model.District;
import com.chnu.pavel.telephone.service.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.AddressService
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 29.03.2021|03:18
 * @Version AddressService: 1.0
 */

@Service
public interface AddressService extends GenericService<Address> {
    Optional<Address> findByDistrict(District district);
    Optional<Address> findByStreet(String street);
    Optional<Address> findByBuilding(String building);
    Optional<Address> findByZipCode(String zipCode);

}
