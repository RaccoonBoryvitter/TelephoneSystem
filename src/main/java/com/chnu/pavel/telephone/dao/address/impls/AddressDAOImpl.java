package com.chnu.pavel.telephone.dao.address.impls;

import com.chnu.pavel.telephone.dao.address.interfaces.AddressDAO;
import com.chnu.pavel.telephone.model.Address;
import com.chnu.pavel.telephone.model.District;
import com.chnu.pavel.telephone.repository.address.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.AddressDAOImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 29.03.2021|02:44
 * @Version AddressDAOImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class AddressDAOImpl implements AddressDAO {

    private final AddressRepository addressRepository;

    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public Address create(Address entityObj) {
        return addressRepository.insert(entityObj);
    }

    @Override
    public Address updateById(Long id, Address entityObj) {
        Address upToDate = findById(id);
        upToDate.setDistrict(entityObj.getDistrict());
        upToDate.setStreet(entityObj.getStreet());
        upToDate.setBuilding(entityObj.getBuilding());
        if(entityObj.getApartmentNo() != null) upToDate.setApartmentNo(entityObj.getApartmentNo());
        upToDate.setZipCode(entityObj.getZipCode());
        upToDate.setModified_at(entityObj.getModified_at());
        upToDate.setDescription(entityObj.getDescription());
        return addressRepository.save(upToDate);
    }

    @Override
    public Address deleteById(Long id) {
        Address deleted = findById(id);
        addressRepository.deleteById(id);
        if(!addressRepository.findById(id).isPresent()) return deleted;
        else return null;
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> findByDistrict(District district) {
        return addressRepository.findByDistrict(district);
    }

    @Override
    public Optional<Address> findByStreet(String street) {
        return addressRepository.findByStreet(street);
    }

    @Override
    public Optional<Address> findByBuilding(String building) {
        return addressRepository.findByBuilding(building);
    }

    @Override
    public Optional<Address> findByZipCode(String zipCode) {
        return addressRepository.findByZipCode(zipCode);
    }
}
