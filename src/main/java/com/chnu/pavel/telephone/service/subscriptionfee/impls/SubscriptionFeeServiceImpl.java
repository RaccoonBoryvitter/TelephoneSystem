package com.chnu.pavel.telephone.service.subscriptionfee.impls;

import com.chnu.pavel.telephone.dao.subscriptionfee.interfaces.SubscriptionFeeDAO;
import com.chnu.pavel.telephone.model.SubscriptionFee;
import com.chnu.pavel.telephone.service.subscriptionfee.interfaces.SubscriptionFeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.time.Instant;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.SubscriptionFeeServiceImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|18:34
 * @Version SubscriptionFeeServiceImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class SubscriptionFeeServiceImpl implements SubscriptionFeeService {

    private final SubscriptionFeeDAO dao;

    @Override
    public SubscriptionFee findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public SubscriptionFee updateById(Long id, SubscriptionFee entityObj) {
        entityObj.setModified_at(Date.from(Instant.now()));
        return dao.updateById(id, entityObj);
    }

    @Override
    public SubscriptionFee create(SubscriptionFee entityObj) {
        entityObj.setCreated_at(Date.from(Instant.now()));
        entityObj.setModified_at(Date.from(Instant.now()));
        return dao.create(entityObj);
    }

    @Override
    public SubscriptionFee deleteById(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public List<SubscriptionFee> findAll() {
        return dao.findAll();
    }
}
