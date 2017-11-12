package com.example.camelboothello.processor

import com.example.camelboothello.model.ShipNotice
import groovy.util.logging.Slf4j

import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

/**
 * Created by ravipalakodeti on 11/11/17.
 *
 *  This is the default vehicle processor. This class is then overloaded to add business logic for specific makes
 */
@Slf4j
class DefaultShipNoticeProcessor {

    def processDefaultShipNotice(ShipNotice shipNotice) {


        log.info("make: ${shipNotice.customer}, ASN number: ${shipNotice.asnNumber}, msgTime: ${shipNotice.messageTime}" +
                " Duration: ${Duration.between(Instant.parse(shipNotice.getMessageTime()), Instant.now()).toMillis()}")

    }
}
