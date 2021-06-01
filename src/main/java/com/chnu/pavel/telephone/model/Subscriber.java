package com.chnu.pavel.telephone.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @Transient
    public static final String SEQUENCE_NAME = "subscribers";

    @Id
    private Long id;
    private String fullName;
    private Gender gender;
    private LocalDate dateOfBirth;
    private PrivilegeType privilegeType;
    @DBRef
    private ConnectedPhone connectedPhone;
    private boolean intercityAccess;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

}
