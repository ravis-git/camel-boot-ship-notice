package com.example.camelboothello.routes

import com.example.camelboothello.model.ShipNotice
import com.example.camelboothello.processor.ShipNoticeLogProcessor
import org.apache.camel.Exchange
import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component

/**
 * Created by ravipalakodeti on 11/11/17.
 */
@Component
class SingleNoticeProessingRoute extends RouteBuilder {

    @Override
    void configure() throws Exception {
        from('seda:singleAsnChannel')
            .choice()
                .when()
                    .jsonpath('$.[?(@.customer == "FORD")]')
                .to('seda:fordChannel')
    }
}
