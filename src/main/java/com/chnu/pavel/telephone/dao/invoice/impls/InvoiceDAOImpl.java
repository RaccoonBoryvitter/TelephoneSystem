package com.chnu.pavel.telephone.dao.invoice.impls;

import com.chnu.pavel.telephone.dao.invoice.interfaces.InvoiceDAO;
import com.chnu.pavel.telephone.model.Invoice;
import com.chnu.pavel.telephone.model.SubscriptionFee;
import com.chnu.pavel.telephone.repository.invoice.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.InvoiceDAOImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|17:21
 * @Version InvoiceDAOImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class InvoiceDAOImpl implements InvoiceDAO {

    private final InvoiceRepository repository;

    @Override
    public Invoice findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Invoice create(Invoice entityObj) {
        return repository.insert(entityObj);
    }

    @Override
    public Invoice updateById(Long id, Invoice entityObj) {
        Invoice upToDate = findById(id);
        upToDate.setSubscriber(upToDate.getSubscriber());
        upToDate.setSubscriptionFee(upToDate.getSubscriptionFee());
        if(entityObj.getPenalty() != null) upToDate.setPenalty(entityObj.getPenalty());
        upToDate.setTotalCost(entityObj.getTotalCost());
        upToDate.setModified_at(entityObj.getModified_at());
        upToDate.setDescription(entityObj.getDescription());
        return repository.save(upToDate);
    }

    @Override
    public Invoice deleteById(Long id) {
        Invoice deleted = findById(id);
        repository.deleteById(id);
        if(!repository.findById(id).isPresent()) return deleted;
        else return null;
    }

    @Override
    public List<Invoice> findAll() {
        return repository.findAll();
    }
}
