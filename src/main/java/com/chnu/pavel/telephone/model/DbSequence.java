package com.chnu.pavel.telephone.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.DbSequence
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 01.06.2021|19:49
 * @Version DbSequence: 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "DbSequence")
public class DbSequence {

    @Id
    private String id;
    private Long seqNo;

}
