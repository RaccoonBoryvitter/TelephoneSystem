package com.chnu.pavel.telephone.model;

import lombok.*;
import org.apache.tomcat.jni.Local;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.Region
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 25.03.2021|09:07
 * @Version Region: 1.0
 */

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "provinces")
public class Province {

    @Id
    private String id;
    private String name;
    private String phoneCode;
    private State  state;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    @Nullable
    private String description;

}

