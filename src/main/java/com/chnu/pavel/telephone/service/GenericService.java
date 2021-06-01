package com.chnu.pavel.telephone.service;

import com.chnu.pavel.telephone.model.Province;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.GenericService
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 02.06.2021|1:29
 * @Version GenericService: 1.0
 */

public interface GenericService<EntityObject> {

    EntityObject findById(Long id);
    EntityObject updateById(Long id, EntityObject entityObj);
    EntityObject create(EntityObject entityObj);
    EntityObject deleteById(Long id);

    List<EntityObject> findAll();

}
