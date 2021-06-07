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
 * TelephoneSystem.Agency
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 14.03.2021|23:23
 * @Version Agency: 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "agencies")
public class Agency {

    @Transient
    public static final String SEQUENCE_NAME = "agencies";

    @Id
    private Long id;
    private String name;
    @DBRef
    @Field("ownerId")
    private Subscriber owner;
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
