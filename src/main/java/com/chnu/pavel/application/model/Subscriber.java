package com.chnu.pavel.application.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.PrivilegeSubscriber
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 10.03.2021|11:32
 * @Version PrivilegeSubscriber: 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Subscriber {

    @Id
    private String            id;
    private String            fullName;
    private String            gender;
    private LocalDate         dateOfBirth;
    private PrivilegeType     privilegeType;
    private PhoneNumber       phoneNumber;
    private boolean           longDistanceAccess;

}
