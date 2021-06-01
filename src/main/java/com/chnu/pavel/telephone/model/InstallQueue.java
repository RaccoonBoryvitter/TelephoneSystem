package com.chnu.pavel.telephone.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
public class InstallQueue {

    @Id
    private String                   id;
    private String                   applierFullName;
    private int                      order;
    private QueueType                queueType;
    private LocalDateTime            installationTime;
    private boolean                  cableAvailability;
    private boolean                  channelAvailability;
    @DBRef
    private AvailablePhoneNumber     availableNumber;
    private double                   cost;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    @Nullable
    private String description;

}
