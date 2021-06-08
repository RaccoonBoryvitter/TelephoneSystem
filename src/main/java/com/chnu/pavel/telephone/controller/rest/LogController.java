package com.chnu.pavel.telephone.controller.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.LogController
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 08.06.2021|7:53
 * @Version LogController: 1.0
 */

@RestController
@Slf4j
public class LogController {

    @RequestMapping("/api/")
    public String index() {
        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");

        return "Howdy! Check out the Logs to see the output...";
    }

}
