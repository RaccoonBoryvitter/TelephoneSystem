package com.chnu.pavel.application.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.time.LocalTime;

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
public class CallDetailRecord {

    @Id
    private String              id;
    private PhoneNumber         from;
    private PhoneNumber         to;
    private LocalDateTime       startedAt;
    private LocalDateTime       finishedAt;
    private ConversationType    conversationType;
    private TelephoneExchange   telephoneExchange;

}
