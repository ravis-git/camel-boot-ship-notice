package com.example.camelboothello.routes

import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component

/**
 * Created by ravipalakodeti on 11/9/17.
 */
@Component
class HelloRoute { //extends RouteBuilder {

   // @Override
    void configure() throws Exception {
        from('timer:foo')
            .to('log:bar')
    }
}
