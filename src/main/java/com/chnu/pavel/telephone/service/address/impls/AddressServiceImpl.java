package com.chnu.pavel.telephone.service.address.impls;

import com.chnu.pavel.telephone.dao.address.interfaces.AddressDAO;
import com.chnu.pavel.telephone.model.Address;
import com.chnu.pavel.telephone.service.address.interfaces.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    private final AddressDAO addressDAO;


    @Override
    public Address findById(Long id) {
        return addressDAO.findById(id);
    }

    @Override
    public Address create(Address address) {
        address.setCreated_at(LocalDateTime.now());
        address.setModified_at(LocalDateTime.now());
        return addressDAO.create(address);
    }

    @Override
    public Address updateById(Long id, Address address) {
        address.setModified_at(LocalDateTime.now());
        return addressDAO.updateById(id, address);
    }

    @Override
    public Address deleteById(Long id) {
        return addressDAO.deleteById(id);
    }

    @Override
    public List<Address> findAll() {
        return addressDAO.findAll();
    }
}
