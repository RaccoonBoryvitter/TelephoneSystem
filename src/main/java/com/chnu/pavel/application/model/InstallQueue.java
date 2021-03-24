package com.chnu.pavel.application.model;

import lombok.*;
import org.springframework.data.annotation.Id;

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
public class InstallQueue {

    @Id
    private String          id;
    private int             order;
    private String          queueType;
    private LocalDateTime   installationTime;
    private String          cableAvailability;
    private String          channelAvailability;
    private PhoneNumber     phoneNumberAvailability;
    private float           cost;

}
