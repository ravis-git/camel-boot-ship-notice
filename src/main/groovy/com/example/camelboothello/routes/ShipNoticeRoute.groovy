package com.example.camelboothello.routes

import com.example.camelboothello.processor.ShipNoticeLogProcessor
import org.apache.camel.Exchange
import org.apache.camel.LoggingLevel
import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component

/**
 * Created by ravipalakodeti on 11/9/17.
 */
@Component
class ShipNoticeRoute extends RouteBuilder {

    @Override
    void configure() throws Exception {
        from('seda:newAsnChannel')
            .log(LoggingLevel.INFO, "===== Received ASNs ===== ")
            .bean(ShipNoticeLogProcessor.class, 'logShipNoticesInBatch')
    }
}
