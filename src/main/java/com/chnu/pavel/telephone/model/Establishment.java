package com.chnu.pavel.telephone.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.Establishment
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 14.03.2021|23:24
 * @Version Establishment: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Document(collection = "establishments")
public class Establishment {

    @Transient
    public static final String SEQUENCE_NAME = "establishments";

    @Id
    private Long id;
    private String name;
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
