package com.chnu.pavel.telephone.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

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
public class ConnectedPhone {

    @Id
    private String id;
    @DBRef
    private Phone phone;
    @DBRef
    private PhoneNumber phoneNumber;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    @Nullable
    private String description;

}
