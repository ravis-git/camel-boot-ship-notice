package com.example.camelboothello.model

import groovy.transform.builder.Builder
import groovy.transform.builder.ExternalStrategy

/**
 * Created by ravipalakodeti on 11/9/17.
 */

class ShipNotice {

    def Integer asnNumber
    def String customer
}

@Builder(builderStrategy = ExternalStrategy, forClass = ShipNotice,
            buildMethodName = 'create', includes = 'asnNumber, customer')
class ShipNoticeBuilder{}
