package com.chnu.pavel.application.model;

import lombok.*;
import org.springframework.data.annotation.Id;

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
@ToString
public class CallDetailsRecord {

    @Id
    private String              id;
    private PhoneNumber         from;
    private PhoneNumber         to;
    private LocalTime           startedAt;
    private LocalTime           finishedAt;
    private ConversationType    conversationType;
    private TelephoneExchange   telephoneExchange;

}
