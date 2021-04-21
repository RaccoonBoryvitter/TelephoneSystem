package com.chnu.pavel.telephone.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.CallRecord
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 10.03.2021|11:30
 * @Version CallRecord: 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "callDetailRecords")
public class CallDetailRecord {

    @Id
    private String              id;
    @DBRef
    private PhoneNumber         from;
    @DBRef
    private PhoneNumber         to;
    private LocalDateTime       startedAt;
    private LocalDateTime       finishedAt;
    private ConversationType    conversationType;
    @DBRef
    private TelephoneExchange   telephoneExchange;

}
