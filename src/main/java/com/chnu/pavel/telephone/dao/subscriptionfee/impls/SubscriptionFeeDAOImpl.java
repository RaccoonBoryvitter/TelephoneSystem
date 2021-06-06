package com.chnu.pavel.telephone.dao.subscriptionfee.impls;

import com.chnu.pavel.telephone.dao.subscriptionfee.interfaces.SubscriptionFeeDAO;
import com.chnu.pavel.telephone.model.Penalty;
import com.chnu.pavel.telephone.model.SubscriptionFee;
import com.chnu.pavel.telephone.repository.subscriber.SubscriberRepository;
import com.chnu.pavel.telephone.repository.subscriptionfee.SubscriptionFeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.SubscriptionFeeDAOImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|17:18
 * @Version SubscriptionFeeDAOImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class SubscriptionFeeDAOImpl implements SubscriptionFeeDAO {

    private final SubscriptionFeeRepository repository;

    @Override
    public SubscriptionFee findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public SubscriptionFee create(SubscriptionFee entityObj) {
        return repository.insert(entityObj);
    }

    @Override
    public SubscriptionFee updateById(Long id, SubscriptionFee entityObj) {
        SubscriptionFee upToDate = findById(id);
        upToDate.setLocalCallsCost(entityObj.getLocalCallsCost());
        upToDate.setIntercityCallsCost(entityObj.getIntercityCallsCost());
        upToDate.setModified_at(entityObj.getModified_at());
        upToDate.setDescription(entityObj.getDescription());
        return repository.save(upToDate);
    }

    @Override
    public SubscriptionFee deleteById(Long id) {
        SubscriptionFee deleted = findById(id);
        repository.deleteById(id);
        if(!repository.findById(id).isPresent()) return deleted;
        else return null;
    }

    @Override
    public List<SubscriptionFee> findAll() {
        return repository.findAll();
    }
}
