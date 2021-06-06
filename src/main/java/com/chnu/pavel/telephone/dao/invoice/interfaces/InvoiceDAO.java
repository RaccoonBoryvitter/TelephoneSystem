package com.chnu.pavel.telephone.dao.invoice.interfaces;

import com.chnu.pavel.telephone.dao.GenericDAO;
import com.chnu.pavel.telephone.model.Invoice;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.InvoiceDAO
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|17:21
 * @Version InvoiceDAO: 1.0
 */

@Repository
public interface InvoiceDAO extends GenericDAO<Invoice> {
}
