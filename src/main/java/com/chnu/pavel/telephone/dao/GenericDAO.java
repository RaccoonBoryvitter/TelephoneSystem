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

    EntityObject getById(String id);
    EntityObject create(EntityObject entityObj);
    EntityObject update(EntityObject entityObj);
    EntityObject delete(String id);
    List<EntityObject> getAll();

}
