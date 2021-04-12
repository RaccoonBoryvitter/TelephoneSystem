package com.chnu.pavel.telephone.service.address.interfaces;

import com.chnu.pavel.telephone.model.Address;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.AddressService
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 29.03.2021|03:18
 * @Version AddressService: 1.0
 */

public interface AddressService {

    Address getById(String id);
    Address create(Address address);
    Address update(Address address);
    Address delete(Address address);
    List<Address> getAll();

}
