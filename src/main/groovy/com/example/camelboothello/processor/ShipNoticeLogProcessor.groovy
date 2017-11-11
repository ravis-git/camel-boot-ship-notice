package com.example.camelboothello.processor

import com.example.camelboothello.model.ShipNotice
import groovy.util.logging.Slf4j
import org.apache.camel.Processor

/**
 * Created by ravipalakodeti on 11/10/17.
 */
@Slf4j
class ShipNoticeLogProcessor {

    def logShipNoticesInBatch(Collection<ShipNotice> shipNoticesCollection) {
        shipNoticesCollection.each {
            log.info("Notice received for asnNumber: ${it.asnNumber}")
        }
    }
}