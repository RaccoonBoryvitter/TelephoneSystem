package com.chnu.pavel.telephone.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.Role
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|5:22
 * @Version Role: 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "roles")
public class Role {

    @Id
    private Long id;
    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
    private String role;

}
