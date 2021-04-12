package com.chnu.pavel.telephone;

import com.chnu.pavel.telephone.repository.city.interfaces.CityRepository;
import com.chnu.pavel.telephone.repository.city.interfaces.CityRepositoryV2;
import com.chnu.pavel.telephone.repository.district.DistrictRepository;
import com.chnu.pavel.telephone.repository.province.interfaces.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TelephoneSystemApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TelephoneSystemApplication.class, args);
    }

    @Autowired
    DistrictRepository districtRepository;

    @Autowired
    ProvinceRepository provinceRepository;

    @Autowired
    CityRepository cityRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("provinceRepository.getAll() = " + provinceRepository.getAll());
        System.out.println("cityRepository.getCities() = " + cityRepository.getCities());
    }
}
