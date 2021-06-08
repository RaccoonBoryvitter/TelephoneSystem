package com.chnu.pavel.telephone.dao.subscriber.interfaces;

import com.chnu.pavel.telephone.dao.GenericDAO;
import com.chnu.pavel.telephone.model.ConnectedPhone;
import com.chnu.pavel.telephone.model.PhoneNumber;
import com.chnu.pavel.telephone.model.PrivilegeType;
import com.chnu.pavel.telephone.model.Subscriber;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.SubscriberAO
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|17:00
 * @Version SubscriberAO: 1.0
 */

@Repository
public interface SubscriberDAO extends GenericDAO<Subscriber> {

    Optional<Subscriber> findByPrivilegeType(PrivilegeType privilegeType);
    Optional<Subscriber> findByConnectedPhone(ConnectedPhone connectedPhone);

}
