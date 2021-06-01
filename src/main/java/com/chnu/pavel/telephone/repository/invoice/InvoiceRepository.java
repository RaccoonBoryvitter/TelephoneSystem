package com.chnu.pavel.telephone.repository.invoice;

import com.chnu.pavel.telephone.model.Invoice;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.InvoiceRepository
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 29.03.2021|02:42
 * @Version InvoiceRepository: 1.0
 */

@Repository
public interface InvoiceRepository extends MongoRepository<Invoice, Long> {

    @Query("{ 'totalCost' : {$gt : ?0} }")
    List<Invoice> findAllInvoicesWhenTotalCostGreaterThanNumber(double cost);

    @Query("{ 'totalCost' : {$lt : ?0} }")
    List<Invoice> findAllInvoicesWhenTotalCostLessThanNumber(double cost);
}
