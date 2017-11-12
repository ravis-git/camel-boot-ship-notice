package com.example.camelboothello.processor

import com.example.camelboothello.model.ShipNotice
import groovy.util.logging.Slf4j

/**
 * Created by ravipalakodeti on 11/11/17.
 *
 *  This is the default vehicle processor. This class is then overloaded to add business logic for specific makes
 */
@Slf4j
class DefaultShipNoticeProcessor {

    def processDefaultShipNotice(ShipNotice shipNotice) {
        log.info("Processing ship notice for make: ${shipNotice.customer}, notice numner: ${shipNotice.asnNumber}")
    }
}
