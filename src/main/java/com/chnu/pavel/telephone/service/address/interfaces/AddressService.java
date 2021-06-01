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

    Address findById(Long id);
    Address create(Address address);
    Address updateById(Long id, Address address);
    Address deleteById(Long id);
    List<Address> findAll();

}
