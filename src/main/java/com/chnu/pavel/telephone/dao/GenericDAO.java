package com.chnu.pavel.telephone.dao;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.GenericDAO
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 10.03.2021|12:18
 * @Version GenericDAO: 1.0
 */

public interface GenericDAO<EntityObject> {

    EntityObject findById(Long id);
    EntityObject create(EntityObject entityObj);
    EntityObject updateById(Long id, EntityObject entityObject);
    EntityObject deleteById(Long id);
    List<EntityObject> findAll();

}
