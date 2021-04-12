package com.chnu.pavel.telephone.dao.address.impls;

import com.chnu.pavel.telephone.dao.address.interfaces.AddressDAO;
import com.chnu.pavel.telephone.model.Address;
import com.chnu.pavel.telephone.model.District;
import com.chnu.pavel.telephone.repository.address.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.AddressDAOImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 29.03.2021|02:44
 * @Version AddressDAOImpl: 1.0
 */

@Repository
@RequiredArgsConstructor
public class AddressDAOImpl implements AddressDAO {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public Address getById(String id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public Address create(Address entityObj) {
        return addressRepository.insert(entityObj);
    }

    @Override
    public Address update(Address entityObj) {
        if(addressRepository.findById(entityObj.getId()).isPresent())
            return addressRepository.save(entityObj);
        else
            return null;
    }

    @Override
    public Address delete(String id) {
        Address deleted = addressRepository.findById(id).orElse(null);
        addressRepository.deleteById(id);
        return deleted;
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }


    @Override
    public List<Address> getByDistrict(District district) {
        return addressRepository.findByDistrict(district);
    }

    @Override
    public List<Address> getByStreet(String street) {
        return addressRepository.findByStreet(street);
    }

    @Override
    public Address getByBuilding(String building) {
        return addressRepository.findByBuildingNo(building);
    }

    @Override
    public List<Address> getByZipCode(String zipCode) {
        return addressRepository.findByZipCode(zipCode);
    }
}
