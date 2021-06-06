package com.chnu.pavel.telephone.service.invoice.impls;

import com.chnu.pavel.telephone.dao.invoice.interfaces.InvoiceDAO;
import com.chnu.pavel.telephone.model.Invoice;
import com.chnu.pavel.telephone.service.invoice.interfaces.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.InvoiceServiceImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|18:36
 * @Version InvoiceServiceImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceDAO dao;

    @Override
    public Invoice findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public Invoice updateById(Long id, Invoice entityObj) {
        entityObj.setModified_at(Date.from(Instant.now()));
        return dao.updateById(id, entityObj);
    }

    @Override
    public Invoice create(Invoice entityObj) {
        entityObj.setCreated_at(Date.from(Instant.now()));
        entityObj.setModified_at(Date.from(Instant.now()));
        return dao.create(entityObj);
    }

    @Override
    public Invoice deleteById(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public List<Invoice> findAll() {
        return dao.findAll();
    }
}
