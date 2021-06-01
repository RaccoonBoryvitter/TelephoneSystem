package com.chnu.pavel.telephone.helper;

import com.chnu.pavel.telephone.model.DbSequence;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.SequenceGeneratorService
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 02.06.2021|1:35
 * @Version SequenceGeneratorService: 1.0
 */

@Service
@RequiredArgsConstructor
public class SequenceGeneratorService {

    private final MongoOperations operations;

    public Long getSequenceNumber(String sequenceName) {
        Query query = new Query(Criteria.where("_id").is(sequenceName));
        Update update = new Update().inc("seqNo", 1);

        DbSequence counter = operations.findAndModify(query, update,
                FindAndModifyOptions.options().returnNew(true).upsert(true),
                DbSequence.class);

        return !Objects.isNull(counter) ? counter.getSeqNo() : 1;
    }

}
