package com.chnu.pavel.telephone.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
 * TelephoneSystem.PhoneList
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 26.05.2021|18:44
 * @Version PhoneList: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "connectedPhones")
public class ConnectedPhone {

    @Transient
    public static final String SEQUENCE_NAME = "connectedPhones";

    @Id
    private Long id;
    @DBRef
    @Field("phoneId")
    private Phone phone;
    @DBRef
    @Field("numberId")
    private PhoneNumber phoneNumber;

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
