package com.chnu.pavel.telephone.service.address.impls;

import com.chnu.pavel.telephone.dao.address.impls.AddressDAOImpl;
import com.chnu.pavel.telephone.model.Address;
import com.chnu.pavel.telephone.service.address.interfaces.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.AddressServiceImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 29.03.2021|03:20
 * @Version AddressServiceImpl: 1.0
 */

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressDAOImpl addressDAO;


    @Override
    public Address getById(String id) {
        return addressDAO.getById(id);
    }

    @Override
    public Address create(Address address) {
        return addressDAO.create(address);
    }

    @Override
    public Address update(Address address) {
        return addressDAO.update(address);
    }

    @Override
    public Address delete(Address address) {
        return addressDAO.delete(address.getId());
    }

    @Override
    public List<Address> getAll() {
        return addressDAO.getAll();
    }
}
