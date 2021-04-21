package com.chnu.pavel.telephone.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

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
@Document(collection = "subscribers")
public class Subscriber {

    @Id
    private String            id;
    private String            fullName;
    private String            gender;
    private String         dateOfBirth;
    private String     privilegeType;
    @DBRef
    private PhoneNumber       phoneNumber;
    private boolean           intercityAccess;

}
