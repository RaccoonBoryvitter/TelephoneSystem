package com.chnu.pavel.telephone.dao.province.impls;

import com.chnu.pavel.telephone.dao.province.interfaces.ProvinceDAO;
import com.chnu.pavel.telephone.model.Province;
import com.chnu.pavel.telephone.repository.province.interfaces.ProvinceRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.ProvinceDAOImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 15.04.2021|00:51
 * @Version ProvinceDAOImpl: 1.0
 */

@Component
@AllArgsConstructor
public class ProvinceDAOImpl implements ProvinceDAO {

    private final ProvinceRepository repository;

    @Override
    public Province findProvinceById(String id) {
        return repository.findById(new ObjectId(id)).orElse(null);
    }

    @Override
    public Province updateProvinceById(Province province, String id) {
        Province upToDate = findProvinceById(id);
        upToDate.setName(province.getName());
        upToDate.setPhoneCode(province.getPhoneCode());
        upToDate.setState(province.getState());
        return repository.save(upToDate);
    }

    @Override
    public Province createProvince(Province province) {
        return repository.insert(province);
    }

    @Override
    public String deleteProvinceById(String id) {
        repository.deleteById(new ObjectId(id));
        return "Object " + id + " has been removed from Provinces";
    }

    @Override
    public List<Province> findAllProvinces() {
        return repository.findAll();
    }
}
