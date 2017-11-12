package com.example.camelboothello.routes

import org.apache.camel.builder.RouteBuilder
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

/**
 * Created by ravipalakodeti on 11/9/17.
 */
@Component
class ShipNoticeRoute extends RouteBuilder {

    private static final Logger slf4jLogger = LoggerFactory.getLogger(ShipNoticeRoute.class)
    @Override
    void configure() throws Exception {
        from('seda:newAsnChannel')
            // the route is processed in streaming mode and does not wait for the entire batch to complete
            .streamCaching()
            .split(body())
                .to('seda:singleAsnChannel')
    }
}
