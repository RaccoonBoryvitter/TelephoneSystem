package com.chnu.pavel.telephone.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.PrivilegeInstallationQueue
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 10.03.2021|11:32
 * @Version PrivilegeInstallationQueue: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Document(collection = "installQueue")
public class InstallmentApplication {

    @Transient
    public static final String SEQUENCE_NAME = "installQueue";

    @Id
    private Long id;
    private String applierFullName;
    private Gender applierGender;
    private LocalDate applierBirthDay;
    private PrivilegeType applierPrivilegeType;
    private int order;
    private QueueType queueType;
    private LocalDateTime installationTime;
    private boolean cableAvailability;
    private boolean channelAvailability;
    @DBRef
    private AvailablePhoneNumber availableNumber;
    private double cost;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @DateTimeFormat(style="yyyy-MM-dd HH:mm:ss.SSS")
    @Field("createdAt")
    private Date created_at;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @DateTimeFormat(style="yyyy-MM-dd HH:mm:ss.SSS")
    @Field("modifiedAt")
    private Date modified_at;
    private String description;

}
