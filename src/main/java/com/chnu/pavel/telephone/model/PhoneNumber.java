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

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.PhoneNumber
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 10.03.2021|22:22
 * @Version PhoneNumber: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "phoneNumbers")
public class PhoneNumber {

    @Transient
    public static final String SEQUENCE_NAME = "phoneNumbers";

    @Id
    private Long id;
    private String number;
    @DBRef
    @Field("addressId")
    private Address address;
    @DBRef
    @Field("telephoneExchangeId")
    private TelephoneExchange telephoneExchange;

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
