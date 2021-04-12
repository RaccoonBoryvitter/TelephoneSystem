package com.chnu.pavel.telephone.repository.invoice;

import com.chnu.pavel.telephone.model.Invoice;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.InvoiceRepository
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 29.03.2021|02:42
 * @Version InvoiceRepository: 1.0
 */

@Repository
public interface InvoiceRepository extends MongoRepository<Invoice, ObjectId> {
}
